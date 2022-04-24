package com.arbaz.evinix.notification;

import android.app.Notification;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.arbaz.evinix.NotificationApp;
import com.arbaz.evinix.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class NotificationActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;

    private EditText editTextTitle;
    private EditText editTextMessage;

    private Button button1;
    private Button button2;
    TextView textView;

    private static Uri alarmsound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);






        this.editTextTitle = (EditText) this.findViewById(R.id.editText_title);
        this.editTextMessage = (EditText) this.findViewById(R.id.editText_message);

        this.button1 = (Button) this.findViewById(R.id.button1);





















        this.button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                sendOnChannel1();
                sendOnChannel1();
                sendOnChannel1();
                sendOnChannel1();
                sendOnChannel1();
                sendOnChannel1();


            }
        });



        //
        this.notificationManagerCompat = NotificationManagerCompat.from(this);
    }


    private void sendOnChannel1()  {
        String title = this.editTextTitle.getText().toString();
        String message = this.editTextMessage.getText().toString();



        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.icon_notify1)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(new long[]{1000, 1000})
                .setSound(alarmsound)
                .build();


        int notificationId = 1;
        this.notificationManagerCompat.notify(1, notification);

    }

    private void sendOnChannel2()  {
        String title = this.editTextTitle.getText().toString();
        String message = this.editTextMessage.getText().toString();


        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.icon_notify2)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setVibrate(new long[] { 1000, 1000})
                .build(); // Promotion.



        int notificationId = 2;
        this.notificationManagerCompat.notify(notificationId, notification);

    }
}