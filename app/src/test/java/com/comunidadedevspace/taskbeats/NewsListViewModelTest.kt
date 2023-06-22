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

            val expectedTop = listOf(
                NewsDto(
                    id = "id1",
                    title = "title1",
                    imageUrl = "image1",
                    content = "summary1"
                )
            )

            val expectedAll = listOf(
                NewsDto(
                    id = "id2",
                    title = "title2",
                    imageUrl = "image2",
                    content = "summary2"
                )
            )

            val topResponse = NewsResponse(data = expectedTop)
            val allResponse = NewsResponse(data = expectedAll)

            whenever(service.fetchTopNews()).thenReturn(topResponse)
            whenever(service.fetchAllNews()).thenReturn(allResponse)

            underTest = NewsListViewModel(service)

            val result = underTest.newsListLiveData.getOrAwaitValue()

            assert(result == expectedTop + expectedAll)

        }
    }
}