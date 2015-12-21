package architecture.mvptest.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import architecture.mvptest.rest.restmodels.TriviaResponse;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;

/**
 * Created by Tiago on 21/12/2015.
 */
public class RestClient {

    private static final String REST_ENDPOINT = "http://numbersapi.com";
    public static final RestClient instance = new RestClient();

    private RestAdapter mRestAdapter;
    private RestInterface mRestInterface;
    private RequestInterceptor mRequestInterceptor;

    private RestInterface getRestInterface(){
        if(mRestInterface == null) {
            mRestInterface = getRestAdapter().create(RestInterface.class);
        }
        return mRestInterface;

    }

    private RestAdapter getRestAdapter(){

        if(mRestAdapter == null){
            GsonBuilder mGsonBuilder = new GsonBuilder().disableHtmlEscaping();
            mGsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Gson mGson = mGsonBuilder.create();

            try {
                mRestAdapter = new RestAdapter.Builder()
                        .setEndpoint(REST_ENDPOINT)
                        .setConverter(new GsonConverter(mGson))
                        .setLogLevel(RestAdapter.LogLevel.FULL)
                        .build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mRestAdapter;
    }

    public Observable<TriviaResponse> getRandomTrivia(){
        return getRestInterface().getRandomTrivia();
    }

}
