package com.example.amphibians.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.amphibians.databinding.FragmentAmphibianDetailBinding

/**
 * This Fragment shows the detailed information on a particular Amphibian
 */
//Fragmen ini menunjukkan informasi rinci tentang Amfibi tertentu
class AmphibianDetailFragment : Fragment() {

    private val viewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAmphibianDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // menginflate layout
        return binding.root
    }
}
