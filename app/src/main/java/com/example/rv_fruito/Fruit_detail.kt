package com.example.rv_fruito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_fruit_detail.*

class Fruit_detail : AppCompatActivity() {
    private lateinit var obj:FruitData
    private var fruitImg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_detail)

        window.decorView.apply { systemUiVisibility =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN }

        obj = intent.getParcelableExtra("fruit")!!
        fruitImg = intent.getIntExtra("fruitImage",-1)
        setData(obj,fruitImg!!)

        button_info.setOnClickListener{
            val intent = Intent(this,finalActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setData(obj: FruitData, fruitImg:Int){
        idtitle_info.text = obj.title
        idQuality_info.text = obj.quality
        overview_info.text = obj.overview
        fruit_img_info.setImageResource(fruitImg)
    }

}