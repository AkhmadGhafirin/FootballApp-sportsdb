package com.example.cascer.footballapp.ui.main.match.next

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

class NextMatchPresenterTest {
    companion object {
        @ClassRule
        @JvmField
        val rule = RxSchedulerRule()
    }
    lateinit var mPresenter: NextMatchPresenter
    @Mock
    lateinit var mView: NextMatchView
    @Mock
    lateinit var api: Api
    @Mock
    lateinit var compositeDisposable: CompositeDisposable

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = Mockito.spy(NextMatchPresenter(compositeDisposable, api))
        mPresenter.attachView(mView)
    }

    @After
    fun tearDown() {
        mPresenter.detachView()
    }

    @Test
    fun getData() {
        val eventList: MutableList<EventsItem> = mutableListOf()
        val data = EventList(eventList)

        `when`(api.getNextEvent()).thenReturn(Single.just(data))
        mPresenter.getData()

        verify(mView).showData(eventList)
    }
}