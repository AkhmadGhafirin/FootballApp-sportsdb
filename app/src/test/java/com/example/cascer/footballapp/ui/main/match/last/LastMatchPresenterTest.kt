package com.example.cascer.footballapp.ui.main.match.last

import com.example.cascer.footballapp.RxSchedulerRule
import com.example.cascer.footballapp.data.model.event.EventList
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.data.network.Api
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 *  Created by akhmad ghafirin on Dec 5, 2018.
 **/
class LastMatchPresenterTest {
    companion object {
        @ClassRule
        @JvmField
        val rule = RxSchedulerRule()
    }

    lateinit var mPresenter: LastMatchPresenter
    @Mock
    lateinit var mView: LastMatchView
    @Mock
    lateinit var api: Api
    @Mock
    lateinit var compositeDisposable: CompositeDisposable

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = Mockito.spy(LastMatchPresenter(compositeDisposable, api))
        mPresenter.attachView(mView)
    }

    @Test
    fun getData() {
        val eventList: MutableList<EventsItem> = mutableListOf()
        val data = EventList(eventList)

        `when`(api.getLastEvent()).thenReturn(Single.just(data))
        mPresenter.getData()

        verify(mView).showData(eventList)
    }

    @After
    fun tearDown() {
        mPresenter.detachView()
    }
}