/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author GoldCandy
 */
public class AccountData implements Serializable {

    private String username;
    private String password;
    private HashMap<String, AccountData> accounts = new HashMap();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, AccountData> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, AccountData> accounts) {
        this.accounts = accounts;
    }

    public void writeToFile(HashMap<String, AccountData> accounts) {
        HashMap<String, AccountData> existingFile = readFromFile();
        if (existingFile != null) {
            existingFile.putAll(accounts);
        } else {
            existingFile = accounts;
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
                oos.writeObject(existingFile);
                oos.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public HashMap<String, AccountData> readFromFile() {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
                return (HashMap<String, AccountData>)ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
