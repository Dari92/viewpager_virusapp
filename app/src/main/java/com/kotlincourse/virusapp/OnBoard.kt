package com.kotlincourse.virusapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlincourse.virusapp.Adapter.OnBoardAdapter
import kotlinx.android.synthetic.main.activity_main.*

class OnBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager1.adapter = OnBoardAdapter()



       /* buttonNext.setOnClickListener{
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }*/

    }
}
