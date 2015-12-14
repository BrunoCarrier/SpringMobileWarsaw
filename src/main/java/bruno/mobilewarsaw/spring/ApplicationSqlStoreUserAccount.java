//package bruno.mobilewarsaw.spring;
//
//import bruno.mobilewarsaw.spring.useraccount.AppUser;
//import bruno.mobilewarsaw.spring.useraccount.UserDao;
//import bruno.mobilewarsaw.spring.useraccount.UserRole;
//import bruno.mobilewarsaw.spring.useraccount.UserRoleDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//
//@EnableAutoConfiguration
//@EnableWebMvc
//@Configuration
//@ComponentScan
//public class ApplicationSqlStoreUserAccount implements CommandLineRunner {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ApplicationSqlStoreUserAccount.class, args);
//    }
//
//    @Autowired UserDao userDao;
//    @Autowired UserRoleDao userRoleDao;
//
//    @Override
//    public void run(String... args) throws Exception {
//        AppUser user = new AppUser("bruno", "potato", true);
//        UserRole userRole = new UserRole("bruno", "user");
//
//        AppUser user2 = new AppUser("Aleksandra", "secret", true);
//        UserRole userRole2 = new UserRole("Aleksandra", "user");
//
//        userDao.saveOrUpdate(user);
//        userRoleDao.saveOrUpdate(userRole);
//
//        userDao.saveOrUpdate(user2);
//        userRoleDao.saveOrUpdate(userRole2);
//    }
//}
