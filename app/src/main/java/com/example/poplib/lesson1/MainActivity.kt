package com.example.poplib.lesson1

import android.os.Bundle
import com.example.poplib.R
import com.example.poplib.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), Contract.MainView{
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { PresenterImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners(){
        with(binding){
            btnCounter1.setOnClickListener{presenter.clickButton1()}
            btnCounter2.setOnClickListener{presenter.clickButton2()}
            btnCounter3.setOnClickListener{presenter.clickButton3()}


        }
    }


    override fun setValueButton1(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setValueButton2(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setValueButton3(text: String) {
        binding.btnCounter3.text = text
    }
}