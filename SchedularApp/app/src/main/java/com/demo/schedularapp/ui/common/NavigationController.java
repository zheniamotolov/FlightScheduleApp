package com.demo.schedularapp.ui.common;

import android.app.FragmentManager;

import com.demo.schedularapp.R;

import javax.inject.Inject;

public class NavigationController {
    private final int containerId;
//    private final FragmentManager fragmentManager;

    @Inject
    public  NavigationController(){
        containerId= R.id.fragment_container;
    }

}
