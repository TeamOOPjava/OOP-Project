package com.example.libirary_;

import userprofile.Order;

import java.io.Serializable;
import java.util.ArrayList;

import static librarypackage.Library.users;

public class User extends Person implements Serializable {
    private static int userCounter =0;
    private static User currentUser;

  private ArrayList<Integer>userOrders = new ArrayList<>();//order id
    public User(ArrayList<Integer> userOrders,int id,String userName, String email, String password){

        super(id,userName,email,password);
        this.userOrders =userOrders;
    }
   public User(int id,String userName, String email, String password){

       super(id,userName,email,password);
   }
    public User(String userName, String email, String password) {
        super(userCounter+1,userName,email,password);
        userCounter++;
        users.add(this);
    }
    public static int getUserCounter() {
        return userCounter;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(User user){
        currentUser = user;
    }
    public void addOrder(int orderID){
       this.userOrders.add(orderID);
    }
    public boolean findOrderID(int orderId){

       for(Integer id : this.userOrders){
               if(orderId==id)
                   return true;
       }

       return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "userOrders=" + userOrders +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
