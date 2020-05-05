package com.example.meditations.add_meditation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.meditations.R
import com.example.meditations.ViewModelFactory
import com.example.meditations.add_meditation.vm.VM
import io.reactivex.Observable

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddMeditationFragment : UI, Fragment() {

    private val viewModel: VM by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this, ViewModelFactory.instance(requireContext()))
            .get(VM::class.java)
    }

    override fun events(): Observable<UI.Event> {
        TODO("Not yet implemented")
    }

    override fun render(states: Observable<UI.State>) {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_meditation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

}
