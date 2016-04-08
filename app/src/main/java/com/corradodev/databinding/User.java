package com.corradodev.databinding;

import android.databinding.ObservableField;

/**
 * Created by davidcorrado on 9/24/15.
 */
public class User {
    public final ObservableField<String> name = new ObservableField<>();

    public User(String name) {
        this.name.set(name);
    }
}
