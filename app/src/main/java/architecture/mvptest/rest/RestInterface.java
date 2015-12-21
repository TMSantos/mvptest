package architecture.mvptest.rest;

import architecture.mvptest.rest.restmodels.TriviaResponse;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Tiago on 21/12/2015.
 */
public interface RestInterface {

    @GET("/random/trivia?json")
    Observable<TriviaResponse> getRandomTrivia();
}

