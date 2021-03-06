package bruno.mobilewarsaw.spring.mobwawers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MobwawersDao {

    private SessionFactory sessionFactory;

    @Autowired
    public MobwawersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean saveOrUpdate(Mobwawers mobwawers){
        getCurrentSession().saveOrUpdate(mobwawers);
        return true;
    }

    public List<Mobwawers> safelyGetMobwawerByName(String name){
        Query hqlQuery = getCurrentSession().createQuery("from Mobwawers as mw where mw.name = :name");
        List<Mobwawers> results = hqlQuery.setString("name", name).list();

        return results;
    }

    public List<Mobwawers> dangerouslyGetMobwawerByName(String name){
        List<Mobwawers> results = getCurrentSession().createQuery("from Mobwawers where name = '" + name + "'").list();

        return results;
    }
}
