package com.demo.marksupp.view

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.demo.marksupp.R
import com.demo.marksupp.database.QuestionRelation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainListAdapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false

        rvPost.apply {
            mainListAdapter = MainListAdapter()
            adapter = mainListAdapter
        }

        mainViewModel.getAllQuestions().observe(this, {
            submitListToAdapter(it)
        })

        CoroutineScope(Dispatchers.IO).launch {
            mainViewModel.getQuestions()
        }

        refreshLayout.setOnRefreshListener {
            CoroutineScope(Dispatchers.IO).launch {
                setSwipeRefreshStatus(false)
                mainViewModel.getQuestions()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun submitListToAdapter(list: List<QuestionRelation>) {
        mainListAdapter.submitList(list.distinct())
        val viewCount = list.distinct().map { it.question.view_count!! }.average().toInt()
        tvMembers.text = String.format("%sM members", viewCount.toString())
    }

    private fun setSwipeRefreshStatus(status: Boolean) {
        try {
            refreshLayout.isRefreshing = status
        } catch (exception: Exception) {

        }
    }

}