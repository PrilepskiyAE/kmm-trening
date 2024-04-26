package com.ambrella.kmm_trening.ui.screen

import com.ambrella.kmm_trening.common.AbstractViewModel
import com.ambrella.kmm_trening.common.Action
import com.ambrella.kmm_trening.model.ImageModel
import com.ambrella.kmm_trening.ui.state.MainAction
import com.ambrella.kmm_trening.ui.state.MainState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : AbstractViewModel() {
    private val _state: MutableStateFlow<MainState.Data> = MutableStateFlow(MainState.Data())

    override val state: StateFlow<MainState.Data> = _state.asStateFlow()
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    init {
        updateImages()
    }

    override fun onCleared() {
        httpClient.close()
    }

    override fun doAction(action: Action) {
        when (action) {
            is MainAction.SelectCategory ->{
                _state.update {
                    it.copy(selectedCategory = action.category)
                }
            }
        }
    }

    private suspend fun getImages(): List<ImageModel> {
        val images = httpClient
            .get("https://sebastianaigner.github.io/demo-image-api/pictures.json")
            .body<List<ImageModel>>()
        return images
    }

    private fun updateImages() {
        viewModelScope.launch {
            val images = getImages()
            _state.update {
                it.copy(images = images)
            }
        }
    }
}