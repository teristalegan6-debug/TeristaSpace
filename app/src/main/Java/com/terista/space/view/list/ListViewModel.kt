package com.terista.space.view.list

import androidx.lifecycle.MutableLiveData
import com.terista.space.bean.InstalledAppBean
import com.terista.space.data.AppsRepository
import com.terista.space.view.base.BaseViewModel


class ListViewModel(private val repo: AppsRepository) : BaseViewModel() {

    val appsLiveData = MutableLiveData<List<InstalledAppBean>>()

    val loadingLiveData = MutableLiveData<Boolean>()

    fun previewInstalledList() {
        launchOnUI { repo.previewInstallList() }
    }

    fun getInstallAppList(userID: Int) {
        launchOnUI { repo.getInstalledAppList(userID, loadingLiveData, appsLiveData) }
    }
}
