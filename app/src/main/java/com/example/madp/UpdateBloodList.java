package com.example.madp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UpdateBloodList extends AppCompatActivity {

    Button button1 , button2;
    Spinner at,bt,ct,dt,et,ft,gt,ht;
    EditText hospital,city,contact;
    Add add;
    DatabaseReference Ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_blood_list);


        button1 = findViewById(R.id.update);
        button2 = findViewById(R.id.cancel);

        at = findViewById(R.id.aSpinner);
        bt = findViewById(R.id.bSpinner);
        ct = findViewById(R.id.cSpinner);
        dt = findViewById(R.id.dSpinner);
        et = findViewById(R.id.eSpinner);
        ft = findViewById(R.id.fSpinner);
        gt = findViewById(R.id.gSpinner);
        ht = findViewById(R.id.hSpinner);
        hospital = findViewById(R.id.hospital);
        city = findViewById(R.id.city);
        contact = findViewById(R.id.contact);

        String as = getIntent().getStringExtra("aa");
        String bs = getIntent().getStringExtra("bb");
        String cs = getIntent().getStringExtra("cc");
        String ds = getIntent().getStringExtra("dd");
        String es = getIntent().getStringExtra("ee");
        String fs = getIntent().getStringExtra("ff");
        String gs = getIntent().getStringExtra("gg");
        String hs = getIntent().getStringExtra("hh");
        String hos = getIntent().getStringExtra("hospital");
        String cit = getIntent().getStringExtra("city");
        String con = getIntent().getStringExtra("contact");

        at.setSelected(Boolean.parseBoolean(as));
        bt.setSelected(Boolean.parseBoolean(bs));
        ct.setSelected(Boolean.parseBoolean(cs));
        dt.setSelected(Boolean.parseBoolean(ds));
        et.setSelected(Boolean.parseBoolean(es));
        ft.setSelected(Boolean.parseBoolean(fs));
        gt.setSelected(Boolean.parseBoolean(gs));
        ht.setSelected(Boolean.parseBoolean(hs));
        hospital.setText(hos);
        city.setText(cit);
        contact.setText(con);

      /*  DatabaseReference Ref = FirebaseDatabase.getInstance().getReference().child("add");
        Ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("1")){
                    try{
                        add.Set
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });  */


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a = at.getSelectedItem().toString();
                String b = bt.getSelectedItem().toString();
                String c = ct.getSelectedItem().toString();
                String d = dt.getSelectedItem().toString();
                String e = et.getSelectedItem().toString();
                String f = ft.getSelectedItem().toString();
                String g = gt.getSelectedItem().toString();
                String h = ht.getSelectedItem().toString();
                String contactt = contact.getText().toString();

                Ref = FirebaseDatabase.getInstance().getReference().child("add");

                HashMap hashMap = new HashMap();



                hashMap.put("a_plus",a);
                hashMap.put("a_minus",b);
                hashMap.put("b_plus",c);
                hashMap.put("b_minus",d);
                hashMap.put("ab_plus",e);
                hashMap.put("ab_minus",f);
                hashMap.put("o_plus",g);
                hashMap.put("o_minus",h);
                hashMap.put("contact",contactt);

                Ref.child("1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Successfully Updated",Toast.LENGTH_LONG).show();
                       /* Intent i = new Intent(getApplicationContext(),Details.class);
                        startActivity(i); */
                    }
                });

            }
        });
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"Details Updated",Toast.LENGTH_LONG);
        toast.show();
    }
}