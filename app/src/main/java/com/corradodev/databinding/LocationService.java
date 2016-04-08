package com.corradodev.databinding;

import com.corradodev.databinding.Location;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by victorcassone on 4/1/16.
 */
public interface LocationService {

  @Headers({
          "Content-Type: application/json",
          "Accept: application/json" })
  @GET("api/v1/locations.json")
  Call<List<Location>> listLocations(@Header("Authorization") String token);
}
