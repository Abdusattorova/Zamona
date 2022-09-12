package com.example.zamona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zamona.databinding.FragmentHomeBinding
import com.example.zamona.myAdapter.MyAdapter

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var list: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        setDat()
        binding.rv.adapter=MyAdapter(list)
        return binding.root

    }

    private fun setDat() {
        list= arrayListOf()
        list.add(Data(R.drawable.humo6,"Hamkor bankning humo kartasi bu karta halqaro mudati 5 yilgacha"))
        list.add(Data(R.drawable.humo2,"Hamkor bankning humo kartasi bu karta halqaro mudati 5 yilgacha"))
        list.add(Data(R.drawable.humo3,"Hamkor bankning humo kartasi bu karta halqaro mudati 5 yilgacha"))
        list.add(Data(R.drawable.humo4,"Hamkor bankning humo kartasi bu karta halqaro mudati 5 yilgacha"))
        list.add(Data(R.drawable.humo5,"Hamkor bankning humo kartasi bu karta halqaro mudati 5 yilgacha"))
        list.add(Data(R.drawable.humo6,"Hamkor bankning humo kartasi bu karta halqaro mudati 5 yilgacha"))
    }

}