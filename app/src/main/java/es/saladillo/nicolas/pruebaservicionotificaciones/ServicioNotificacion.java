package es.saladillo.nicolas.pruebaservicionotificaciones;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.nfc.NfcAdapter.EXTRA_DATA;

public class ServicioNotificacion extends JobIntentService {

    private static final int JOB_ID = 7;
    private static final int NOTIFICATION_ID = 9001;

    public static void start(Context context) {
        Intent intent = new Intent(context, ServicioNotificacion.class);
        enqueueWork(context, ServicioNotificacion.class, JOB_ID, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, Constants.DEFAULT_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_whatshot_black_24dp)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());

//        NotificationCompat.Builder notif = new NotificationCompat.Builder(this, Constants.DEFAULT_CHANNEL_ID);
//        notif.setSmallIcon(R.drawable.ic_whatshot_black_24dp)
//                .setContentTitle("HijuePuta MalPario")
//                .setContentText("CaguenTo")
//                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
//                .setAutoCancel(true);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//        notificationManager.notify(NOTIFICATION_ID, notif.build());


    }
}
