package bruno.mobilewarsaw.spring;

import bruno.mobilewarsaw.spring.useraccount.AppUser;
import bruno.mobilewarsaw.spring.useraccount.UserDao;
import bruno.mobilewarsaw.spring.useraccount.UserRole;
import bruno.mobilewarsaw.spring.useraccount.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class ApplicationSqlStoreUserAccount implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationSqlStoreUserAccount.class, args);
    }

    @Autowired UserDao userDao;
    @Autowired UserRoleDao userRoleDao;

    @Override
    public void run(String... args) throws Exception {
        AppUser user = new AppUser("Aleksandra", "secret", true);
        UserRole userRole = new UserRole("Aleksandra", "user");

        userDao.saveOrUpdate(user);
        userRoleDao.saveOrUpdate(userRole);
    }
}
