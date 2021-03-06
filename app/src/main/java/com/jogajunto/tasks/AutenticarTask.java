package com.jogajunto.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.jogajunto.requests.AutenticacaoRequests;

import feign.Feign;
import feign.Logger;

/**
 * Created by lucasn on 23/10/2016.
 */

public class AutenticarTask extends AsyncTask<String, Void, Boolean> {

    @Override
    public Boolean doInBackground(String... params) {
        try{
            AutenticacaoRequests request = Feign.builder()
                    .logLevel(Logger.Level.FULL)
                    .target(AutenticacaoRequests.class, "http://jogajuntoapi.azurewebsites.net/api/");

            request.autenticar(params[0], params[1]);
            return true;
        }catch (Exception e){
            Log.d("Exception", e.toString());
            return false;
        }
    }
}
