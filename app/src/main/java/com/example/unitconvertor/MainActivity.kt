package com.example.unitconvertor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitconvertor.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {

            unitCalculator()

        }
    }


    @SuppressLint("SetTextI18n")
    private fun unitCalculator() {

        val textInString = binding.textInputForUnit.text.toString()
        val userInput=textInString.toDoubleOrNull()
        val selectedButton = binding.radioGroupForUnit.checkedRadioButtonId


        val result= when (selectedButton) {
            R.id.option_km_to_m -> 1000.0
            R.id.option_m_to_km -> 0.001
            R.id.option_m_to_cm -> 100.0
            R.id.option_cm_to_m -> 0.01
            R.id.option_cm_to_mm -> 10.0
            else -> 0.1
        }


        if(userInput==null){

            binding.resultFeild.text="Please enter any value"
            return
        }

        var distance=userInput*result

        binding.resultFeild.text=getString(R.string.distance_result,distance.toString())





    }
}



