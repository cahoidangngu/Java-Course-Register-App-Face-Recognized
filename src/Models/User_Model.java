/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Quan's PC
 */
public class User_Model {
     public static boolean insertUser(User user){
        String querry = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?,?)";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setInt(1, user.getUserId());
            prepareStatement.setString(2, user.getUserRole());
            prepareStatement.setString(3, user.getFirstName());
            prepareStatement.setString(4, user.getMidName());
            prepareStatement.setString(5, user.getLastName());
            prepareStatement.setString(6, user.getUsername());
            prepareStatement.setString(7, user.getPassword());
            prepareStatement.setString(8, user.getPhone());
            prepareStatement.setString(9, user.getEmail());
            prepareStatement.setString(10, String.valueOf(user.isIsFaceRecognized()));
            
            return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
     public static boolean updateUser(User user){
        String querry = "UPDATE users SET user_username = ?,user_password = ?,user_phone = ?,user_email= ? WHERE user_id = ? ";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setString(1, user.getUsername());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getPhone());
            prepareStatement.setString(4, user.getEmail());
            prepareStatement.setInt(5, user.getUserId());
            return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
      public static boolean updateUserFaceRecogzie(int userId){
        String querry = "UPDATE users SET user_facerecognize = "+"true"+" WHERE user_id = ? ";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setInt(1, userId);
            return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
     
     
     public static boolean deletetUser(int userId){
        String querry = "DELETE FROM users WHERE user_id = ? ";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setInt(1, userId);
           
            
            return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
    public static User getUserById(int userId){
         User user = null;
        String querry = "SELECT * FROM users WHERE user_id = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setInt(1, userId);
            
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserRole(rs.getString("user_role").toUpperCase());
                user.setFirstName(rs.getString("user_firstname"));
                user.setMidName(rs.getString("user_midname"));
                user.setLastName(rs.getString("user_lastname"));
                user.setUsername(rs.getString("user_username"));
                user.setPassword(rs.getString("user_password"));
                user.setPhone(rs.getString("user_phone"));
                user.setEmail(rs.getString("user_email"));
                user.setIsFaceRecognized(rs.getBoolean("user_facerecognize"));
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static User getUserByUsername(String username){
        User user = null;
        String querry = "SELECT * FROM users WHERE user_username = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setString(1, username);
            
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserRole(rs.getString("user_role"));
                user.setFirstName(rs.getString("user_firstname"));
                user.setMidName(rs.getString("user_midname"));
                user.setLastName(rs.getString("user_lastname"));
                user.setUsername(rs.getString("user_username"));
                user.setPassword(rs.getString("user_password"));
                user.setPhone(rs.getString("user_phone"));
                user.setEmail(rs.getString("user_email"));
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
     
     public static User getUserByUsernamePassword(String username, String password){
         User user = null;
        String querry = "SELECT * FROM users WHERE user_username = ? AND user_password = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserRole(rs.getString("user_role"));
                user.setFirstName(rs.getString("user_firstname"));
                user.setMidName(rs.getString("user_midname"));
                user.setLastName(rs.getString("user_lastname"));
                user.setUsername(rs.getString("user_username"));
                user.setPassword(rs.getString("user_password"));
                user.setPhone(rs.getString("user_phone"));
                user.setEmail(rs.getString("user_email"));
                user.setIsFaceRecognized(rs.getBoolean("user_facerecognize"));
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
     
      public static int getNewUserId(){
        int newId = 0; 
        String querry = "SELECT * FROM users ORDER BY user_id DESC LIMIT 1";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            ResultSet rs = prepareStatement.executeQuery();
            
            if(rs.next()){
                newId = rs.getInt("user_id");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ++newId;
    }
      
       public static List<User> getStudentByCourseId(String courseId){
        List<User> users = new ArrayList<>();

        String querry = "SELECT users.* FROM users JOIN (SELECT student_id FROM courses_student WHERE course_id = ?)  AS result ON users.user_id = result.student_id;";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            prepareStatement.setString(1, courseId);
            
            ResultSet rs = prepareStatement.executeQuery();
            
                
            while(rs.next()){
                User user = new User();
                user.setUserId(    rs.getInt("user_id"));
                user.setFirstName(rs.getString("user_firstname"));
                user.setMidName(rs.getString("user_midname"));
                user.setLastName(rs.getString("user_lastname"));
                user.setPhone(rs.getString("user_phone"));
                user.setEmail(rs.getString("user_email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
      
     

}
