package io.github.luteoos.booker.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.luteoos.booker.R
import io.github.luteoos.booker.viewmodel.LogInViewModel
import io.github.luteoos.mvvmbaselib.BaseActivityMVVM
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : BaseActivityMVVM<LogInViewModel>() {

    override fun getLayoutID(): Int = R.layout.activity_log_in

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentContainer.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commitAllowingStateLoss()
    }
}