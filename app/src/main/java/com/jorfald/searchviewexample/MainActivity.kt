package com.jorfald.searchviewexample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.jorfald.searchviewexample.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var headerBar: ConstraintLayout
    private lateinit var headerBarTextView: TextView
    private lateinit var headerBarButton: TextView
    private lateinit var filterContainer: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    MainFragment.newInstance()
                )
                .commitNow()
        }

        headerBar = findViewById(R.id.main_header_bar)
        headerBarTextView = findViewById(R.id.main_header_bar_text)
        headerBarButton = findViewById(R.id.main_header_bar_button)
        filterContainer = findViewById(R.id.main_filter_container)
//        filterContainer.isVisible = false

        setClickListeners()
    }

    fun changeHeaderText(newText: String) {
        headerBarTextView.text = newText
    }

    fun setClickListeners() {
        headerBarButton.setOnClickListener {
            filterContainer.isVisible = !filterContainer.isVisible
        }
    }
}