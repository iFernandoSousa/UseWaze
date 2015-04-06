/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
package br.com.hotforms;

import android.util.Log;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ActivityNotFoundException;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class UseWaze extends CordovaPlugin {
    private static final String TAG = "UseWaze";
    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false otherwise.
     */
    @Override
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        Log.v(TAG, "Executing action: " + action);
        
	if ("search".equals(action)) {            
            callWaze("waze://?q=" + args.getString(0));
            return true;
        }
		else if ("centerOnMap".equals(action)) {            
            callWaze("waze://?ll=" + args.getString(0) + "," + args.getString(1) + "&z=" + args.getString(2));
            return true;
        }
		else if ("navigateTo".equals(action)) {
            callWaze("waze://?ll=" + args.getString(0) + "," + args.getString(1) + "&navigate=yes");
            return true;
        }

        return false;
    }

    private void callWaze(final String url) {
		this.cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try
				{
					Intent intent = null;
					intent = new Intent(Intent.ACTION_VIEW);
					// Omitting the MIME type for file: URLs causes "No Activity found to handle Intent".
					// Adding the MIME type to http: URLs causes them to not be handled by the downloader.
					Uri uri = Uri.parse(url);
					if ("file".equals(uri.getScheme())) {
						intent.setDataAndType(uri, webView.getResourceApi().getMimeType(uri));
					} else {
						intent.setData(uri);
					}

					this.cordova.getActivity().startActivity(intent);
				}
				catch (ActivityNotFoundException ex)
				{
					url = "market://details?id=com.waze";
					Intent intent = null;
					intent = new Intent(Intent.ACTION_VIEW);
					// Omitting the MIME type for file: URLs causes "No Activity found to handle Intent".
					// Adding the MIME type to http: URLs causes them to not be handled by the downloader.
					Uri uri = Uri.parse(url);
					if ("file".equals(uri.getScheme())) {
						intent.setDataAndType(uri, webView.getResourceApi().getMimeType(uri));
					} else {
						intent.setData(uri);
					}
						
					this.cordova.getActivity().startActivity(intent);
				}
			}
		});
    }
}
