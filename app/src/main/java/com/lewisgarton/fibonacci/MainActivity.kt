package com.lewisgarton.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Observe viewModel for display string and update
        viewModel.sequenceOutputStr.observe(this, Observer {
            tv_fibonacci.text = it
        })

        // Observe fibGeneratorReset and toast user on maxInt reset
        viewModel.hasGeneratorReset.observe(this, Observer {
            if(it) {
                Toast.makeText(applicationContext,R.string.generator_reset_toast,Toast.LENGTH_SHORT).show()
                viewModel.hasGeneratorReset.value = false
            }
        })

        // Set onclick for next button
        btnNext = findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            viewModel.nextButtonClicked()
        }
    }
}