/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.HashMap;
import model.AccountData;

/**
 *
 * @author GoldCandy
 */
public interface IUserRepository {

    void addAccount(HashMap<String, AccountData> accounts, AccountData account);

    void loginSystem(HashMap<String, AccountData> accounts, AccountData account);

}
