package ru.netology.recyclerviewsample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.recyclerviewsample.databinding.ActivityMainBinding
import ru.netology.recyclerviewsample.presentation.recycler.TrackAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MediaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TrackAdapter()
        binding.list.adapter = adapter

        viewModel.state.observe(this) {
            adapter.submitList(it.items)
            binding.progress.isVisible = it.progress
        }

    }
}