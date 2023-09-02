package com.curso.android.app.practica.comparartexto.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.comparartexto.R

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compararTexto() {
        Espresso.onView(
            ViewMatchers.withId(R.id.button_comparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Ingrese texto en ambos campos")
            )
        )
    }

    @Test
    fun mainActivity_compararTexto1() {
        Espresso.onView(
        ViewMatchers.withId(R.id.input1)
        ).perform(
            ViewActions.typeText("Esta es una prueba")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.input2)
        ).perform(
            ViewActions.typeText("Esta es la prueba")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.button_comparar)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
            ViewMatchers.withText("Los textos no son iguales")
            )
        )
    }

    @Test
    fun mainActivity_compararTexto2() {
        Espresso.onView(
            ViewMatchers.withId(R.id.input1)
        ).perform(
            ViewActions.typeText("Esta es una prueba")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.input2)
        ).perform(
            ViewActions.typeText("Esta es una prueba")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.button_comparar)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales")
            )
        )
    }
}