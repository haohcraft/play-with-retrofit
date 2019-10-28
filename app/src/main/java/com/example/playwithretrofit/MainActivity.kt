package com.example.playwithretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.playwithretrofit.ui.StartedReposViewModel
import com.example.playwithretrofit.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val factory = InjectorUtils.provideStartedReposViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(StartedReposViewModel::class.java)
        viewModel.getStartedRepoById(2)
        viewModel.startedRepo.observe(this, Observer { repo ->
            Log.i("MainActivity", "repo name is ${repo}")
            textView_repo.text = repo.repo
        })
    }


}
