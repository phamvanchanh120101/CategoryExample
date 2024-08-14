import android.app.Application
import android.content.Context
import com.example.categoryexample.CategoryExample
import com.example.categoryexample.data.local.AppDatabase
import com.example.categoryexample.data.local.dao.CategoryDao
import com.example.categoryexample.data.local.dao.KioskConfigDao
import com.example.categoryexample.data.local.dao.ModelDao
import com.example.categoryexample.data.network.ApiService
import com.example.categoryexample.data.network.RetrofitClient
import com.example.categoryexample.domain.repository.DataRepository
import com.example.categoryexample.ui.viewmodel.MainViewModel
import com.example.categoryexample.ui.viewmodel.MainViewModelFactory
import com.example.categoryexample.ui.viewmodel.SplashViewModel
import com.example.categoryexample.ui.viewmodel.SplashViewModelFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val appModule = DI.Module("appModule") {

    // Provide Application instance directly (assuming access to the application instance)
    bind<Application>() with singleton { CategoryExample.instance } // Assuming MyApplication extends Application

    // Bind Context using the provided Application instance
    bind<Context>() with singleton { instance<Application>().applicationContext }

    // Bind other dependencies
    bind<AppDatabase>() with singleton { AppDatabase.getInstance(instance()) }
    bind<KioskConfigDao>() with singleton { instance<AppDatabase>().kioskConfigDao() }
    bind<CategoryDao>() with singleton { instance<AppDatabase>().categoryDao() }
    bind<ModelDao>() with singleton { instance<AppDatabase>().modelDao() }

    bind<RetrofitClient>() with singleton { RetrofitClient } // Consider using provider if instance creation involves logic
    bind<ApiService>() with singleton { RetrofitClient.createService(ApiService::class.java) }
    bind<DataRepository>() with singleton { DataRepository(instance(), instance(), instance(), instance()) }

    bind<SplashViewModelFactory>() with singleton { SplashViewModelFactory(instance()) }
    bind<SplashViewModel>() with provider { SplashViewModel(instance()) }

    bind<MainViewModelFactory>() with singleton { MainViewModelFactory(instance()) }
    bind<MainViewModel>() with provider { MainViewModel(instance()) }
}
