package com.corradodev.databinding;

/**
 * Created by victorcassone on 4/1/16.
 */
public class Location {

  String id;
  String foursquare_id;
  String name;
  String address;
  String city;
  String state;
  String postal_code;
  String country;
  String cc;
  String lat;
  String lng;

  public Location(String name) {
    this.name = name;
  }
}
