package Additional;

import java.util.regex.Pattern;

// This class houses the function used to validate the data entered by the user
public class Validation {

    // Utility Functions
    // This function will validate the name
    public static boolean checkName(String s){
        if(s.length()==0){
            return false;
        }
        String pat="^[A-Z][a-zA-Z ]{2,20}$";
        return Pattern.matches(pat,s);
    }

    // This function will validate the Phone number
    public static boolean checkPhone(String ph){
        if(ph.length()==0){
            return false;
        }
        String pat="^[6-9][0-9]{9}$";
        return Pattern.matches(pat,ph);
    }

    // This function will validate the given email address
    public static boolean checkMail(String mail){
        if(mail.length()==0){
            return false;
        }
        String pat="^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(pat,mail);
    }

    // This function will validate the given password
    public static boolean checkPassword(String pass){
        String pat="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
        return Pattern.matches(pat,pass);
    }

    // This function will validate the given aadhar number
    public static boolean checkAadhar(String aadhar){
        String pat="^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
        return Pattern.matches(pat,aadhar);
    }

    // This function will validate the given Passport
    public static boolean checkPassport(String pass){
        String pat="^[A-PR-WYa-pr-wy][1-9]\\d"+"\\s?\\d{4}[1-9]$";
        return Pattern.matches(pat,pass);
    }
}


