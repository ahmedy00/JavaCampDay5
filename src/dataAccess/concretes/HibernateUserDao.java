package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entity.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {


    List<User> users = new ArrayList<User>();

    @Override
    public void register(User user) {
        System.out.println(user.getFirstName() +
                " isimli kullanıcı kaydedildi.");
    }

    @Override
    public void login(User user) {
        System.out.println("Giriş başarılı: " +user.getFirstName());
    }

    @Override
    public void confirm(User user) {
        System.out.println("Mail adresi onaylandı: "+user.geteMail());
        user.setVerify(true);
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
