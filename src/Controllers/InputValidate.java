/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author quant
 */
public class InputValidate {
    
    public static boolean IsBlank(String input){
        return input.trim().isBlank();
    }
    public static boolean IsNumberFormat(String input){
        return input.trim().matches("\\d+") && !input.contains("-1");
    }
    public static boolean IsPhoneNumber(String input){
        if(!IsNumberFormat(input))return false;
        return input.trim().length() == 10 || input.trim().length() == 11;
    }
    public static boolean IsEmail(String input){
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(input.trim());
        return matcher.matches();
    }
}
