

package app.isolvetech.boilmyegg.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import app.isolvetech.boilmyegg.MainActivity
import app.isolvetech.boilmyegg.R
import app.isolvetech.boilmyegg.receivers.SnoozeReceiver

// Notification ID.
private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0

// TODO: Step 1.1 extension function to send messages (GIVEN)
/**
 * Builds and delivers the notification.
 *
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(message: String, context: Context) {

    val intent = Intent(context, MainActivity::class.java)

    val pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT)

    val snoozeIntent = Intent(context, SnoozeReceiver::class.java)
    val snoozePendingIntent = PendingIntent.getBroadcast(context, REQUEST_CODE, snoozeIntent, PendingIntent.FLAG_ONE_SHOT)

    val image = BitmapFactory.decodeResource(context.resources, R.drawable.cooked_egg)
    val bigPictureStyle = NotificationCompat.BigPictureStyle()
        .bigPicture(image)
        .bigLargeIcon(null)
    val builder = NotificationCompat.Builder(context, context.getString(R.string.egg_notification_channel_id))
        .setSmallIcon(R.drawable.egg_icon)
        .setContentTitle(context.getString(R.string.notification_title))
        .setContentText(message)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .setStyle(bigPictureStyle)
        .setLargeIcon(image)
        .addAction(R.drawable.egg_icon, context.getString(R.string.snooze),snoozePendingIntent )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
    notify(NOTIFICATION_ID, builder.build())





}

fun NotificationManager.cancelNotification() {
    cancelAll()
}




