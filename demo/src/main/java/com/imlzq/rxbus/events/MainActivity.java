package com.imlzq.rxbus.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.imlzq.rxbus.R;
import com.imlzq.rxbus.data.DataManager;
import com.imlzq.rxbus.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.container);

        if (fragment == null) {
            fragment = MainFragment.newInstance();

            Utils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.container);
        }

        new MainPresenter(DataManager.getInstance(), fragment);
    }
}
