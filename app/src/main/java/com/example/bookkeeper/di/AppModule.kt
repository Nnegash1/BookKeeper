package com.example.bookkeeper.di

import android.app.Application
import androidx.room.Room
import com.example.bookkeeper.data.data_source.local.InvoiceDataBase
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import com.example.bookkeeper.data.data_source.repository.InvoiceRepository as RepoImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun invoiceViewModelProvider(repo: InvoiceRepository): InvoiceViewModelFactory {
        return InvoiceViewModelFactory(repo)
    }

    @Provides
    @Singleton
    fun invoiceRepositoryProvider(db: InvoiceDataBase): InvoiceRepository {
        return RepoImplementation(db.getDao())
    }

    @Provides
    @Singleton
    fun provideDataBase(app: Application) = Room.databaseBuilder(
        app,
        InvoiceDataBase::class.java,
        InvoiceDataBase.INVOICE_NAME
    ).build()

    @Provides
    fun provideDao(db: InvoiceDataBase) = db.getDao()
}