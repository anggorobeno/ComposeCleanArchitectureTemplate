package com.example.composecleanarchitecturetemplate.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.composecleanarchitecturetemplate.core.network.service.ApiService
import com.example.composecleanarchitecturetemplate.feature.main.data.SampleRepo
import com.example.composecleanarchitecturetemplate.feature.main.data.SampleRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences() }),
            produceFile = { context.preferencesDataStoreFile(StorageHelper.DATA) })
    }

    @Provides
    fun provideSampleRepo(apiService: ApiService): SampleRepo {
        return SampleRepoImpl(apiService)
    }
}