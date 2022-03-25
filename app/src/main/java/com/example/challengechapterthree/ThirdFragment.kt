package com.example.challengechapterthree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //bundle
        val dataNamaIn = arguments?.getString("DATANAMA")
//        val dataAgeIn = arguments?.getString("DATAAGE")
//        val dataAddressIn = arguments?.getString("DATAADDRESS")
//        val dataJobIn = arguments?.getString("DATAJOB")
//        val hasilCekIn = arguments?.getString("HASILCEK")

        //data class serializable
        val dataPerson = arguments?.getSerializable("DATAPERSON") as Person?

        fun cekUsia (umur : Int) : String{
            if (umur %2 == 0){
                return "Genap"
            }else{
                return "Ganjil"
            }
        }

        if(dataPerson?.age != null && dataPerson?.address != null && dataPerson?.job != null){
            tv_age.isVisible = true
            tv_address.isVisible = true
            tv_job.isVisible = true

//            logic di 4th Fragment
//            tv_age.setText ("Usia: ${dataPerson?.age} , bernilai $hasilCekIn")

//            logic di 3rd fragment
            tv_age.setText ("Usia: ${dataPerson?.age} , bernilai ${cekUsia(dataPerson.age)}")


            tv_address.setText("Alamat: ${dataPerson?.address}")
            tv_job.setText("Pekerjaan: ${dataPerson?.job}")
        }

        tv_name.text  = "Nama: ${dataNamaIn?.capitalize()}"


        btn_to_screen_empat.setOnClickListener {
            super.onViewCreated(view, savedInstanceState)

            val dataNama = bundleOf("DATANAMA" to dataNamaIn)
            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_fourthFragment, dataNama)
        }

    }

}