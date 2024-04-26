package com.ambrella.kmm_trening.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ambrella.kmm_trening.ui.screen.MainScreen
import com.ambrella.kmm_trening.ui.screen.MainViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App() {
  val mainViewModel = getViewModel(Unit, viewModelFactory { MainViewModel() })
  MainScreen(mainViewModel)
}