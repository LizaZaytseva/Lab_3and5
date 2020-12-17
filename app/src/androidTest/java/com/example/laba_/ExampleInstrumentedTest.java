package com.example.laba_;

import android.content.Context;
import android.content.pm.ActivityInfo;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.NoActivityResumedException;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<> (MainActivity.class);

    @Test
    public void mainTest() {
        test1();
        onView(withId(R.id.bToSecFromF)).perform(ViewActions.click());
        test2();
        onView(withId(R.id.bToThFromSec)).perform(ViewActions.click());
        test3();
        onView(withId(R.id.text)).check(matches(withText("Activity 1")));
    }
    private void test1(){
        onView(withId(R.id.bToSecFromF)).perform(ViewActions.click());
        onView(withId(R.id.text)).check(matches(withText("Activity 2")));
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
        openActionBarOverflowOrOptionsMenu(activityTestRule.getActivity());
        onView(withText(R.string.about)).perform(click());
        onView(withId(R.id.text)).check(matches(withText("About")));
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
    }
    private void test2() {
        onView(withId(R.id.bToThFromSec)).perform(ViewActions.click());
        onView(withId(R.id.text)).check(matches(withText("Activity 3")));
        onView(withId(R.id.bToSecFromTh)).perform(ViewActions.click());
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        onView(withId(R.id.text)).check(matches(withText("Activity 2")));
        onView(withId(R.id.bToFirFromSec)).perform(ViewActions.click());
        onView(withId(R.id.text)).check(matches(withText("Activity 1")));
        onView(withId(R.id.bToSecFromF)).perform(ViewActions.click());
        onView(withId(R.id.text)).check(matches(withText("Activity 2")));
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        openActionBarOverflowOrOptionsMenu(activityTestRule.getActivity());
        onView(withText(R.string.about)).perform(click());
        onView(withId(R.id.text)).check(matches(withText("About")));
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.text)).check(matches(withText("Activity 2")));
    }
    private void test3() {
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        openActionBarOverflowOrOptionsMenu(activityTestRule.getActivity());
        onView(withText(R.string.about)).perform(click());
        onView(withId(R.id.text)).check(matches(withText("About")));
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onView(withId(R.id.text)).check(matches(withText("Activity 3")));
        onView(withId(R.id.bToSecFromTh)).perform(ViewActions.click());
        onView(withId(R.id.text)).check(matches(withText("Activity 2")));
        onView(withId(R.id.bToThFromSec)).perform(ViewActions.click());
        onView(withId(R.id.text)).check(matches(withText("Activity 3")));
        onView(withId(R.id.bToFirFromTh)).perform(ViewActions.click());
        onView(withId(R.id.text)).check(matches(withText("Activity 1")));
    }

    @Test (expected = NoActivityResumedException.class)
    public void backStack() {
        onView(withId(R.id.bToSecFromF)).perform(ViewActions.click());
        onView(withId(R.id.bToThFromSec)).perform(ViewActions.click());
        onView(withId(R.id.bToSecFromTh)).perform(ViewActions.click());
        onView(withId(R.id.bToFirFromSec)).perform(ViewActions.click());
        onView(withId(R.id.bToSecFromF)).perform(ViewActions.click());
        onView(withId(R.id.bToThFromSec)).perform(ViewActions.click());
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.text)).check(matches(withText("Activity 1")));
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
    }

}