package com.comunidadedevspace.taskbeats

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.comunidadedevspace.taskbeats.data.remote.NewsDto
import com.comunidadedevspace.taskbeats.data.remote.NewsResponse
import com.comunidadedevspace.taskbeats.data.remote.NewsService
import com.comunidadedevspace.taskbeats.presentation.NewsListViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class NewsListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val service: NewsService = mock()

    private lateinit var underTest: NewsListViewModel

    @Test
    fun `GIVEN request succeed WHEN fetch THEN return list`() {
        runBlocking {

            val expected = listOf(
                NewsDto(
                    id = 123456,
                    title = "title1",
                    imageUrl = "image1",
                    summary = "summary1"
                )
            )

            val response =
                NewsResponse(results = expected, count = 654321, next = "next1", previous = false)

            whenever(service.fetchNews()).thenReturn(response)

            underTest = NewsListViewModel(service)

            val result = underTest.newsListLiveData.getOrAwaitValue()

            assert(result == expected)

        }
    }
}