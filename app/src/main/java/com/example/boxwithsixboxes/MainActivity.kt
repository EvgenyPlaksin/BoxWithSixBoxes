package com.example.boxwithsixboxes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.boxwithsixboxes.fragments.RealSixBoxFragment
import com.example.boxwithsixboxes.fragments.fourBoxFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_four_box.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.conteiner, fourBoxFragment()).commit()
        val anim = AnimationUtils.loadAnimation(this, R.anim.anim)
        val antianim = AnimationUtils.loadAnimation(this, R.anim.antianim)
        var six: Boolean = false
        conteiner.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                conteiner.startAnimation(anim)
                android.os.Handler().postDelayed({ supportFragmentManager.beginTransaction().replace(R.id.conteiner,
                    RealSixBoxFragment()
                ).commit() },
                    390)
            six = true
            }
        })
        clicker.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                if(six) {
                    conteiner.startAnimation(antianim)
                    android.os.Handler().postDelayed({supportFragmentManager.beginTransaction()
                        .replace(R.id.conteiner, fourBoxFragment()).commit()},
                        300)
                    six = false
                }
            }
        })
    }
}