package io.github.luteoos.booker.view.activity

import android.os.Bundle
import io.github.luteoos.booker.R
import io.github.luteoos.booker.viewmodel.MainScreenViewModel
import io.github.luteoos.mvvmbaselib.BaseActivityMVVM

class MainScreenActivity : BaseActivityMVVM<MainScreenViewModel>() {

    override fun getLayoutID(): Int = R.layout.activity_main_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel(this)
    }
}
