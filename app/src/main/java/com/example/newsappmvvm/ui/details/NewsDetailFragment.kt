package com.example.newsappmvvm.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsappmvvm.R
import com.example.newsappmvvm.databinding.FragmentNewsDetailBinding
import com.example.newsappmvvm.presentation.NewsViewModel

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {
    private lateinit var binding: FragmentNewsDetailBinding

    private val viewModel: NewsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsDetailBinding.bind(view)
        showData()
    }

    private fun showData(){

        viewModel.getArticle().observe(viewLifecycleOwner){

            binding.tvDate.text = it.publishedAt.take(10)
            binding.tvAuthor.text = it.author.toString()
            binding.tvTitleText.text = it.title
            binding.tvDescriptionText.text = it.description.toString()
            binding.tvContentText.text = it.content.toString()
            binding.tvUrlText.text = it.url

            Glide.with(requireContext()).load(it.urlToImage)
                    .centerCrop().into(binding.imgNews)
            Glide.with(requireContext()).load(it.urlToImage)
                    .centerCrop().into(binding.imgBackground)
        }
    }
}