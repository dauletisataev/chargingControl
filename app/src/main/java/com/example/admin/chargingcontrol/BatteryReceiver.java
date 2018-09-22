package com.example.admin.chargingcontrol;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BatteryReceiver  extends BroadcastReceiver {
    BluetoothSocket clientSocket;
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        if(level == 100) {
            showNotification(context, level);
            BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
            try{
                BluetoothDevice device = bluetooth.getRemoteDevice("00:13:02:01:00:09");
                Method m = device.getClass().getMethod(
                        "createRfcommSocket", new Class[] {int.class});

                clientSocket = (BluetoothSocket) m.invoke(device, 1);
                clientSocket.connect();
            } catch (IOException e) {
                Log.d("BLUETOOTH", e.getMessage());
            } catch (SecurityException e) {
                Log.d("BLUETOOTH", e.getMessage());
            } catch (NoSuchMethodException e) {
                Log.d("BLUETOOTH", e.getMessage());
            } catch (IllegalArgumentException e) {
                Log.d("BLUETOOTH", e.getMessage());
            } catch (IllegalAccessException e) {
                Log.d("BLUETOOTH", e.getMessage());
            } catch (InvocationTargetException e) {
                Log.d("BLUETOOTH", e.getMessage());
            }
            try {
                OutputStream outStream = clientSocket.getOutputStream();
                int value = 0;
                outStream.write(value);

            } catch (IOException e) {
                //Если есть ошибки, выводим их в лог
                Log.d("BLUETOOTH", e.getMessage());
            }
        }
    }
    private void showNotification(Context context, int level) {
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Battery is charged")
                        .setContentText("Charging is stopped");
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }
}
