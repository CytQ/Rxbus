package com.imlzq.rxbuslib;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * RxBus
 * Created by lizhongquan on 2017/2/24.
 */
public class RxBus {

    private final Subject<Object, Object>
            rxBus = new SerializedSubject<>(PublishSubject.create());

    private RxBus() {

    }

    public static RxBus getInstance() {
        return RxbusHolder.instance;
    }

    private static class RxbusHolder {
        private static final RxBus instance = new RxBus();
    }

    public void send(Event o) {
        rxBus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return rxBus;
    }
}
