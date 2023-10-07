/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.AccountData;
import repository.UserRepository;
import view.Menu;

/**
 *
 * @author GoldCandy
 */
public class UserController extends Menu{
    protected static String[] mc = {"Create a new account", "Login System", "Exit"};
    protected UserRepository userRepository;
    protected AccountData account;
    
    public UserController(){
        super("====== USER MANAGEMENT SYSTEM ======", mc);
        userRepository = new UserRepository();
        account = new AccountData();
    }

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:{
                System.out.println("------ Register ------");
                userRepository.addAccount(account.getAccounts(), new AccountData());
                break;
            }
            case 2:{
                System.out.println("------ Login ------");
                userRepository.loginSystem(account.getAccounts(), new AccountData());
                break;
            }
            case 3:{
                System.out.println("EXIT...");
                System.exit(0);
            }
            default:{
                System.out.println("No such choice!");
            }
        }
    }
}
