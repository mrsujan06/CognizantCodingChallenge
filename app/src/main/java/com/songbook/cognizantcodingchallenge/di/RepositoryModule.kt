package com.songbook.cognizantcodingchallenge.di

import com.songbook.cognizantcodingchallenge.data.DataSource
import com.songbook.cognizantcodingchallenge.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
open class RepositoryModule {

    @Provides
    open fun provideDataSource() = DataSource()

    @Provides
    open fun provideRepository(
        dataSource: DataSource
    ): Repository = Repository(dataSource)

}