package com.example.poplib.lesson2.ui.activity

import android.os.Bundle
import com.example.poplib.App
import com.example.poplib.R
import com.example.poplib.databinding.ActivityMainLesson2Binding
import com.example.poplib.lesson2.ui.screens.AndroidScreens
import com.example.poplib.lesson2.ui.fragments.BackButtonListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivityLesson2: MvpAppCompatActivity(), MainView {
    val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter { MainPresenter(
        App.instance.router,
        AndroidScreens()
    ) }
    private var vb: ActivityMainLesson2Binding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainLesson2Binding.inflate(layoutInflater)
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
            if(it is BackButtonListener && it.backPressed()){//просто вызов метода backPressed() у первого попавшегося фрагмента в стеке
                return
            }
        }

        presenter.backClicked()// если не встретили фрагмент, сообщаем presenter у о необходимости обработать нажатие назад
    }
}
