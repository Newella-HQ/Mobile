package ru.plodushcheva.newella

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.plodushcheva.newella.center.creating.di.creatingModule
import ru.plodushcheva.newella.center.reading.di.readingModule
import ru.plodushcheva.newella.common.novel.di.novelModule
import ru.plodushcheva.newella.db.mode.modeDataBaseModule
import ru.plodushcheva.newella.home.di.homeModule
import ru.plodushcheva.newella.library.di.libraryModule
import ru.plodushcheva.newella.main.di.mainModule
import ru.plodushcheva.newella.navigation.navigationModule
import ru.plodushcheva.newella.profile.about.di.aboutModule
import ru.plodushcheva.newella.profile.auth.di.authModule
import ru.plodushcheva.newella.profile.history.di.historyModule
import ru.plodushcheva.newella.profile.main.di.profileModule
import ru.plodushcheva.newella.profile.ratings.di.ratingsModule
import ru.plodushcheva.newella.profile.settings.di.settingsModule
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
                modeDataBaseModule,

                networkModule,

                homeModule,
                searchModule,
                libraryModule,

                profileModule,
                aboutModule,
                historyModule,
                ratingsModule,
                settingsModule,

                creatingModule,
                readingModule,
                authModule,

                novelModule
            )
        }
    }
}