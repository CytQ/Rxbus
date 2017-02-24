package com.imlzq.rxbus.events;

import android.util.Log;

import com.imlzq.rxbus.data.DataManager;
import com.imlzq.rxbuslib.Event;
import com.imlzq.rxbuslib.RxBus;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

import static com.imlzq.rxbus.utils.Utils.checkNotNull;

/**
 * Created by lizhongquan on 2017/2/24.
 */

public class MainPresenter implements MainContract.Presenter {

    private final String TAG = "MainPresenter";

    private CompositeSubscription subscriptions;

    private Subscription rxbus;

    private DataManager dataManager;

    private MainContract.View view;

    public MainPresenter(DataManager dataManager, MainContract.View view) {
        this.dataManager = checkNotNull(dataManager, "DataManager cannot be null");
        this.view = checkNotNull(view, "View cannot be null");

        subscriptions = new CompositeSubscription();

        this.view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        bindBus();
    }

    private void bindBus() {
        if (rxbus == null) {
            rxbus = RxBus.getInstance().toObserverable()
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Func1<Object, Event>() {
                        @Override
                        public Event call(Object o) {
                            return (Event) o;
                        }
                    })
                    .subscribe(new Action1<Event>() {
                        @Override
                        public void call(Event event) {
                            handleEvent(event);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.d(TAG, throwable.getMessage());
                        }
                    });

            subscriptions.add(rxbus);
        }
    }

    private void handleEvent(Event event) {
        if (event == null || event.getEventName() == null) {
            return;
        }

        switch (event.getEventName()) {
            case EventConstants.SEND_MSG:
                view.showMsg(event.getEventInfo().getString("info"));
                break;

            default:
                Log.d(TAG, "Receives a default message from Rxbus : " + event.toString());
        }
    }

    @Override
    public void unSubscribe() {
        if (subscriptions != null) {
            subscriptions.clear();
        }
    }
}
