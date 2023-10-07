/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import data_access.UserDao;
import java.util.HashMap;
import model.AccountData;

/**
 *
 * @author GoldCandy
 */
public class UserRepository implements IUserRepository {

    @Override
    public void addAccount(HashMap<String, AccountData> accounts, AccountData account) {
        if (UserDao.Instance().addAcount(accounts, account)) {
            System.out.println("Successful");
        } else {
            System.out.println("Username exist!");
        }
    }

    @Override
    public void loginSystem(HashMap<String, AccountData> accounts, AccountData account) {
        if(account.readFromFile() == null){
            System.out.println("No user in file, please register first!");
            return;
        }
        if (UserDao.Instance().loginSystem(accounts, account)) {
            System.out.println("Login successfully");
        } else {
            System.out.println("Invalid username or password");
        }
    }
}
