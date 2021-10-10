package ru.geekbrains.nasapictureoftheday.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import ru.geekbrains.nasapictureoftheday.R
import ru.geekbrains.nasapictureoftheday.recycler.RecyclerActivity

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_one -> {
                    requireActivity().setTheme(R.style.Theme_NASAPictureOfTheDayCustom)
                    requireActivity().recreate()
                    Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
                }
                R.id.navigation_two -> {
                    requireActivity().setTheme(R.style.Theme_NASAPictureOfTheDay)
                    requireActivity().recreate()
                    Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
                }
                R.id.navigation_three -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            RecyclerActivity::class.java
                        )
                    )
                }
            }
            dismiss()
            true
        }
    }

}

