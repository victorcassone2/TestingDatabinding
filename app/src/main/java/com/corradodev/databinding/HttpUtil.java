package com.corradodev.databinding;

import android.util.Base64;

/**
 * Created by victorcassone on 4/5/16.
 */
public class HttpUtil {

  public static boolean isSuccess(int code) {
    return code == 201 || code == 200 || code == 202;
  }

  public static String createBasicAuthToken(String username, String password) {
    String credentials = username + ":" + password;
    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    final String token = "Basic " + base64EncodedCredentials;
    return token;
  }
}
