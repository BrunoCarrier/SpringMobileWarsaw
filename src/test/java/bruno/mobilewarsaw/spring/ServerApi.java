package bruno.mobilewarsaw.spring;

import bruno.mobilewarsaw.spring.mobwawers.Mobwawers;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;

public interface ServerApi {

    @POST("/" + "addMobwawers")
    boolean addMobwawers(@Header("Authorization") String authorization, @Body Mobwawers mobwawers);


}
