package com.comunidadedevspace.taskbeats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.Task
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {
            openTaskListDetail()
        }

        val taskListFragment = TaskListFragment.newInstance()
        val newsListFragment = NewsListFragment.newInstance()

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, taskListFragment)
            setReorderingAllowed(true)
        }

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            val fragment = when(menuItem.itemId) {
                R.id.task_list_item -> taskListFragment
                R.id.news_list_item -> newsListFragment
                else -> taskListFragment
            }

            supportFragmentManager.commit {
                replace(R.id.fragment_container_view, fragment)
                setReorderingAllowed(true)
            }

            true
        }
    }

    private fun openTaskListDetail() {
        val intent = TaskDetailActivity.start(this, null)
        startActivity(intent)
    }
}