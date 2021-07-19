package com.dicoding.schoolapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.dicoding.schoolapp.R
import com.dicoding.schoolapp.core.domain.model.Schoolism
import com.dicoding.schoolapp.core.ui.ViewModelFactory
import com.dicoding.schoolapp.databinding.ActivityDetailTourismBinding

class DetailSchoolActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var detailSchoolViewModel: DetailSchoolViewModel
    private lateinit var binding: ActivityDetailTourismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        detailSchoolViewModel = ViewModelProvider(this, factory)[DetailSchoolViewModel::class.java]

        val detailTourism = intent.getParcelableExtra<Schoolism>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailSchool: Schoolism?) {
        detailSchool?.let {
            supportActionBar?.title = detailSchool.sekolah

            var statusFavorite = detailSchool.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailSchoolViewModel.setFavoriteSchool(detailSchool, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
