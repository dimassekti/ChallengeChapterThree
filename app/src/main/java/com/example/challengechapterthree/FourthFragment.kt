package com.example.challengechapterthree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fourth.*
import kotlinx.android.synthetic.main.fragment_fourth.tv_error
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.btn_to_screen_empat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FourthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FourthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hasilCekIn = arguments?.getString("HASILCEK")
        val dataSerializable = arguments?.getSerializable("DATAPERSON") as Person?

        btn_back_to_screen_tiga.setOnClickListener {

            val dataNamaIn = arguments?.getString("DATANAMA")

            if (et_age.text.length > 0 && et_address.text.length > 0 && et_job.text.length > 0){
                var age = et_age.text.toString()
                var address = et_address.text.toString()
                var job = et_job.text.toString()

//                logic
//                fun cekUsia (umur : Int) : String{
//                    if (umur %2 == 0){
//                        return "Genap"
//                    }else{
//                        return "Ganjil"
//                    }
//                }
//                val hasilCek = cekUsia(age!!.toInt())

                val dataPerson = Person(age.toInt(), address, job)

                //cara bundle
//                val data = bundleOf("DATANAMA" to dataNamaIn
//                    , "DATAAGE" to age
//                    , "DATAADDRESS" to address
//                    , "DATAJOB" to job
//                    , "HASILCEK" to hasilCek)

//                val data = bundleOf("DATAPERSON" to dataPerson, "HASILCEK" to hasilCek, "DATANAMA" to dataNamaIn)

                val data = bundleOf("DATAPERSON" to dataPerson, "DATANAMA" to dataNamaIn)
                Navigation.findNavController(view).navigate(R.id.action_fourthFragment_to_thirdFragment, data )
            }else{
                tv_error.setText("Mohon input umur, slsmst, & pekerjaan dengan benar")
            }


        }
    }

}