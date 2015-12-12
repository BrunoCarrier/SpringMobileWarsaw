package bruno.mobilewarsaw.spring.mobwawers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MobwawersController {

    @Autowired
    MobwawersDao mobwawersDao;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String addMobwawers() {
        Mobwawers mobwawers = new Mobwawers("Bruno", "brunopierrecarrier@gmail.com", "Android", 30);
        mobwawersDao.saveOrUpdate(mobwawers);
        return "You added a predefined Mobwawers!";
    }

    @RequestMapping(value = "/addMobwawers", method = RequestMethod.POST)
    boolean addMobwaversJson(@RequestBody Mobwawers mobwawers) {
        mobwawersDao.saveOrUpdate(mobwawers);
        return true;
    }

    @RequestMapping(value = "/findMobwawersUnsafe/{name}", method = RequestMethod.GET)
    Object unsafeMobwawersSearch(@PathVariable String name) {

        return mobwawersDao.dangerouslyGetMobwawerByName(name);
    }

    @RequestMapping(value = "/findMobwawersSafe", method = RequestMethod.POST)
    boolean safeMobwawersSearch(@RequestBody String name) {
        mobwawersDao.safelyGetMobwawerByName(name);
        return true;
    }

}
