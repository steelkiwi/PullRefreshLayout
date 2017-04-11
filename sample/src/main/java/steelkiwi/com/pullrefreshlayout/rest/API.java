package steelkiwi.com.pullrefreshlayout.rest;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import steelkiwi.com.pullrefreshlayout.rest.dto.PixabayResponse;

/**
 * Created by yaroslav on 4/11/17.
 */

public interface API {

    @GET("api/")
    Observable<PixabayResponse> getImages(@Query("key") String key);
}
