package com.example.testgudang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testgudang.databinding.ActivityMainBinding
import com.example.testgudang.ui.MasterMaterialFragment
import com.example.testgudang.ui.MasterStockFragment
import com.example.testgudang.ui.PermintaanMaterialFragment
import com.example.testgudang.ui.PermintaanMaterialListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment = MasterMaterialFragment()
            when (item.itemId) {
                R.id.navigation_master_material -> {
                    selectedFragment = MasterMaterialFragment()
                }
                R.id.navigation_master_stock -> {
                    selectedFragment = MasterStockFragment()
                }
                R.id.navigation_permintaan_material -> {
                    selectedFragment = PermintaanMaterialFragment()
                }
                R.id.navigation_permintaan_material_list -> {
                    selectedFragment = PermintaanMaterialListFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit()
            true
        }

        // Set default selection
        binding.navView.selectedItemId = R.id.navigation_master_material
    }
}