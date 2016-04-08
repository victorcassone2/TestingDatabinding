package com.corradodev.databinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.corradodev.databinding.databinding.FragmentListBinding;
import com.google.gson.JsonElement;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by davidcorrado on 9/24/15.
 */
public class ListFragment extends Fragment {
  FragmentListBinding binding;

  public static ListFragment newInstance() {
    return new ListFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    EventBus.getDefault().register(this);
    binding = FragmentListBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    EventBus.getDefault().unregister(this);

  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.3.227:3000")
            .build();

    LocationService locationService = retrofit.create(LocationService.class);
    Call<List<Location>> locationCall = locationService.listLocations(HttpUtil.createBasicAuthToken("7d25cb7d04e6648aca578bcc3d04d33628b3896f", ""));
    locationCall.enqueue(new Callback<List<Location>>() {
      @Override
      public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
        EventBus.getDefault().post(new CompleteEvent(response.body()));
      }

      @Override
      public void onFailure(Call<List<Location>> call, Throwable t) {

      }
    });
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  public void onEvent(CompleteEvent completeEvent){
    List<Location> locationList = completeEvent.getLocationList();
    Users users = new Users();
    for (Location location : locationList) {
      users.users.add(new User(location.name));
    }
    binding.setUsers(users);
  }
}
