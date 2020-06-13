package com.ae.mylibrary.core.di.module

import android.app.Application
import android.content.Context
import com.ae.mylibrary.BuildConfig
import com.ae.mylibrary.common.service.CharactersListService
import com.ae.mylibrary.entities.characterslist.interactor.CharactersListInteractor
import com.ae.mylibrary.entities.characterslist.interactor.CharactersListInteractorImpl
import com.ae.mylibrary.entities.characterslist.presenter.CharactersListPresenter
import com.ae.mylibrary.entities.characterslist.presenter.CharactersListPresenterImpl
import com.ae.mylibrary.entities.characterslist.view.CharactersListView
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    /**
     * Provide Application
     *
     * @return Application
     */
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    /**
     * Provide Context
     *
     * @return context
     */
    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

    /**
     * Provide Http Logging to log request
     *
     * @return HttpLoggingInterceptor
     */
    @Provides
    @Singleton
    fun provideHttpLogginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    /**
     * Provide OkHttpClient
     *
     * @param httpLoggingInterceptor
     * @return OkHttpClient
     */
    @Provides
    @Singleton
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    /**
     * Provide retrofit
     *
     * @param okHttpClient
     * @return Retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    /**
     * Provide retrofit service to characters list
     *
     * @param retrofit
     * @return CharactersListService
     */
    @Provides
    @Singleton
    fun provideCharactersListService(retrofit: Retrofit): CharactersListService {
        return retrofit.create(CharactersListService::class.java)
    }

    /**
     * Provide interactor to characters list
     *
     * @param charactersListService
     * @return CharactersListInteractor
     */
    @Provides
    @Singleton
    fun provideCharactersListInteractor(charactersListService: CharactersListService): CharactersListInteractor {
        return CharactersListInteractorImpl(charactersListService)
    }

    /**
     * Provide presenter to characters list
     *
     * @param view
     * @param charactersListInteractor
     * @return
     */
    @Provides
    @Singleton
    fun provideCharactersListPresenter(view: CharactersListView,
                                       charactersListInteractor: CharactersListInteractor): CharactersListPresenter {
        return CharactersListPresenterImpl(view, charactersListInteractor)
    }
}