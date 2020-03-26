package com.example.freelanceplatform

import android.app.Application
import com.example.freelanceplatform.model.FirebaseSource
import com.example.freelanceplatform.repository.FreelancerRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class FreelanceApplication() : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@FreelanceApplication))

        bind() from singleton { FirebaseSource() }
        bind() from singleton { FreelancerRepository(instance()) }

    }
}