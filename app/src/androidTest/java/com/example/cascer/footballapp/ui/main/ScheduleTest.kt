package com.example.cascer.footballapp.ui.main

import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.example.cascer.footballapp.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScheduleTest {
    @Rule
    @JvmField
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testBottomNav() {
        onView(withId(bottom_nav)).perform(click())
        onView(withId(pasts)).check(matches(isDisplayed()))
        onView(withId(nexts)).check(matches(isDisplayed()))
        onView(withId(teams)).check(matches(isDisplayed()))
        onView(withId(favorites)).check(matches(isDisplayed()))
    }
}