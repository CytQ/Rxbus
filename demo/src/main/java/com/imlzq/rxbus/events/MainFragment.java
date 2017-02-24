package com.imlzq.rxbus.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.imlzq.rxbus.R;
import com.imlzq.rxbuslib.Event;
import com.imlzq.rxbuslib.RxBus;

/**
 * Created by lizhongquan on 2017/2/24.
 */

public class MainFragment extends Fragment implements MainContract.View {

    private final String TAG = "MainFragment";

    private MainContract.Presenter presenter;

    private TextView textView;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.main_fragment, container, false);

        Button button = (Button) root.findViewById(R.id.button);
        textView = (TextView) root.findViewById(R.id.textview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("info", "testInfo");
                RxBus.getInstance().send(new Event(EventConstants.SEND_MSG, bundle,TAG));
            }
        });

        return root;
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void showMsg(String eventName) {
        textView.setText("Receives msg from rxbus : " + eventName);
    }
}
