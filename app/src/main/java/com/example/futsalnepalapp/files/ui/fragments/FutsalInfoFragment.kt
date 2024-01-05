package com.example.futsalnepalapp.files.ui.fragments

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.futsalnepalapp.R
import kotlinx.android.synthetic.main.fragment_futsal_info.*

class FutsalInfoFragment : Fragment(R.layout.fragment_futsal_info) {

    private val NAME = "name"  //shorter way of doing this: passing intent and using putExtra, getExtra functions
    private val ADDRESS = "address"
    private val TOLE = "tole"
    private val CITY = "city"
    private val PHONE_NUMBER = "phoneNumber"
    private val MAPS_LINK_URL = "maps_link_url"
    private val GMAPS_SS_PATH = "gmaps_ss_path"

    private var m_name: String = ""
    private var m_address: String = ""
    private var m_tole: String = ""
    private var m_city: String = ""
    private var m_phoneNumber:String = ""
    private var m_full_address : String = ""
    private var m_maps_link_url : String = ""
    private var m_gmaps_ss_path : Int = 0

    companion object {
        fun newInstance(
            name: String,
            address: String,
            tole: String,
            city: String,
            phoneNumber: String,
            mapsLinkUrl: String,
            gmapsSSpath: Int
        ) = FutsalInfoFragment().apply {
            arguments = bundleOf(
                NAME to name,
                ADDRESS to address,
                TOLE to tole,
                CITY to city,
                PHONE_NUMBER to phoneNumber,
                MAPS_LINK_URL to mapsLinkUrl,
                GMAPS_SS_PATH to gmapsSSpath
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            m_name = arguments?.getString(NAME).toString()
            m_address = arguments?.getString(ADDRESS).toString()
            m_tole = arguments?.getString(TOLE).toString()
            m_city = arguments?.getString(CITY).toString()
            m_phoneNumber = arguments?.getString(PHONE_NUMBER).toString()
            m_full_address = constructAddress(m_address, m_tole, m_city)
            m_maps_link_url = arguments?.getString(MAPS_LINK_URL).toString()
            m_gmaps_ss_path = arguments?.getInt(GMAPS_SS_PATH)!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvFragFutsalName.text = m_name
        tvFragAddress.text = m_full_address
        tvFragPhoneNumber.text = m_phoneNumber
        ivMapScreenshot.setImageResource(m_gmaps_ss_path)

        btnCall.setOnClickListener {
            val callIntent = Intent(ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:" + Uri.encode(m_phoneNumber)))
            startActivity(callIntent)
        }

        //Direction button goes here
        //Google Url is wrong, need to replace

        btnBackToHome.setOnClickListener {
            fragmentManager?.popBackStackImmediate()
        }
    }

    private fun constructAddress(address : String, tole: String, city: String) : String {
        var fullAddress = ""
        if (address == " ") {
            fullAddress = "$tole, $city"
        }
        else {
            fullAddress = "$address, $tole, $city"
        }
        return fullAddress
    }

}