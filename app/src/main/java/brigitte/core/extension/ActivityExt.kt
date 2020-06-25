@file:Suppress("NOTHING_TO_INLINE", "unused")
package brigitte.core.extension

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter

////////////////////////////////////////////////////////////////////////////////////
//
// DATA BINDING
//
////////////////////////////////////////////////////////////////////////////////////

inline fun <T : ViewDataBinding> Fragment.dataBinding(
    @LayoutRes layoutid: Int,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): T = DataBindingUtil.inflate(layoutInflater, layoutid, parent, attachToParent)

inline fun <T : ViewDataBinding> Activity.dataBinding(
    @LayoutRes layoutid: Int,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): T = DataBindingUtil.inflate(layoutInflater, layoutid, parent, attachToParent)

inline fun <T : ViewDataBinding> Activity.dataBindingView(
    @LayoutRes layoutid: Int
): T = DataBindingUtil.setContentView(this, layoutid)

inline fun <T: ViewDataBinding> PagerAdapter.dataBinding(
    @LayoutRes resid: Int,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): T = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), resid, parent, attachToParent)