package jorn.hiel.hourtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import jorn.hiel.hourtracker.databinding.FragmentFirstBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    //private lateinit var signingDateField: TextView

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)



        }

        val signingDateField : TextView = getView()!!.findViewById(R.id.signinDateField)
        val loginButton : Button = getView()!!.findViewById(R.id.button_first)

        val current = LocalDateTime.now()
        val dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        signingDateField.text = current.format(dayFormatter)
        loginButton.text="Login"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}