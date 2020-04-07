package com.videos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main
{
                                        // Throws Exception añadido automaticamente(debido a constructor GenerateVideo ¿?¿)
    public static void main(String[] args) throws Exception
    {

        // Scanner for all App Videos
        Scanner scVF = new Scanner(System.in);

        // All inputs for User's Answers
        String userInputFirstMenu;
        String userInputLogRegMenu;
        String userInputUserMenu;
        String userInputVideoMenu;

        // All objects used for create multi-generic User/Video
        User userCreator;
        Video videoCreator;

        // Variables

        String loginUser ="";

        // All list of Users and Videos
        List<User> listAllUsers = new ArrayList<>();
        List<Video> userVideos = new ArrayList<>();
        List<String> tags = new ArrayList<>();

        // All booleans for app
        boolean itsUserLogin = false;
        boolean programOnline = true;

        // 1.0 - First contact with user across console.

        System.out.println();
        System.out.println("Welcome to VideoFidelity!");
        System.out.println("-------------------------");
        System.out.println("Note: if it's you're first time, you have to register for complete service access.");

        do //////////// MAIN MENU \\\\\\\\\\\\\
        {
            System.out.println();
            System.out.println("MAIN MENU:");
            System.out.println("Choose one option:");
            System.out.println();
            System.out.println("Are you logged? " + itsUserLogin);
            System.out.println();
            // 1.1 - Remove's options depending of user login.
            if(!itsUserLogin)
            {
                System.out.println("//1 - Login/Register");

            }
            System.out.println("//2 - User Menu (Under construction)");
            System.out.println("//3 - Videos Menu");
            System.out.println("//4 - Search Video (Under construction)");
            if(!itsUserLogin){
                System.out.println("//6 - Exit Program");
            } else {
                System.out.println("//5 - Logout");
                System.out.println("//6 - Exit Program");
            }
            userInputFirstMenu = scVF.next();

            // 1.2 - Same than 1.1 and checker you choose a number inside options and not another character o whitespace.
            if (userInputFirstMenu.equals("") || userInputFirstMenu.matches("[A-Za-z]") || !userInputFirstMenu.matches("[1-6]"))
            {
                System.out.println("You write wrong option, or nothing");
                System.out.println("Please, choose a correct option:");
                if(!itsUserLogin && userInputFirstMenu.matches("[5]") || userInputFirstMenu.matches("[1]") )
                {
                    System.out.println("This option, it's not disponible for unlogged users.");
                }
                continue;
            }

            // 2.0 - When first input has been entred, we show (following input) the correct menu.
            switch (userInputFirstMenu)
            {
                case "1": // 2.1 - First option, user choose between login and register
                    if(itsUserLogin)
                    {
                        System.out.println("For access to this options, please, loggout first.");
                        continue;
                    }
                    else
                    {
                        System.out.println("Login/Register Menu:");
                        System.out.println("Choose an option");
                        System.out.println();
                        System.out.println("//1 - Login");
                        System.out.println("//2 - Register");
                        System.out.println("//3 - Back");
                        userInputLogRegMenu = scVF.next();
                        switch (userInputLogRegMenu)
                        {
                            case "1":   //////////// LOGIN/REGISTER MENU \\\\\\\\\\\\\
                                System.out.println("Login");
                                System.out.println("-------------------------");
                                try
                                {
                                    User user = LoginUser(scVF, listAllUsers);
                                    System.out.println("Bienvenido " + user.userName + "!");
                                    loginUser = user.userName;
                                    itsUserLogin = true;
                                    continue;
                                }
                                catch (Exception e)
                                {
                                    System.out.println("Problem with user loggin (Try,Catch), follow console path for more details.");
                                    e.printStackTrace();
                                    e.getMessage();
                                    continue;
                                }
                            case "2": // Register section
                                System.out.println("Register");
                                System.out.println("-------------------------");
                                try
                                {
                                    listAllUsers.add(GenerateUser(scVF, listAllUsers));
                                    System.out.println("User info: " + listAllUsers.toString());
                                    System.out.println("Check passed! Your registration is complete!");
                                    System.out.println("Remember your user and pass for enter to VideoFidelity. Returning to Main menu");
                                    continue;
                                }
                                catch (Exception i)
                                {
                                    System.out.println("Problem with user registration, follow console path for more details.");
                                    i.printStackTrace();
                                    System.out.println("Re-directing to main menu...");
                                    continue;
                                }
                            case "3":
                                continue;
                            default:
                                System.out.println("Exit program by case \"default\"");
                                break;
                        }
                    }
                case "2": // 2.1 - First option, user choose between login and register
                    if(itsUserLogin)
                    {
                        System.out.println();
                        System.out.println("You are logged? " + itsUserLogin);
                        System.out.println();
                        System.out.println("User Menu:");
                        System.out.println("Choose an option");
                        System.out.println();
                        System.out.println("//1 - Change password (Under construction)");
                        System.out.println("//2 - Erase User (Under construction)");
                        System.out.println("//3 - Back");
                        System.out.println("//4 - Logout");
                        userInputUserMenu = scVF.next();
                        switch (userInputUserMenu)
                        {
                            case "1": //////////// USER MENU \\\\\\\\\\\\\
                                System.out.println("Change Password");
                                System.out.println("-------------------------");
                                System.out.println("Under construction..., please go back");
                                continue;
                            case "2":
                                System.out.println("Erase user");
                                System.out.println("-------------------------");
                                System.out.println("Under construction..., please go back");
                                continue;
                            case "3":
                                continue;
                            case "4":
                                System.out.println(loginUser + ", are you sure you want logout? (yes/no)");
                                String confirmLogOut = scVF.next().toLowerCase();
                                if(confirmLogOut.equals("yes"))
                                {
                                    System.out.println("Loggin out...");
                                    loginUser = "";
                                    itsUserLogin = false;
                                }
                                continue;
                            default:
                                System.out.println("Exit program by case \"default\"");
                                break;
                        }
                    }
                    else
                    {
                        System.out.println("You need have logged in VideoFidelity before access to User Menu.");
                        continue;
                    }
                case "3":           //////////// VIDEO MENU \\\\\\\\\\\\\
                    if(itsUserLogin)
                    { //3.0 - Video menu, creation and view all videos
                        System.out.println("Video Menu, choose one option");
                        System.out.println("//1 - Create video");
                        System.out.println("//2 - All my videos");
                        System.out.println("//3 - Back");
                        userInputVideoMenu = scVF.next();
                        switch (userInputVideoMenu)
                        {
                            case "1": // 3.1 - Create video Section
                                System.out.println("Create video");
                                System.out.println("-------------------------");
                                userVideos.add(videoCreator = GenerateVideo(scVF, userVideos, loginUser, tags));
                                System.out.println("Video info: " + videoCreator.urlToString());
                                continue;
                            case "2": // 3.2 - All my videos section
                                System.out.println("All my videos");
                                System.out.println("-------------------------");
                                System.out.println("Your video's list: " + userVideos);
                            case "3":
                                continue;
                            default:
                                System.out.println("Exit program by case \"default\"");
                                break;
                        }
                    }
                    else
                    {
                        System.out.println("You need have logged in VideoFidelity before access to Video Menu.");
                        continue;
                    }
                case "4": //////////// SEARCH MENU \\\\\\\\\\\\\
                    // Search Menu include an automatic search by tags/title
                    System.out.println("Search videos");
                    System.out.println("-------------------------");
                    System.out.println("Under construction..., please go back");
                    continue;
                case "5":
                    if(itsUserLogin)
                    {
                        System.out.println("Are you sure you want logout? (yes/no)");
                        String confirmLogOut = scVF.next().toLowerCase();
                        if(confirmLogOut.equals("yes"))
                        {
                            itsUserLogin = false;
                        }
                        continue;
                    }
                    else
                    {
                        System.out.println("You need to have logged in VideoFidelity for loggout option.");
                    }

                case "6":
                    System.out.println("Thank you for use VideoFidelity! See you next time!");
                    programOnline = false;
                    break;
                default:
                    System.out.println("Exit program by case \"default\"");
                    break;
            }
        }
        while (programOnline);
    }

    // Constructor Generate User for Register

    public static User GenerateUser(Scanner scVF, List<User> listAllUsers) throws Exception
    {
        System.out.println("User name:");
        String userN = scVF.next();
        System.out.println("User surname:");
        String userSN = scVF.next();
        System.out.println("User password:");
        String userP = scVF.next();

        if (userN.equals(""))
            throw new Exception("You have to write a user name, please");
        else if(userSN.equals(""))
            throw new Exception("You have to write a user surname, please");
        else if(userP.equals(""))
            throw new Exception("You have to write a password, please");

        Date userD = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.print("Your registration date: " + dateFormat.format(userD) + ", ");
        System.out.println("working for create a new user, waiting for exceptions filter...");

        Integer userID = 1;
        for(int e = 0; e < listAllUsers.size(); e++) //ID Setter
        {
            userID++;
        }
        return new User(userID, userN, userSN, userP, userD);
    }

    // Constructor Login for login

    public static User LoginUser(Scanner scVF, List<User> listAllUsers) throws Exception
    {
        User output = null;

        System.out.println("Write your user:");
        String usrLog = scVF.next();
        System.out.println("Write your password:");
        String usrPwr = scVF.next();

        for(User user: listAllUsers)
        {
            boolean x = user.CheckUser(usrLog);
            boolean y = user.CheckPassword(usrPwr);
            if(x && y)
                output = user;
            else if (!x || !y)
                System.out.println("You have misspelled the Username / Password, please try again.");
        }
        if(output==null)
        {
            throw new Exception("The user does not exist in the list");
        }
        return output;
    }

    // Constructor GenerateoVideo for Videos

    public static Video GenerateVideo(Scanner scVF, List<Video> usersVideo,  String loginUser, List<String> videoTags) throws Exception
    {
        boolean moreTags = true;

        String templateUrl = "https://videofidelity.vf/" + loginUser + "/video/";

        Integer videoID = 1;

        System.out.println("For technical reasons, you can write the title of the video in a input Dialog panel please.");
        String videoTitle = JOptionPane.showInputDialog("Video name/title:");

        if(videoTitle.equals(""))
            throw new Exception("Write a title, please");

        System.out.println("Add first video tag:");
        String tags = scVF.next();
        videoTags.add(tags.toLowerCase());

        do
        {
            System.out.println("Do you want add more tags?(yes/no)");
            String askTag = scVF.next().toLowerCase();

            if(askTag.equals("no"))
            {
                moreTags = false;
            }
            else if(askTag.equals(""))
            {
                throw new Exception("Write a tag please.");
            }
            else
            {
                System.out.println("Add next video tag:");
                tags = scVF.next();
                videoTags.add(tags);
            }
        }
        while (moreTags);

        for(int e = 0; e < usersVideo.size(); e++)
        {
            videoID++;
        }

        return new Video(videoID, templateUrl, videoTitle, loginUser, videoTags);
    }

}