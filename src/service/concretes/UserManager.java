package service.concretes;

import dataAccess.abstracts.UserDao;
import dataAccess.concretes.HibernateUserDao;
import entity.concretes.User;
import service.abstracts.UserService;

public class UserManager implements UserService {
    private UserDao userDao;

    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {

        if (user.getPassword().length() < 6) {
            System.out.println("Şifre en az 6 karakterden oluşmalıdır.");
        }
        for (User users : userDao.getAll()) {
            if (users.geteMail().equals(user.geteMail())) {
                System.out.println("Bu e-posta sistemde zaten kayıtlı: " +
                        user.geteMail());
            }
        }
        if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
            System.out.println("Ad veya Soyad 2 harften küçük olamaz");
        }
    }

    @Override
    public void login(User user) {

        if (user.isVerify()) {
            userDao.login(user);
        } else {
            System.out.println("Giriş başarısız e-posta adresinizi kontrol edin");
        }

    }

    @Override
    public void confirm(User user) {

        if (user.isVerify()) {
            userDao.confirm(user);
        } else {
            System.out.println("e-posta adresiniz doğrulanmamıştır.");
        }
    }

    @Override
    public void registerWithAccount(User user) {

    }

    @Override
    public void loginWithAccount(User user) {

    }
}
