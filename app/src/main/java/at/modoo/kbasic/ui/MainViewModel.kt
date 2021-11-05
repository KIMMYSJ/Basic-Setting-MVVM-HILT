package at.modoo.kbasic.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.modoo.kbasic.model.Blog
import at.modoo.kbasic.repository.RedditRepository
import at.modoo.kbasic.utility.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repo:RedditRepository):
ViewModel() {
    private val _dataState:MutableStateFlow<DataState<List<Blog>>>
    = MutableStateFlow(DataState.Empty)
    val dataState:MutableStateFlow<DataState<List<Blog>>> = _dataState

//    fun getBlog() = viewModelScope.launch {
//        repo.getBlog().onEach {
//            Log.i("SS", "getBlog: ")
//            dataState.value = it
//        }.launchIn(viewModelScope)
//    }

    fun getBlog() = viewModelScope.launch {
        repo.getBlog().collect {
            dataState.value = it
        }
    }
}