package bruno.mobilewarsaw.spring.useraccount;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRoleDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRoleDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean saveOrUpdate(UserRole userRole){
        getCurrentSession().saveOrUpdate(userRole);
        return true;
    }
}
