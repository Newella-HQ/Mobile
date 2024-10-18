package ru.plodushcheva.newella

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.plodushcheva.newella.home.di.homeModule
import ru.plodushcheva.newella.main.di.mainModule
import ru.plodushcheva.newella.navigation.navigationModule
import ru.plodushcheva.newella.search.di.searchModule

class NewellaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@NewellaApplication)
            modules(
                navigationModule,
                mainModule,
                homeModule,
                searchModule
            )
        }
    }
}