package com.dom.nbaplayers.screens.playerInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.dom.nbaplayers.R
import com.dom.nbaplayers.model.allPlayers.AllPlayers
import kotlinx.android.synthetic.main.fragment_player_info.view.*
import retrofit2.Response

class PlayerInfoFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: PlayerInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(this)[PlayerInfoViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_player_info, container, false)
        recyclerView = view.rv_player
        adapter = PlayerInfoAdapter()
        recyclerView.adapter = adapter

        viewModel.getPlayers()
        viewModel.myPlayerList.observe(viewLifecycleOwner,
            fun(list: Response<AllPlayers>) {
                list.body()?.let { adapter.setList(it.data) }
            })

        return view
    }
}