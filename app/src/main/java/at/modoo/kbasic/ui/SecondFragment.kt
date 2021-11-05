package at.modoo.kbasic.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import at.modoo.kbasic.R
import at.modoo.kbasic.adapter.BlogAdapter
import at.modoo.kbasic.databinding.FragmentSecondBinding
import at.modoo.kbasic.utility.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class SecondFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding:FragmentSecondBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBlog()
        lifecycleScope.launchWhenCreated {
            val result = viewModel.dataState.collect { dataState ->
                when(dataState){
                    is DataState.Empty -> {
                        Log.i("SS", "onViewCreated: " + "Empty")
                    }
                    is DataState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            binding.recyclerView.also {
                                it.layoutManager = LinearLayoutManager(requireContext())
                                it.setHasFixedSize(true)
                                it.adapter = BlogAdapter(dataState.data)
                                it.addItemDecoration(DividerItemDecoration(it.context,DividerItemDecoration.VERTICAL))
                            }
                    }
                    is DataState.Loading -> {
                        binding.progressBar.
                            visibility = View.VISIBLE
                    }
                    is DataState.ErrorUnknown -> {
                       binding.progressBar.visibility = View.GONE
                        Toast.makeText(context,dataState.exception,Toast.LENGTH_LONG).show()
                    }
                    is DataState.Error -> {
                        Toast.makeText(context,dataState.exception.message,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}