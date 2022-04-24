package com.arbaz.evinix.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.arbaz.evinix.R;
import com.arbaz.evinix.image;
import com.arbaz.evinix.imageAdapter;
import com.arbaz.evinix.notification.NotificationActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import bottomsheet_frag.BottomSheetFragment;


public class HomeFragment extends Fragment {

    CardView normalmode , racemode, mountainmode;
    private ViewPager2 viewPager2;
    private List<image> imageList;
    private imageAdapter adapter;
    private Handler sliderHandler = new Handler();



    private FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView nameet,modell,enginee;
    FirebaseUser firebaseUser;
    ImageView alert_notif;


    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        normalmode = view.findViewById(R.id.normal_mode_cv);
        racemode = view.findViewById(R.id.race_mode_cv);
        mountainmode = view.findViewById(R.id.mountain_mode_cv);
        viewPager2 = view.findViewById(R.id.viewpager2);
        alert_notif = view.findViewById(R.id.alert_notif);
        imageList = new ArrayList<>();



        nameet = view.findViewById(R.id.nameet);
        modell = view.findViewById(R.id.modell);
        enginee = view.findViewById(R.id.enginee);
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
                        String modelll = "" + dataSnapshot.child("model").getValue();
                        String engineee = "" + dataSnapshot.child("engine").getValue();

                        nameet.setText(name);
                        modell.setText(modelll);
                        enginee.setText(engineee);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else{
            nameet.setText("null");
            modell.setText("null");
            enginee.setText("null");
        }


















alert_notif.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Intent intent = new Intent(getContext(), NotificationActivity.class);
startActivity(intent);
    }
});

















        normalmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
//                bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());

                Intent i = new Intent(getActivity(), BottomSheetFragment.class);
                i.putExtra("key", "Your value1");
                i.putExtra("key2", "Your value2");
                i.putExtra("key3", "Your value3");
//                getActivity().startActivity(i);
                bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());
            }
        });

        racemode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        mountainmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());

            }
        });

















        imageList.add(new image(R.drawable.bikead));
        imageList.add(new image(R.drawable.bikead1));
        imageList.add(new image(R.drawable.bikead2));

        adapter = new imageAdapter(imageList, viewPager2);
        viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000);
            }
        });

        return view;
    }



    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable,2000);
    }




}