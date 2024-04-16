package com.example.catsMVIFlow.presentation.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsMVIFlow.domain.models.CatFactStates
import com.example.catsMVIFlow.domain.models.Fact
import com.example.catsMVIFlow.domain.usecases.GetCatRandomFactUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCatRandomFactUseCase: GetCatRandomFactUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<CatFactStates>(CatFactStates.Init)
    val uiState: StateFlow<CatFactStates> = _uiState

    init {
        getCatFact()
    }

    fun getCatFact() {
        viewModelScope.launch {
            try {
                val catFactState = getCatRandomFactUseCase().first()
                handleCatFactState(catFactState)
            } catch (e: Exception) {
                handleCatFactError(e)
            }
        }
    }

    private fun handleCatFactState(catFactState: CatFactStates) {
        when (catFactState) {
            is CatFactStates.Init -> notifyInitState()
            is CatFactStates.Loading -> notifyLoadingState()
            is CatFactStates.CatFactData -> notifyCatFactState(catFactState.fact)
            is CatFactStates.Error -> notifyErrorState(catFactState.error)
        }
    }

    private fun handleCatFactError(error: Throwable) {
        notifyErrorState(error)
    }

    private fun notifyInitState() {
        _uiState.value = CatFactStates.Init
    }

    private fun notifyLoadingState() {
        _uiState.value = CatFactStates.Loading
    }

    private fun notifyCatFactState(fact: Fact) {
        _uiState.value = CatFactStates.CatFactData(fact)
    }

    private fun notifyErrorState(error: Throwable) {
        _uiState.value = CatFactStates.Error(error)
    }
}
