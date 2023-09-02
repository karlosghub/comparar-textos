package com.curso.android.app.practica.comparartexto

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.comparartexto.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get: Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    @Test
    fun mainViewModel_TestResult() = runTest {
        launch {
            viewModel.result("","")
        }
        advanceUntilIdle()
        viewModel.result("","").also {
            assertEquals("Ingrese texto en ambos campos", it)
        }
    }

    @Test
    fun mainViewModel_TestResult1() = runTest {
        launch {
            viewModel.result("Esta es una prueba", "Esta es una prueba")
        }
        advanceUntilIdle()
        viewModel.result("Esta es una prueba", "Esta es una prueba").also {
            assertEquals("Los textos son iguales", it)
        }
    }

    @Test
    fun mainViewModel_TestResult2() = runTest {
        launch {
            viewModel.result("Esta es una prueba", "Esta es la prueba")
        }
        advanceUntilIdle()
        viewModel.result("Esta es una prueba","Esta es la prueba").also {
            assertEquals("Los textos no son iguales", it)
        }
    }

    @Test
    fun mainViewModel_TestResult3() = runTest {
        launch {
            viewModel.result("Esta es una prueba", "")
        }
        advanceUntilIdle()
        viewModel.result("Esta es una prueba","").also {
            assertEquals("Ingrese texto en ambos campos", it)
        }
    }

    @Test
    fun mainViewModel_TestResult4() = runTest {
        launch {
            viewModel.result("", "Esta es una prueba")
        }
        advanceUntilIdle()
        viewModel.result("","Esta es una prueba").also {
            assertEquals("Ingrese texto en ambos campos", it)
        }
    }
}