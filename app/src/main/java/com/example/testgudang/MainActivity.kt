package com.example.testgudang

import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testgudang.databinding.ActivityMainBinding
import com.example.testgudang.ui.MasterMaterialFragment
import com.example.testgudang.ui.MasterStockFragment
import com.example.testgudang.ui.PermintaanMaterialFragment
import com.example.testgudang.ui.PermintaanMaterialListFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize FloatingActionButton
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    private fun showPopupMenu(view: android.view.View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.bottom_nav_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
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
        popupMenu.show()
    }
}
