package com.example.newsappmvvm.presentation

import androidx.lifecycle.*
import com.example.newsappmvvm.core.Resource
import com.example.newsappmvvm.data.model.Article
import com.example.newsappmvvm.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class NewsViewModel(private val repo: NewsRepository): ViewModel(){

    private val newsArticle = MutableLiveData<Article>()

    fun fetchNews() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repo.getNews()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun setArticle(article: Article){
        newsArticle.value = article
    }

    fun getArticle(): LiveData<Article>{
        return newsArticle
    }

}
