package com.example.hangmanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.hangmanapp.databinding.ChooseLetterPanelBinding

class ChooseLetterPanel : Fragment() {

    private lateinit var binding: ChooseLetterPanelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ChooseLetterPanelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("MGF-CLF") { key, bundle ->
            val result = bundle.getString("data").toString()
            if (result == "EnableAll") {
                updateAllButtonsState(true)
            } else if (result == "DisableAll") {
                updateAllButtonsState(false)
            } else {
                for (guess in result) {
                    binding.apply {
                        when (guess) {
                            'A' -> aButton.isEnabled = false
                            'B' -> bButton.isEnabled = false
                            'C' -> cButton.isEnabled = false
                            'D' -> dButton.isEnabled = false
                            'E' -> eButton.isEnabled = false
                            'F' -> fButton.isEnabled = false
                            'G' -> gButton.isEnabled = false
                            'H' -> hButton.isEnabled = false
                            'I' -> iButton.isEnabled = false
                            'J' -> jButton.isEnabled = false
                            'K' -> kButton.isEnabled = false
                            'L' -> lButton.isEnabled = false
                            'M' -> mButton.isEnabled = false
                            'N' -> nButton.isEnabled = false
                            'O' -> oButton.isEnabled = false
                            'P' -> pButton.isEnabled = false
                            'Q' -> qButton.isEnabled = false
                            'R' -> rButton.isEnabled = false
                            'S' -> sButton.isEnabled = false
                            'T' -> tButton.isEnabled = false
                            'U' -> uButton.isEnabled = false
                            'V' -> vButton.isEnabled = false
                            'W' -> wButton.isEnabled = false
                            'X' -> xButton.isEnabled = false
                            'Y' -> yButton.isEnabled = false
                            'Z' -> zButton.isEnabled = false
                        }
                    }

                }

            }
        }

        binding.apply {
            aButton.setOnClickListener {
                aButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "A"))
            }
            bButton.setOnClickListener {
                bButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "B"))
            }
            cButton.setOnClickListener {
                cButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "C"))
            }
            dButton.setOnClickListener {
                dButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "D"))
            }
            eButton.setOnClickListener {
                eButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "E"))
            }
            fButton.setOnClickListener {
                fButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "F"))
            }
            gButton.setOnClickListener {
                gButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "G"))
            }
            hButton.setOnClickListener {
                hButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "H"))
            }
            iButton.setOnClickListener {
                iButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "I"))
            }
            jButton.setOnClickListener {
                jButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "J"))
            }
            kButton.setOnClickListener {
                kButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "K"))

            }
            lButton.setOnClickListener {
                lButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "L"))
            }
            mButton.setOnClickListener {
                mButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "M"))
            }
            nButton.setOnClickListener {
                nButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "N"))
            }
            oButton.setOnClickListener {
                oButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "O"))
            }
            pButton.setOnClickListener {
                pButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "P"))
            }
            qButton.setOnClickListener {
                qButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "Q"))
            }
            rButton.setOnClickListener {
                rButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "R"))
            }
            sButton.setOnClickListener {
                sButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "S"))
            }
            tButton.setOnClickListener {
                tButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "T"))
            }
            uButton.setOnClickListener {
                uButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "U"))
            }
            vButton.setOnClickListener {
                vButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "V"))
            }
            wButton.setOnClickListener {
                wButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "W"))
            }
            xButton.setOnClickListener {
                xButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "X"))
            }
            yButton.setOnClickListener {
                yButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "Y"))
            }
            zButton.setOnClickListener {
                zButton.isEnabled = false
                setFragmentResult("CLF-MGF", bundleOf("data" to "Z"))
            }

        }
    }

    private fun updateAllButtonsState(value: Boolean){
        binding.apply {
            aButton.isEnabled = value
            bButton.isEnabled = value
            cButton.isEnabled = value
            dButton.isEnabled = value
            eButton.isEnabled = value
            fButton.isEnabled = value
            gButton.isEnabled = value
            hButton.isEnabled = value
            iButton.isEnabled = value
            jButton.isEnabled = value
            kButton.isEnabled = value
            lButton.isEnabled = value
            mButton.isEnabled = value
            nButton.isEnabled = value
            oButton.isEnabled = value
            pButton.isEnabled = value
            qButton.isEnabled = value
            rButton.isEnabled = value
            sButton.isEnabled = value
            tButton.isEnabled = value
            uButton.isEnabled = value
            vButton.isEnabled = value
            wButton.isEnabled = value
            xButton.isEnabled = value
            yButton.isEnabled = value
            zButton.isEnabled = value
        }
    }

}