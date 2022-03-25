

package app.isolvetech.boilmyegg.receivers

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import app.isolvetech.boilmyegg.R
import app.isolvetech.boilmyegg.util.sendNotification

class AlarmReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //Toast.makeText(context, context.getText(R.string.eggs_ready), Toast.LENGTH_SHORT).show()
        val notificationManager = ContextCompat.getSystemService(context, NotificationManager::class.java) as NotificationManager
        notificationManager.sendNotification(context.getText(R.string.eggs_ready).toString(), context)

    }

}