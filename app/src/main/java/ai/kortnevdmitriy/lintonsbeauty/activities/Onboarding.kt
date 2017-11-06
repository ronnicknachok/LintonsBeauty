package ai.kortnevdmitriy.lintonsbeauty.activities

import ai.kortnevdmitriy.lintonsbeauty.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_onboarding.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class Onboarding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the screen fullscreen before loading the layout
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_onboarding)

        //using Kotlin Extensions to load bypass authentication
        button.text = "Log in"
        button.onClick { startActivity<Home>() }
    }
}
