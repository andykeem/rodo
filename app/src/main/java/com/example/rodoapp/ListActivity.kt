package com.example.rodoapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rodoapp.adapter.GridViewAdapter
import com.example.rodoapp.databinding.ActivityListBinding
import com.example.rodoapp.model.VehicleType
import com.example.rodoapp.viewmodel.VehicleTypeViewModel
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.bottom_nav.*

private const val TAG = "ListActivity"
const val GRID_SPAN_COUNT = 2
class ListActivity : BaseActivity() {

    lateinit var binding: ActivityListBinding
    val typeViewModel: VehicleTypeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        updateActionBar()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.setVariable(BR.viewModel, typeViewModel)

        recyclerView.layoutManager = GridLayoutManager(this, GRID_SPAN_COUNT)

        typeViewModel.fetchVehicleTypeList()
        typeViewModel.vehicleTypeList.observe(this, object : Observer<List<VehicleType>> {
            override fun onChanged(list: List<VehicleType>?) {
                list?.let {
                    recyclerView.adapter = GridViewAdapter(it)
                }
            }
        })

        nav_view.setOnNavigationItemSelectedListener(this)
        nav_view.menu.children.forEach {
            it.setChecked(false)
        }
    }
}