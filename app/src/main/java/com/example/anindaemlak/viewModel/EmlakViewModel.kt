package com.example.anindaemlak.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anindaemlak.model.Emlak
import com.example.anindaemlak.service.EmlakApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class EmlakViewModel : ViewModel()  {
    private val emlakApiService = EmlakApiService()
    private val disposable = CompositeDisposable()
    val getEmlakListLiveData = MutableLiveData<Emlak>()

    fun refreshDataEmlak() {
        getEmlakData()
    }

    fun getEmlakData() {
        disposable.add(
            emlakApiService.getEmlakData()
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Emlak>() {
                    override fun onSuccess(t : Emlak) {
                        getEmlakListLiveData.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}