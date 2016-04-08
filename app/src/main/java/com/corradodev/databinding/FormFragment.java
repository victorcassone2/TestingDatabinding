package com.corradodev.databinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.corradodev.databinding.databinding.FragmentFormBinding;

/**
 * Created by davidcorrado on 9/24/15.
 */
public class FormFragment extends Fragment {
    private FragmentFormBinding binding;

    public static FormFragment newInstance() {
        return new FormFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final FragmentFormBinding binding = FragmentFormBinding.inflate(inflater, container, false);
        binding.setUser(new User("David Corrado"));
        binding.btnResetToDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The below is needed because the setter doesn't work unless you update the model first
                binding.getUser().name.set(binding.etFirstName.getText().toString());
                binding.getUser().name.set("David Corrado");
            }
        });
        return binding.getRoot();
    }
}
