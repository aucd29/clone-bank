package brigitte.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import brigitte.core.arch.EventComp
import brigitte.core.arch.EventObserver
import brigitte.core.extension.dataBinding
import brigitte.core.extension.dataBindingView
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<VB: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {
    protected val disposable = CompositeDisposable()
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = dataBindingView(layoutId)
        binding.lifecycleOwner = this@BaseActivity
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}