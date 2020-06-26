package brigitte.core.di.module

import android.util.Log
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

// https://github.com/JakeWharton/timber/blob/master/timber-sample/src/main/java/com/example/timber/ExampleApp.java

@Singleton
class TimberConfig @Inject constructor(
    private val userDebugTree: dagger.Lazy<UserDebugTree>,
    private val crashReportingTree : dagger.Lazy<CrashReportingTree>
) {
    fun setting(isDebug: Boolean) {
        Timber.plant(if (isDebug) {
            userDebugTree.get()
        } else {
            crashReportingTree.get()
        })
    }
}

@Singleton
class UserDebugTree @Inject constructor() : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return element.run {
            "[BK] ${fileName.replace(".kt|.java".toRegex(), "")}.$methodName($fileName:$lineNumber)"
        }
    }
}

@Singleton
class CrashReportingTree @Inject constructor(
    private val crashReport: CrashReport
) : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }

        t?.let {
            when (priority) {
                Log.ERROR -> crashReport.report(it)
            }
        }
    }
}