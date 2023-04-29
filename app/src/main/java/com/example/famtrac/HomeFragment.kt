package com.example.famtrac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMembers = listOf(
            MemberModel("Tarun", "C-211 Noida", "79", "223M"),
            MemberModel("kaushik", "Sector 3, Rohini, Delhi", "82", "42KM"),
            MemberModel("NFSU","NFSU, DC,New Delhi","88","21.81KM"),
            MemberModel("Papa", "1247, Bhagirathi, Ghaziabad","93","2.67KM"),
            MemberModel("Mummy","DAE Township, Kalpakkam, Chennai", "99","1098KM")
        )

        val adapter = MemberAdapter(listMembers)
        val recycler = requireView().findViewById<RecyclerView>(R.id.recycler_member)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()


    }
}