package com.example.poplib.di

import com.example.poplib.di.user.UserSubcomponent
import com.example.poplib.mvp.presenter.MainPresenter
import com.example.poplib.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DatabaseModule::class,
        CiceroneModule::class,
        ImageModule::class
    ]
)
interface AppComponent {
    fun userSubcomponent() : UserSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}