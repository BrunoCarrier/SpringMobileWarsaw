package bruno.mobilewarsaw.spring;

import bruno.mobilewarsaw.spring.mobwawers.Mobwawers;
import retrofit.http.Body;
import retrofit.http.POST;

public interface ServerApi {

    @POST("/" + "addMobwawers")
    boolean addMobwawers(@Body Mobwawers mobwawers);


}
