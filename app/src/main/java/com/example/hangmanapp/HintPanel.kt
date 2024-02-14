package com.example.hangmanapp



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.hangmanapp.databinding.HintPanelBinding

class HintPanel: Fragment() {
    private lateinit var binding: HintPanelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HintPanelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener("MGF-HF-1") { key, bundle ->
            val hint = bundle.getString("hint").toString()
            binding.apply {
                hintTextView?.text = hint
                hintButton?.setOnClickListener() {
                    setFragmentResult("HF-MGF-1", bundleOf("hintCount" to "incrementCount"))
                }
            }
        }

        setFragmentResultListener("MGF-HF-2") { key, bundle ->
            val hint = bundle.getString("hint").toString()
            binding.apply{
                hintTextView?.text = hint
            }
        }

    }
}