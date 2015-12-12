package bruno.mobilewarsaw.spring;

import bruno.mobilewarsaw.spring.mobwawers.Mobwawers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import retrofit.RestAdapter;

import java.util.Random;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class IntegrationTests {

    ServerApi retrofit = new RestAdapter.Builder()
            .setEndpoint("http://localhost:8080/")
            .build()
            .create(ServerApi.class);

    @Test
    public void addNewMobwawers() throws Exception {
        Mobwawers newMobwawers = new Mobwawers("Mobile developer", "dev@mobilewarsaw.pl", "iOs", new Random().nextInt(30));

        boolean response = retrofit.addMobwawers(newMobwawers);
        assertTrue("addNewMobwawers() failed", response == true);
    }

}
