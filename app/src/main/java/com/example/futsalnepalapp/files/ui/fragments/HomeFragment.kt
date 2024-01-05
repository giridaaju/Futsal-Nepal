package com.example.futsalnepalapp.files.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.adapters.FutsalAdapter
import com.example.futsalnepalapp.files.adapters.FutsalInfoItemClickListener
import com.example.futsalnepalapp.files.ui.FutsalActivity
import com.example.futsalnepalapp.files.ui.FutsalViewModel
import com.example.futsalnepalapp.files.util.Futsal
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) , FutsalInfoItemClickListener{

    var auth = FirebaseAuth.getInstance()
    lateinit var viewModel: FutsalViewModel
    lateinit var futsalAdapter: FutsalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as FutsalActivity).futsalViewModel
        futsalAdapter = FutsalAdapter(listOf(), this)

        svFutsal?.isSubmitButtonEnabled = true
        svFutsal.clearFocus()
        svFutsal?.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(search: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(search: String?): Boolean {
                if (search != null) {
                    filterList(search)
                }
                return true
            }
        })

        rvFutsalInfos.adapter = futsalAdapter
        rvFutsalInfos.layoutManager = LinearLayoutManager(activity)


        viewModel.initialUpsert()
        viewModel.getAllFutsals().observe(viewLifecycleOwner, Observer {
            futsalAdapter.futsals = it
            futsalAdapter.notifyDataSetChanged()
        })
    }

    override fun onItemClick(futsal: Futsal) {
        val futsalInfoFragment = FutsalInfoFragment.newInstance(
            futsal.name,
            futsal.address,
            futsal.tole,
            futsal.city,
            futsal.phoneNumber,
            futsal.mapsLinkUrl,
            futsal.gmapsSSpath)
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.flFragment, futsalInfoFragment, "futsal_info_fragment")
        transaction?.addToBackStack(null)
        transaction?.commit()
    }


    private fun filterList(query: String) {
        val searchQuery = "%$query%"
        viewModel.searchFutsals(searchQuery).observe(viewLifecycleOwner) { list ->
            list.let {
                futsalAdapter.futsals = it
                rvFutsalInfos.getRecycledViewPool().clear()
                futsalAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun checkLoggedInState(): Boolean {
        return auth.currentUser != null
    }

}