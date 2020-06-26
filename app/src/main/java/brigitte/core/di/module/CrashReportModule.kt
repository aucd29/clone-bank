package brigitte.core.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

@Module
@InstallIn(ApplicationComponent::class)
class CrashReportModule {

}

class CrashReport @Inject constructor() {
    fun report(t: Throwable) {
        // TODO
    }
}