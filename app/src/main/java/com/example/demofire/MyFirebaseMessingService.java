package com.example.demofire;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.e("TAG","From" + remoteMessage.getFrom());


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "AppDemome")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Demo me")
                .setContentText(remoteMessage.getNotification().getTitle())
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(remoteMessage.getNotification().getBody()))
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        if(remoteMessage.getData().size() > 0){
            Log.e("TAG","Message Data payload" + remoteMessage.getData());
        }
        if (remoteMessage.getNotification() != null) {
            Log.e("TAG","Message Notification Body" + remoteMessage.getNotification().getBody());
        }
    }
}


