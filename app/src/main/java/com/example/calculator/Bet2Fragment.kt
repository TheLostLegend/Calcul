package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bet2.*
import kotlin.math.sqrt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Bet2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Bet2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var resultText: TextView? = null
    var mathText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (resultText == null) {
            Log.d("TAG", "resultText is null")
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bet2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resultText = activity?.findViewById(R.id.resultText)
        mathText = activity?.findViewById(R.id.math_operation)
        button_del2.setOnClickListener {
            SetTextFields3("1")
        }
        button_mul2.setOnClickListener {
            SetTextFields3("2")
        }
        button_sqrt.setOnClickListener {
            SetTextFields3("3")
        }

    }
    fun SetTextFields3(str1: String){
        val str = resultText?.text.toString()
        var num2:Float = str.toFloat()
        when (str1){
            "1" -> num2 = 1/num2
            "2" -> num2 *= num2
            "3" -> num2 = sqrt(num2)
            else -> resultText?.text = "ERROR"
        }
        resultText?.text = num2.toString()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Bet2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Bet2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}