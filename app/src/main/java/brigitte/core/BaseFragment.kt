package brigitte.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import brigitte.core.extension.dataBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<VB: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : Fragment() {
    protected val disposable = CompositeDisposable()
    protected lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = dataBinding(layoutId)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onDestroyView() {
        disposable.dispose()
        super.onDestroyView()
    }
}