package com.synthesizer.source.empty.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.synthesizer.source.empty.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

//    val binding : FragmentMainBinding by lazy { FragmentMainBinding.inflate(LayoutInflater.from(context)) }

    private var users = mutableListOf<User>()
    private val customAdapter = CustomAdapter(users)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (i in 1..100) {
            users.add(User("$i. Hasan", "OZDEMIR"))
        }
        binding.rv.adapter = customAdapter

        binding.button.setOnClickListener {
            val anotherUsers = mutableListOf<User>()
            for (i in 101..120) {
                anotherUsers.add(User("$i. Hasan", "OZDEMIR"))
            }
            customAdapter.addData(anotherUsers)
        }
    }

}