package com.example.myapplication.screen.fragment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.core.model.InputNumber
import com.example.myapplication.databinding.FragmentOneBinding
import com.example.myapplication.screen.fragment2.FragmentTwo

class FragmentOne : Fragment(), FragmentOneContract {
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(
            inflater, container, false
        )
        initUI()
        initAction()
        initObserver()

        return binding.root
    }


    override fun initUI() {

    }

    override fun initAction() {
        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnSubmit -> submit()
        }
    }

    private fun submit() {
        if (!validate()) {
            Toast.makeText(requireContext(), "Harap isi semua input number!", Toast.LENGTH_SHORT)
                .show()
        }

        gotoFragmentTwo()
    }

    private fun validate(): Boolean {
        return with(binding.formInput) {
            ed0.text.toString().isNotBlank()
                    && ed1.text.toString().isNotBlank()
                    && ed2.text.toString().isNotBlank()
                    && ed3.text.toString().isNotBlank()
                    && ed4.text.toString().isNotBlank()
        }
    }

    private fun gotoFragmentTwo() {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.mainFragment,
                FragmentTwo(
                    with(binding.formInput) {
                        InputNumber(
                            ed0.text.toString().toInt(),
                            ed1.text.toString().toInt(),
                            ed2.text.toString().toInt(),
                            ed3.text.toString().toInt(),
                            ed4.text.toString().toInt(),
                        )
                    }

                )
            )
            .commit()
    }
}