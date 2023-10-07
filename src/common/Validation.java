/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import model.AccountData;

/**
 *
 * @author GoldCandy
 */
public class Validation {

    public String limitNonBlankString(String title, int minimum) {
        String s = "";
        while (s.length() < minimum || s.contains("\\s")) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
            if (s.length() < minimum || s.contains("\\s")) {
                System.out.println("You must enter least at " + minimum + " and no space");
            }
        }
        return s;
    }

    public boolean coincideCheck(HashMap<String, AccountData> accounts, String name) {
        Set<String> keySet = accounts.keySet();
        for (String key : keySet) {
            if (accounts.get(key).getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
