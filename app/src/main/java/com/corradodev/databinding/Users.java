package com.corradodev.databinding;

import android.databinding.ObservableArrayList;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by davidcorrado on 9/24/15.
 */
public class Users {
    public final ItemView itemView = ItemView.of(com.corradodev.databinding.BR.user, R.layout.item_user);
    public final ObservableArrayList<User> users = new ObservableArrayList<>();
}
