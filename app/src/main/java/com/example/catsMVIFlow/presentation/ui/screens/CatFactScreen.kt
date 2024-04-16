package com.example.catsMVIFlow.presentation.ui.screens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catsMVIFlow.domain.models.CatFactStates
import com.example.catsMVIFlow.presentation.ui.composables.CatFactCard
import com.example.catsMVIFlow.presentation.ui.composables.CatFactText
import kotlinx.coroutines.flow.Flow

sealed class CatFactIntent {
    object LoadCatFact : CatFactIntent()
}

@Composable
fun CatFactScreen(
    catFact: Flow<CatFactStates>,
    onClick: () -> Unit
) {
    val catFactState: CatFactStates by catFact.collectAsState(initial = CatFactStates.Loading)

    when (catFactState) {
        is CatFactStates.Loading -> CatFactCard(
            text = "Click to Get a Cat Fact!",
            onClick = onClick
        )
        is CatFactStates.CatFactData -> CatFactCard(
            text = (catFactState as CatFactStates.CatFactData).fact.text,
            onClick = onClick
        )
        else -> CatFactText(text = "Nothing to show")
    }
}




