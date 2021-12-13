import dataAccess.concretes.HibernateUserDao;
import entity.concretes.User;
import service.abstracts.UserService;
import service.concretes.UserManager;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserManager(new HibernateUserDao());
        User user = new User("Ahmet","Dede",
                "ahmet@dede.com","123321",true);
        userService.register(user);
        userService.login(user);
        userService.confirm(user);

    }
}
