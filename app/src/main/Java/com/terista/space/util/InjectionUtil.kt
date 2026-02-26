package com.terista.space.util

import com.terista.space.data.AppsRepository
import com.terista.space.data.FakeLocationRepository
import com.terista.space.data.GmsRepository

import com.terista.space.view.apps.AppsFactory
import com.terista.space.view.fake.FakeLocationFactory
import com.terista.space.view.gms.GmsFactory
import com.terista.space.view.list.ListFactory



object InjectionUtil {

    private val appsRepository = AppsRepository()



    private val gmsRepository = GmsRepository()

    private val fakeLocationRepository = FakeLocationRepository()

    fun getAppsFactory() : AppsFactory {
        return AppsFactory(appsRepository)
    }

    fun getListFactory(): ListFactory {
        return ListFactory(appsRepository)
    }


    fun getGmsFactory():GmsFactory{
        return GmsFactory(gmsRepository)
    }

    fun getFakeLocationFactory():FakeLocationFactory{
        return FakeLocationFactory(fakeLocationRepository)
    }
}