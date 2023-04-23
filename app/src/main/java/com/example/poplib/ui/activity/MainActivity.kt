package com.example.poplib.ui.activity

import android.os.Bundle
import com.example.poplib.ui.App
import com.example.poplib.ui.BackButtonListener
import com.example.poplib.R
import com.example.poplib.databinding.ActivityMainBinding
import com.example.poplib.mvp.presenter.MainPresenter
import com.example.poplib.mvp.view.MainView
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter {
        MainPresenter(
            App.instance.router,
        )
    }
    private var vb: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {//просто вызов метода backPressed() у первого попавшегося фрагмента в стеке
                return
            }
        }

        presenter.backClicked()// если не встретили фрагмент, сообщаем presenter у о необходимости обработать нажатие назад
    }
}
