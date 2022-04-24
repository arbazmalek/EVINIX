package com.arbaz.evinix.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arbaz.evinix.Adapters.NewsAdapter;
import com.arbaz.evinix.R;
import com.arbaz.evinix.databinding.FragmentNotificationsBinding;
import com.arbaz.evinix.models.news_model;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        ArrayList<news_model> newsholder;


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsholder = new ArrayList<>();

        news_model ob1 = new news_model(R.drawable.bike,"American bikemaker UM motorcycles is going to unveil","soon-to-be-launched OXO","3 hr", "USA");
        newsholder.add(ob1);
        news_model ob2 = new news_model(R.drawable.bike2,"RattanIndia-invested Revolt Motor ","Domestic premium electric","4 hr", "INDIA");
        newsholder.add(ob2);
        news_model ob3 = new news_model(R.drawable.bike3,"Revolt Motors welcomes Rajasthan EV Policy 2021","EV by 5%, besides a subsidy","5 hr", "CANADA");
        newsholder.add(ob3);
        news_model ob4 = new news_model(R.drawable.bike6,"Atum 1.0 offers a range of 100 kmph in a single charge","TVS Group-backed","6 hr", "USA");
        newsholder.add(ob4);
        news_model ob5 = new news_model(R.drawable.bike7,"The Karnataka government proposed to implement an electric bike","opted for a lithium-ion battery","3 hr", "FRANCE");
        newsholder.add(ob5);
        news_model ob6 = new news_model(R.drawable.bike8,"Under the new plan, cost before the on-road price for the RV400","Domestic premium electric","9 hr", "ITALY");
        newsholder.add(ob6);
        news_model ob7 = new news_model(R.drawable.bike9,"Manufacturing plant to have a capacity of 1 million units","soon-to-be-launched OXO","2 hr", "LONDON");
        newsholder.add(ob7);
        news_model ob8 = new news_model(R.drawable.bikead2,"American bikemaker UM motorcycles is going to unveil an","opted for a lithium-ion battery","1 hr", "GERMANY");
        newsholder.add(ob8);
        news_model ob9 = new news_model(R.drawable.bikead,"The Karnataka government proposed to implement an","soon-to-be-launched OXO","6 hr", "USA");
        newsholder.add(ob9);
        news_model ob10 = new news_model(R.drawable.bikead1,"The Austrian brand plans a range of machines for","Renewed enthusiasm","3 hr", "INDIA");
        newsholder.add(ob10);
        news_model ob11 = new news_model(R.drawable.bike13,"T6X will be introduced in three markets of Pune","Domestic premium electric","5hr", "USA");
        newsholder.add(ob11);
        news_model ob12 = new news_model(R.drawable.bike14,"RattanIndia-invested Revolt Motor","Renewed enthusiasm","4 hr", "USA");
        newsholder.add(ob12);
        news_model ob13 = new news_model(R.drawable.bike15,"Tronx Motors, a Smartron company, on Wednesday","EV by 5%, besides a subsidy","3 hr", "USA");
        newsholder.add(ob13);



        recyclerView.setAdapter(new NewsAdapter(newsholder));

        return view;
    }
}

