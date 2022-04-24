package com.arbaz.evinix.ui;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arbaz.evinix.LoginActivity;
import com.arbaz.evinix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Me extends Fragment {



private FirebaseAuth firebaseAuth;
FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    TextView nameet;
    FirebaseUser firebaseUser;

    LinearLayout user_ll,likeApp,help,maps,signout;


public Me(){

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        nameet = view.findViewById(R.id.nameetv);

        user_ll = view.findViewById(R.id.user_ll);
        likeApp = view.findViewById(R.id.likeApp);
        help = view.findViewById(R.id.help);
        maps = view.findViewById(R.id.maps);
        signout = view.findViewById(R.id.Signout);


        firebaseAuth = FirebaseAuth.getInstance();

        //geeting current user
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        if (firebaseUser != null) {
            databaseReference = firebaseDatabase.getReference("Users");

            Query query = databaseReference.orderByChild("mail").equalTo(firebaseUser.getEmail());

            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        String name = "" + dataSnapshot.child("userName").getValue();

                        nameet.setText(name);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else{
            nameet.setText("null's Home");
        }












        user_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        likeApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setMessage("How do you like evinix?")
                        .setPositiveButton("Love it", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "Thankyou for your support!", Toast.LENGTH_SHORT).show();
                            }
                        }).setNeutralButton("Give feedback", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gmail = new Intent(Intent.ACTION_SEND);
                        String[] email_into={"a1rbaz2344@gmail.com"};
                        gmail.putExtra(Intent.EXTRA_EMAIL,email_into);
                        gmail.setType("text/html");
                        gmail.setPackage("com.google.android.gm");
                        try{
                            startActivity(gmail);
                        }
                        catch(ActivityNotFoundException e){
                            Toast.makeText(getContext(), "Please give your valuable feedback", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
            }
        });



        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmail = new Intent(Intent.ACTION_SEND);
                String[] email_into={"a1rbaz2344@gmail.com"};
                gmail.putExtra(Intent.EXTRA_EMAIL,email_into);
                gmail.setType("text/html");
                gmail.setPackage("com.google.android.gm");
                try{
                    startActivity(gmail);
                }
                catch(ActivityNotFoundException e){
                    Toast.makeText(getContext(), "Please give your valuable feedback", Toast.LENGTH_SHORT).show();
                }
            }

        });


        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
                Intent maps = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                maps.setPackage("com.google.android.apps.maps");
                try{
                    startActivity(maps);
                }
                catch(ActivityNotFoundException e){
                    Toast.makeText(getContext(), "Locating nearby stations", Toast.LENGTH_SHORT).show();
                }

            }
        });


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
            }
        });






        return view;






    }


}