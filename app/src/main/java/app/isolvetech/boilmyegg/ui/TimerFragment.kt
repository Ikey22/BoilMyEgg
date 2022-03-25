package app.isolvetech.boilmyegg.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import app.isolvetech.boilmyegg.R
import app.isolvetech.boilmyegg.databinding.FragmentTimerBinding


class TimerFragment : Fragment() {


    private val TOPIC = "breakfast"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentTimerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_timer, container, false
        )

        val viewModel = ViewModelProviders.of(this)[TimerViewModel::class.java]

        binding.eggTimerViewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        createChannel(getString(R.string.egg_notification_channel_id), getString(R.string.egg_notification_channel_name))

        return binding.root
    }

    private fun createChannel(channelId: String, channelName: String) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                setShowBadge(false)
            }

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(true)
            notificationChannel.description = "This notification is working"

            val notificationManager = requireActivity().getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }

    }

    companion object {
        fun newInstance() = TimerFragment()
    }


}