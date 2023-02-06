package com.kemalakkus.bottomsheetdialog

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kemalakkus.bottomsheetdialog.databinding.FragmentBottomSheetBinding
import com.kemalakkus.bottomsheetdialog.databinding.FragmentHomeBinding


class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSave.setOnClickListener {
            Toast.makeText(activity,"File saved", Toast.LENGTH_LONG).show()
        }

        binding.tvLink.setOnClickListener {
            Toast.makeText(activity,"Link copied", Toast.LENGTH_LONG).show()

        }

        binding.tvShare.setOnClickListener {
            share()
        }

    }

    private fun share() {
        val type = "text/plain"
        val shareWith = "Share With"
        val subject = "This app is cool"
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)
        intent.type = type
        startActivity(Intent.createChooser(intent,shareWith))
    }

}