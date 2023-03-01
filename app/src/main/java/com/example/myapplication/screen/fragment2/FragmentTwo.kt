package com.example.myapplication.screen.fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.core.model.InputNumber
import com.example.myapplication.core.pattern.BootStrap
import com.example.myapplication.databinding.FragmentTwoBinding

class FragmentTwo(
    private val input: InputNumber
) : Fragment(), BootStrap {
    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(
            layoutInflater,
            container,
            false
        )

        initUI()
        initAction()
        return binding.root
    }

    override fun initUI() {
        displayGreatestNumber()
    }

    override fun initAction() {

    }

    private fun displayGreatestNumber() {
        val greatestNumber = input.toList().maxOf { it }
        binding.tvOne.text = "Nilai paling besar adalah $greatestNumber"

        val sortedNumber =
            input.toList()
                .sorted()
                .fold("") { r, l ->
                    "$r $l"
                }

        binding.tvTwo.text = "Urutan dari yang terkecil adalah $sortedNumber"

    }
}