package com.videos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User
{

    protected List<User> listAllUsers ; // Contain all users of platform
    protected List<Video> userVideos;; // Contain all videos of user

    protected Integer userId;

    protected String userName;
    protected String userSurName;
    protected String userPassword;

    protected Date userRegister;

    public User(
            Integer userId,
            String userName,
            String userSurName,
            String userPassword,
            Date userRegister)
    {
        this.userId = userId;
        this.userName = userName;
        this.userSurName = userSurName;
        this.userPassword = userPassword;
        this.userRegister = userRegister;
        this.listAllUsers = new ArrayList<>();
        this.userVideos = new ArrayList<>();
    }

    // Check User

    public boolean CheckUser(String usrLog)
    {
        boolean x = false;
        if(this.userName.equals(usrLog))
        {
            x = true;
        }
        return x;
    }

    // Check Password

    public boolean CheckPassword(String usrPwr)
    {
        boolean y = false;
        if(this.userPassword.equals(usrPwr))
        {
            y = true;
        }
        return y;
    }

    // Password hidden method

    public String getUserPassword()
    {
        String hiddenPassword = "";
        for(int e = 0; e < userPassword.length(); e++)
        {
            hiddenPassword +="*";
        }
        hiddenPassword +="****";
        return hiddenPassword;
    }

    // User information show and overwrite password.

    @Override
    public String toString()
    { // CHECK PASSWORD HIDEN
        return "Information of user ID = " + userId + ", User Name = " + userName + ", User SurName = "   + userSurName + ", User Password = " + this.getUserPassword();
    }

}
