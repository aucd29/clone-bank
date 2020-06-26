package brigitte.core.arch

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

interface EventInterface {
    val event: LiveData<Event<Pair<Int, Any?>>>
    fun sendEvent(key: Int, value: Any)
    fun sendEvent(key: Int)
}

/**
 * viewmodel 에서 composite 형태로 추가 해서 사용
 */
class EventComp @Inject constructor() : EventInterface {
    private val _event = MutableLiveData<Event<Pair<Int, Any?>>>()
    override val event: LiveData<Event<Pair<Int, Any?>>> = _event

    override fun sendEvent(key: Int, value: Any) {
        _event.value = Event(key to value)
    }

    override fun sendEvent(key: Int) {
        _event.value = Event(key to null)
    }
}

/**
 * activity/fragment 에서 composite 형태로 추가해서 사용
 */
class EventProcess @Inject constructor() {
    fun observeEvent(lifecycleOwner: LifecycleOwner, viewModel: ViewModel) {
        if (viewModel is EventInterface) {
            viewModel.event.observe(lifecycleOwner, EventObserver {
                onEvent(it.first, it.second)
            })
        }
    }

    open fun onEvent(event: Int, data: Any?) {

    }
}