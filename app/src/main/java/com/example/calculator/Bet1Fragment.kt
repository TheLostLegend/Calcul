package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bet1.*
import kotlin.math.sqrt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Bet1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Bet1Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var num1: Float? = null
    var tum:Boolean = true
    lateinit var sttr:String

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
        return inflater.inflate(R.layout.fragment_bet1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resultText = activity?.findViewById(R.id.resultText)
        mathText = activity?.findViewById(R.id.math_operation)
        button_0.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("0")
        }
        button_1.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("1")
        }
        button_2.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("2")
        }
        button_3.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("3")
        }
        button_4.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("4")
        }
        button_5.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("5")
        }
        button_6.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("6")
        }
        button_7.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("7")
        }
        button_8.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("8")
        }
        button_9.setOnClickListener {
            val str = resultText?.text.toString()
            if (str == "0") resultText?.text =""
            SetTextFields("9")
        }
        button_Dot.setOnClickListener {
            SetTextFields(".")
        }
///////////////////////////////////////////////////////////////////////////
        button_plus.setOnClickListener {
            SetTextFields2("+")
        }
        button_min.setOnClickListener {
            SetTextFields2("-")
        }
        button_mul.setOnClickListener {
            SetTextFields2("*")
        }
        button_del.setOnClickListener {
            SetTextFields2("/")
        }
        button_mod.setOnClickListener {
            SetTextFields2("%")
        }
//////////////////////////////////////////////////////////////////////////////
        button_del2.setOnClickListener {
            SetTextFields3("1")
        }
        button_mul2.setOnClickListener {
            SetTextFields3("2")
        }
        button_sqrt.setOnClickListener {
            SetTextFields3("3")
        }
        button_change.setOnClickListener {
            SetTextFields3("4")
        }

        button_End.setOnClickListener{
            SetTextFields2(sttr)
        }


        button_C.setOnClickListener {
            mathText?.text = "0"
            resultText?.text = "0"
            num1 = null
            tum = true
        }
        button_CE.setOnClickListener {
            resultText?.text = "0"
            tum = true
        }
        button_back.setOnClickListener {
            if (tum){
                val str = resultText?.text.toString()
                if(str.isNotEmpty())
                    resultText?.text = str.substring(0, str.length - 1)
                if (str.substring(0, str.length - 1)== "")
                    resultText?.text = "0"
            }
        }
    }

    fun SetTextFields(str: String){
        if (!tum) resultText?.text = ""
        resultText?.append(str)
        tum = true
    }
    fun SetTextFields2(str1: String){
        val str = resultText?.text.toString()
        val str2 = mathText?.text.toString()
        if (tum){
            val num2:Float
            if (num1 == null) num1 = str.toFloat()
            else {
                num2 = str.toFloat()
                when (sttr){
                    "+" -> num1 = num1!! + num2
                    "-" -> num1 = num1!! - num2
                    "*" -> num1 = num1!! * num2
                    "/" -> num1 = num1!! / num2
                    "%" -> num1 = num1!! % num2
                    else -> resultText?.text = "ERROR"
                }
                resultText?.text = num1.toString()
            }
            mathText?.text = resultText?.text
            tum = false
        }
        else mathText?.text = str2.substring(0, str2.length - 1)
        mathText?.append(str1)
        sttr = str1
    }
    fun SetTextFields3(str1: String){
        val str = resultText?.text.toString()
        var num2:Float = str.toFloat()
        when (str1){
            "1" -> num2 = 1/num2
            "2" -> num2 *= num2
            "3" -> num2 = sqrt(num2)
            "4" -> num2 *= -1
            else -> resultText?.text = "ERROR"
        }
        resultText?.text = num2.toString()
        tum = true
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Bet1Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Bet1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}