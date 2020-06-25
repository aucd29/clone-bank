package brigitte.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import brigitte.core.extension.dataBinding
import brigitte.core.extension.dataBindingView
import io.reactivex.disposables.CompositeDisposable

open class BaseActivity<VB: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {
    protected val disposable = CompositeDisposable()
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = dataBindingView(layoutId)
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}