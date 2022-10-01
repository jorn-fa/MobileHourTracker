package jorn.hiel.hourtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import jorn.hiel.hourtracker.databinding.FragmentSecondBinding
import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        setButtons()
        setMonth()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setButtons(){

        val buttons= mutableListOf<Button>()

        buttons.add(this.view!!.findViewById(R.id.button01))
        buttons.add(this.view!!.findViewById(R.id.button02))
        buttons.add(this.view!!.findViewById(R.id.button03))
        buttons.add(this.view!!.findViewById(R.id.button04))
        buttons.add(this.view!!.findViewById(R.id.button05))
        buttons.add(this.view!!.findViewById(R.id.button06))
        buttons.add(this.view!!.findViewById(R.id.button07))
        buttons.add(this.view!!.findViewById(R.id.button08))
        buttons.add(this.view!!.findViewById(R.id.button09))
        buttons.add(this.view!!.findViewById(R.id.button10))

        buttons.add(this.view!!.findViewById(R.id.button11))
        buttons.add(this.view!!.findViewById(R.id.button12))
        buttons.add(this.view!!.findViewById(R.id.button13))
        buttons.add(this.view!!.findViewById(R.id.button14))
        buttons.add(this.view!!.findViewById(R.id.button15))
        buttons.add(this.view!!.findViewById(R.id.button16))
        buttons.add(this.view!!.findViewById(R.id.button17))
        buttons.add(this.view!!.findViewById(R.id.button18))
        buttons.add(this.view!!.findViewById(R.id.button19))
        buttons.add(this.view!!.findViewById(R.id.button20))

        buttons.add(this.view!!.findViewById(R.id.button21))
        buttons.add(this.view!!.findViewById(R.id.button22))
        buttons.add(this.view!!.findViewById(R.id.button23))
        buttons.add(this.view!!.findViewById(R.id.button24))
        buttons.add(this.view!!.findViewById(R.id.button25))
        buttons.add(this.view!!.findViewById(R.id.button26))
        buttons.add(this.view!!.findViewById(R.id.button27))
        buttons.add(this.view!!.findViewById(R.id.button28))
        buttons.add(this.view!!.findViewById(R.id.button29))
        buttons.add(this.view!!.findViewById(R.id.button30))

        buttons.add(this.view!!.findViewById(R.id.button31))



        for (i in 0..30 step 1){
        try {
            buttons[i].isEnabled = isWeekDay(i)
        }
        catch(e: DateTimeException){
            buttons[i].visibility = View.GONE;
            }

        }
    }

    private fun isWeekDay(day:Int): Boolean {
        //counter 0 based collection
        val todaydate: LocalDate = LocalDate.now()
        if(todaydate.withDayOfMonth(day+1).dayOfWeek>DayOfWeek.FRIDAY){return false}
        return true
    }

    private fun setMonth(){
        val monthLabel : TextView = this.view!!.findViewById(R.id.monthLabel)
        //test = this.view!!.findViewById(R.id.button31)
        val month : String = LocalDate.now().month.toString().lowercase()
        monthLabel.text= month.replaceFirstChar { it.uppercase() }
        monthLabel.textAlignment = View.TEXT_ALIGNMENT_CENTER

    }

}