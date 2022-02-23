package com.example.anindaemlak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anindaemlak.adapter.EmlakRecyclerAdapter
import com.example.anindaemlak.databinding.FragmentEmlakBinding
import com.example.anindaemlak.viewModel.EmlakViewModel
import kotlinx.android.synthetic.main.fragment_emlak.*

class EmlakFragment : Fragment() {
    private lateinit var emlakViewModel: EmlakViewModel
    private lateinit var binding: FragmentEmlakBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmlakBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emlakViewModel = ViewModelProvider(this).get(EmlakViewModel::class.java)
        emlakViewModel.refreshDataEmlak()

        advert.layoutManager = LinearLayoutManager(context)

        observeEmlakListLiveData()
    }

    private fun observeEmlakListLiveData() {
        binding.apply {
            emlakViewModel.getEmlakListLiveData.observe(
                viewLifecycleOwner, androidx.lifecycle.Observer {
                    it?.let {
                        advert.adapter = EmlakRecyclerAdapter(it)
                    }
                })
        }
    }
}