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
public class Course_Model {
    
    public static boolean insertCourse(Course course){
        String querry = "INSERT INTO courses (course_id,course_name,course_credits,course_maxStudents,course_location) VALUES (?,?,?,?,?)";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            prepareStatement.setString(1, course.getCourseId());
            prepareStatement.setString(2, course.getCourseName());
            prepareStatement.setInt(3, course.getCourseCredits());
            prepareStatement.setInt(4, course.getMaxStudentsRegister());
            prepareStatement.setString(5, course.getCourseLocation());
            
            return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteCourse(String courseId){
        String querry = "DELETE FROM courses WHERE course_id = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            prepareStatement.setString(1, courseId);
            
            return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateCourse(Course course){
        String querry = "UPDATE courses SET course_name = ?, course_credits = ?, course_maxStudents = ?, course_location = ? WHERE course_id = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            prepareStatement.setString(1, course.getCourseName());
            prepareStatement.setInt(2, course.getCourseCredits());
            prepareStatement.setInt(3, course.getMaxStudentsRegister());
            prepareStatement.setString(4, course.getCourseLocation());
            prepareStatement.setString(5, course.getCourseId());
            
            return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Course getCourseById(String courseId){
        Course course = null;
        String querry = "SELECT * FROM courses WHERE course_id = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            prepareStatement.setString(1, courseId);
            
            ResultSet rs = prepareStatement.executeQuery();
            
            
                
            if(rs.next()){
                course = new Course();
                course.setCourseId(    rs.getString("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseCredits( rs.getInt("course_credits"));
                course.setCourseLocation( rs.getString("course_location"));
                course.setMaxStudentsRegister( rs.getInt("course_maxStudents"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
    
     public static List<Course> getAllCourses(String courseId){
        List<Course> courses = new ArrayList<>();

        String querry = "SELECT * FROM courses WHERE course_id LIKE ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           prepareStatement.setString(1, "%"+courseId+"%");
            ResultSet rs = prepareStatement.executeQuery();
            
                
            while(rs.next()){
                Course course = new Course();
                course.setCourseId(    rs.getString("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseCredits( rs.getInt("course_credits"));
                course.setCourseLocation( rs.getString("course_location"));
                course.setMaxStudentsRegister( rs.getInt("course_maxStudents"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
     
     public static List<Course> getAllFacultyCourses(){
        List<Course> courses = new ArrayList<>();

        String querry = "SELECT * FROM courses_faculty";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
            ResultSet rs = prepareStatement.executeQuery();
            
                
            while(rs.next()){
                Course course = new Course();
                course.setCourseId(    rs.getString("course_id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    
    public static List<Course> getCoursesByUserId(int userId, String userRole, String courseId){
        List<Course> courses = new ArrayList<>();

        String querry = "SELECT courses.* FROM courses JOIN (SELECT course_id FROM courses_"+userRole+" WHERE "+userRole+"_id = ?)  AS result ON courses.course_id = result.course_id WHERE courses.course_id LIKE ?;";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            prepareStatement.setInt(1, userId);
            prepareStatement.setString(2, "%"+courseId+"%");
            
            ResultSet rs = prepareStatement.executeQuery();
            
                
            while(rs.next()){
                Course course = new Course();
                course.setCourseId(    rs.getString("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseCredits( rs.getInt("course_credits"));
                course.setCourseLocation( rs.getString("course_location"));
                course.setMaxStudentsRegister( rs.getInt("course_maxStudents"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    public static List<Course> getCoursesAsStatus(boolean isFull, String userRole){
        List<Course> courses = new ArrayList<>();

        // Select all courses that have teacher and currStudent < maxStudent
        String querry = "SELECT courses.*, result.currentStudents FROM courses JOIN ( SELECT courses_faculty.course_id, COUNT(courses_student.student_id) AS currentStudents FROM courses_faculty LEFT JOIN courses_student ON courses_faculty.course_id = courses_student.course_id GROUP BY courses_faculty.course_id ) AS result ON courses.course_id = result.course_id WHERE result.currentStudents < courses.course_maxStudents;";
        
        // Select all course that have full student
        if(isFull)
                querry = "SELECT courses.*, currentStudents FROM courses JOIN (SELECT course_id ,COUNT(courses_student.student_id) AS currentStudents FROM courses_student GROUP BY course_id )  AS result ON courses.course_id = result.course_id WHERE result.currentStudents = courses.course_maxStudents;";
        
        // Select all course that not have teacher teaching
        if("faculty".equals(userRole))
                querry = "SELECT courses.* FROM courses LEFT JOIN courses_faculty ON courses.course_id = courses_faculty.course_id WHERE courses_faculty.course_id IS NULL;";
            
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            ResultSet rs = prepareStatement.executeQuery();
            
                
            while(rs.next()){
                Course course = new Course();
                course.setCourseId(    rs.getString("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseCredits( rs.getInt("course_credits"));
                course.setCourseLocation( rs.getString("course_location"));
                course.setMaxStudentsRegister( rs.getInt("course_maxStudents"));
                if(!"faculty".equals(userRole))
                course.setCurrentStudentsRegister(rs.getInt("currentStudents"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    public static boolean addUserToCourse(int userId, String userRole ,String courseId) {

        String querry = "INSERT INTO courses_"+userRole+" VALUES (?,?);";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            prepareStatement.setString(1, courseId);
            prepareStatement.setInt(2, userId);
            
             return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteUserFromCourse(int userId, String userRole ,String courseId) {

        String querry = "DELETE FROM courses_"+userRole+" WHERE course_id = ? AND "+userRole+"_id = ?;";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(querry);) 
        {
           
            prepareStatement.setString(1, courseId);
            prepareStatement.setInt(2, userId);
            
             return prepareStatement.executeUpdate()>=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
