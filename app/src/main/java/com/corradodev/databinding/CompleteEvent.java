package com.corradodev.databinding;

import java.util.List;

/**
 * Created by victorcassone on 4/8/16.
 */
public class CompleteEvent {

  private List<Location> locationList;

  public CompleteEvent(List<Location> locationList) {
    this.locationList = locationList;
  }

  public List<Location> getLocationList() {
    return locationList;
  }

  public void setLocationList(List<Location> locationList) {
    this.locationList = locationList;
  }
}
