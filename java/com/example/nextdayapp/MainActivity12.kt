package com.example.nextdayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nextdayapp.databinding.ActivityMain12Binding

class MainActivity12 : AppCompatActivity()
{

    private lateinit var binding: ActivityMain12Binding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 0
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 0
        binding.heightPicker.maxValue = 250

        binding.weightPicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }

        binding.heightPicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }

    }

    private fun calculateBMI()
    {
        val height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value

        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.resultsTV.text = String.format("Your BMI is: %.2f", bmi)
        binding.healthyTV.text = String.format("Considered: %s", healthyMessage(bmi))

    }

    private fun healthyMessage(bmi: Double): String
    {
        if (bmi < 18.5)
            return "Underweight"
        if(bmi < 25.0)
            return "Healthy"
        if (bmi < 30.0)
            return "Overweight"

        return "Obese"
    }
}