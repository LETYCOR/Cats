package com.example.catsFlow.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catsFlow.domain.models.CatFactStates
import com.example.catsFlow.presentation.ui.composables.CatFactCard
import com.example.catsFlow.presentation.ui.composables.CatFactText
import kotlinx.coroutines.flow.Flow

@Composable
fun CatFactScreen(
    catFact: Flow<CatFactStates>,
    onClick: () -> Unit
) {
    /*val catFact: CatFactStates
            by catFact.observeAsState(initial = CatFactStates.Loading)*/
    val catFact: CatFactStates
        by catFact.collectAsStateWithLifecycle(initialValue = CatFactStates.Loading)

    when (catFact) {
        is CatFactStates.Loading -> CatFactCard(
            text = "Click to Get a Cat Fact!",
            onClick = onClick)
        is CatFactStates.CatFactData -> CatFactCard(
            text = (catFact as CatFactStates.CatFactData).fact.text,
            onClick = onClick)
        else -> CatFactText(text = "Nothing to show")
    }
}