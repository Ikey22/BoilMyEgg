package app.isolvetech.boilmyegg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.isolvetech.boilmyegg.ui.TimerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TimerFragment.newInstance())
                .commitNow()
        }
    }
}