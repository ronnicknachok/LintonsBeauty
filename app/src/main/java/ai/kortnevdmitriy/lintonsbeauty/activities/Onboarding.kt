package ai.kortnevdmitriy.lintonsbeauty.activities

import ai.kortnevdmitriy.lintonsbeauty.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_onboarding.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class Onboarding : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the screen fullscreen before loading the layout
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_onboarding)

        // custom FirebaseAnalytics Event Log
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        var bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ORIGIN, "Onboarding Screen - Sign Up")
        mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle)
        Log.d("Onboarding Screen", bundle.toString())

        // using Kotlin Extensions to load bypass authentication
        button.text = "Log in"
        button.onClick { startActivity<Home>() }
    }
}
