/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access;

import common.Validation;
import java.util.HashMap;
import model.AccountData;

/**
 *
 * @author GoldCandy
 */
public class UserDao {

    private static UserDao instance = null;
    Validation valid = new Validation();

    public static UserDao Instance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    public boolean addAcount(HashMap<String, AccountData> accounts, AccountData account) {
        account.setUsername(valid.limitNonBlankString("Enter Username", 5));
        //check existing username
        if (valid.coincideCheck(accounts, account.getUsername())) {
            return false;
        }
        account.setPassword(valid.limitNonBlankString("Enter Password", 6));
        accounts.put(account.getUsername(), account);
        account.writeToFile(accounts);
        return true;
    }

    public boolean loginSystem(HashMap<String, AccountData> accounts, AccountData account) {
        account.setUsername(valid.limitNonBlankString("Enter Username", 5));
        account.setPassword(valid.limitNonBlankString("Enter Password", 6));
        if (accounts.get(account.getUsername()) == null) {
            return false;
        } else {
            if (!accounts.get(account.getUsername()).getPassword().equals(account.getPassword())) {
                return false;
            }
        }
        return true;
    }
}
