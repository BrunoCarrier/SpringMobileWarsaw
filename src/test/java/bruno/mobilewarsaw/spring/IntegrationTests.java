package bruno.mobilewarsaw.spring;

import bruno.mobilewarsaw.spring.mobwawers.Mobwawers;
import com.google.common.io.BaseEncoding;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import retrofit.RestAdapter;

import java.util.Random;

import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
public class IntegrationTests {

    ServerApi retrofit = new RestAdapter.Builder()
            .setEndpoint("http://localhost:8080/")
            .build()
            .create(ServerApi.class);

    String username = "bruno";
    String password = "potato";

    @Test
    @Ignore
    public void addNewMobwawers() throws Exception {
        String base64Auth = "Basic " + BaseEncoding.base64().encode(new String(username + ":" + password).getBytes());

        Mobwawers newMobwawers = new Mobwawers("Jan Nowak", "dev@mobilewarsaw.pl", "iOs", 25);

        boolean response = retrofit.addMobwawers(base64Auth, newMobwawers);
        assertTrue("addNewMobwawers() failed", response == true);
    }

}
