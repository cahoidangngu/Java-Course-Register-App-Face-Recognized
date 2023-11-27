/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Course;
import Models.Course_Model;
import Models.User;
import Models.User_Model;
import Views.AdminView.*;
import Views.CourseView.CourseEditInformationView;
import Views.FacultyView.FacultyMenuView;
import Views.StudentView.StudentMenuView;
import Views.View;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Quan's PC
 */
public class Controller {
    
    private static User user;
    

    public static User getUser() {
        return user;
    }
    
    public static void userLoginByIdController(int userId, JFrame jFrame)
    {
        try {
            user = User_Model.getUserById(userId);
            if (user == null) {
                System.out.println("Cannot Find User");
                throw new AppException("Wrong user name or password");
            }
            jFrame.dispose();
            String userRole = getUser().getUserRole();

            if ("admin".equals(userRole)) {
                new AdminMenuView().setVisible(true);
            } else if ("faculty".equals(userRole)) {
                new FacultyMenuView().setVisible(true);
            } else {
                new StudentMenuView().setVisible(true);
            }
        } catch (AppException e) {
            JOptionPane.showMessageDialog(jFrame, e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void userLoginController(String username, String password, JFrame jFrame)
    {
        try {
            user = User_Model.getUserByUsernamePassword(username, password);
            if (user == null) {
                System.out.println("Cannot Find User");
                throw new AppException("Wrong user name or password");
            }
            jFrame.dispose();
            String userRole = getUser().getUserRole();

            if ("admin".equals(userRole)) {
                new AdminMenuView().setVisible(true);
            } else if ("faculty".equals(userRole)) {
                new FacultyMenuView().setVisible(true);
            } else {
                new StudentMenuView().setVisible(true);
            }
        } catch (AppException e) {
            JOptionPane.showMessageDialog(jFrame, e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void userEditController(User newUser, JFrame jFrame){
        try {
            if (InputValidate.IsBlank(newUser.getUsername())) {
                System.out.println("Username is blank");
                throw new AppException("Username cannot be blank");
            } else if (InputValidate.IsBlank(newUser.getPassword())) {
                System.out.println("Password is blank");
                throw new AppException("Password cannot be blank");
            } else if (InputValidate.IsBlank(newUser.getPhone()) || !InputValidate.IsPhoneNumber(newUser.getPhone())) {
                System.out.println("Phone wrong format");
                throw new AppException("Phone not valid");
            } else if (InputValidate.IsBlank(newUser.getEmail()) || !InputValidate.IsEmail(newUser.getEmail())) {
                System.out.println("Email wrong format");
                throw new AppException("Email not valid");
            }

            User checkUser = User_Model.getUserByUsername(newUser.getUsername());

            if (checkUser != null && checkUser.getUserId() != newUser.getUserId()) {
                System.out.println("Username is existed");
                throw new AppException("Username has already existed");
            }

            if (User_Model.updateUser(newUser)) {

                String userRole = getUser().getUserRole();
                JOptionPane.showMessageDialog(jFrame, "Successfully update user information");
                jFrame.dispose();

                Controller.user = newUser;

                System.out.println(userRole + " has been updated");

                if ("admin".equals(userRole)) {
                    new AdminMenuView().setVisible(true);
                } else if ("faculty".equals(userRole)) {
                    new FacultyMenuView().setVisible(true);
                } else {
                    new StudentMenuView().setVisible(true);
                }
            } else {
                System.out.println("Failed to update" + newUser.getUserRole() + "information");
                throw new AppException("Failed update user information");
            }

        } catch (AppException e) {
            JOptionPane.showMessageDialog(jFrame, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void courseCreateController(Course newCourse, AdminManipulateCourseView jFrame){
        try {
            
            if (InputValidate.IsBlank(newCourse.getCourseId())) {
                System.out.println("Course's id is blank");
                throw new AppException("Course's id cannot be blank");
            } else if (InputValidate.IsBlank(newCourse.getCourseName())) {
                System.out.println("Course's name is blank");
                throw new AppException("Course's name cannot be blank");
            } else if (!InputValidate.IsNumberFormat(newCourse.getCourseCredits()+"")) {
                System.out.println("Course's credits is not number");
                throw new AppException("Course's credits must be number");
            } else if (!InputValidate.IsNumberFormat(newCourse.getMaxStudentsRegister()+"")) {
                System.out.println("Course's maxStudentRegister is not number");
                throw new AppException("Course's max student register must be number");
            } else if (InputValidate.IsBlank(newCourse.getCourseLocation())) {
                System.out.println("Course's location is blank");
                throw new AppException("Course's location cannot be blank");
            }
             
            if(Course_Model.getCourseById(newCourse.getCourseId())!=null){
                System.out.println("Course's id is existed");
                throw new AppException("Course's id has already existed");
            }
            
            if (Course_Model.insertCourse(newCourse)) {
                jFrame.emptyAllField();
                jFrame.renderTable(Course_Model.getAllCourses(""));
                System.out.println("New course has been added");
                JOptionPane.showMessageDialog(jFrame, "New course has been added");
            } else {
                System.out.println("Failed to add new course");
                throw new AppException("Failed to add new course");
            }

        } catch (AppException e) {
            JOptionPane.showMessageDialog(jFrame, e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
     public static void courseEditFindIdController(String courseId, JFrame jFrame){
         try {
             if(InputValidate.IsBlank(courseId)){
                 System.out.println("Course's id is blank");
                 throw new AppException("Enter course's id");
             }

             Course course = Course_Model.getCourseById(courseId.trim());
             if (course == null) {
                 System.out.println("No course found");
                 throw new AppException("No course found");
             }
             
             jFrame.dispose();
             new CourseEditInformationView(course).setVisible(true);
             
         } catch (AppException e) {
             JOptionPane.showMessageDialog(jFrame, e.getMessage());
         } catch (Exception e){
             e.printStackTrace();
         }
    }
     
     public static void courseEditController(Course newCourse, JFrame jFrame){
         try {
             if (!InputValidate.IsNumberFormat(newCourse.getCourseCredits() + "")) {
                 System.out.println("Course's credits is not number");
                 throw new AppException("Course's credits must be number");
             } else if (!InputValidate.IsNumberFormat(newCourse.getMaxStudentsRegister() + "")) {
                 System.out.println("Course's maxStudentRegister is not number");
                 throw new AppException("Course's max student register must be number");
             } else if (InputValidate.IsBlank(newCourse.getCourseLocation())) {
                 System.out.println("Course's location is blank");
                 throw new AppException("Course's location cannot be blank");
             }

             if (Course_Model.updateCourse(newCourse)) {
                 System.out.println("Course success update");
                 JOptionPane.showMessageDialog(jFrame,"Success to update course");
                 jFrame.dispose();
                new AdminManipulateCourseView().setVisible(true);
             } else {
                 System.out.println("Course failed to update");
                 throw new AppException("Failed to update course");
             }
         } catch (AppException e) {
             JOptionPane.showMessageDialog(jFrame, e.getMessage());
         } catch (Exception e) {

         }
     }
     
     public static void courseDeleteController(String courseId, AdminManipulateCourseView jFrame){
         try {
            if (InputValidate.IsBlank(courseId)) {
                System.out.println("Course's id is blank");
                throw new AppException("Enter course's id");
            }

            Course course = Course_Model.getCourseById(courseId.trim());
            if (course == null) {
                System.out.println("No course found");
                throw new AppException("No course found");
            }

            if (Course_Model.deleteCourse(courseId)) {
                System.out.println("Course success delete");
                JOptionPane.showMessageDialog(jFrame, "Success delete course");
            } else {
                System.out.println("Course failed to delete");
                throw new AppException("Failed to delete course");
            }
            jFrame.renderTable(Course_Model.getAllCourses(""));

        } catch (AppException e) {
            JOptionPane.showMessageDialog(jFrame, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void userRegisterFacultyController(User newFaculty, JFrame jFrame) {
        try {

            if (InputValidate.IsBlank(newFaculty.getFirstName())) {
                System.out.println("First name is blank");
                throw new AppException("First name cannot be blank");
            } else if (InputValidate.IsBlank(newFaculty.getLastName())) {
                System.out.println("Last name is blank");
                throw new AppException("Last name cannot be blank");
            } else if (InputValidate.IsBlank(newFaculty.getUsername())) {
                System.out.println("Username is blank");
                throw new AppException("Username cannot be blank");
            } else if (InputValidate.IsBlank(newFaculty.getPassword())) {
                System.out.println("Password is blank");
                throw new AppException("Password cannot be blank");
            } else if (InputValidate.IsBlank(newFaculty.getPhone()) || !InputValidate.IsPhoneNumber(newFaculty.getPhone())) {
                System.out.println("Phone wrong format");
                throw new AppException("Phone not valid");
            } else if (InputValidate.IsBlank(newFaculty.getEmail()) || !InputValidate.IsEmail(newFaculty.getEmail())) {
                System.out.println("Email wrong format");
                throw new AppException("Email not valid");
            }

            User checkUser = User_Model.getUserByUsername(newFaculty.getUsername());

            if (checkUser != null && checkUser.getUserId() != newFaculty.getUserId()) {
                System.out.println("Username is existed");
                throw new AppException("Username has already existed");
            }

            if (User_Model.insertUser(newFaculty)) {
                System.out.println("Successfully register faculty");
                JOptionPane.showMessageDialog(jFrame, "Success register new faculty");
                jFrame.dispose();
                new AdminMenuView().setVisible(true);
            } else {
                System.out.println("Failed register faculty");
                throw new AppException("Failed to register faculty");
            }

        } catch (AppException e) {
            JOptionPane.showMessageDialog(jFrame, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public static void userRegisterStudentController(User newStudent, JFrame jFrame){
          try {

            if (InputValidate.IsBlank(newStudent.getFirstName())) {
                System.out.println("First name is blank");
                throw new AppException("First name cannot be blank");
            } else if (InputValidate.IsBlank(newStudent.getLastName())) {
                System.out.println("Last name is blank");
                throw new AppException("Last name cannot be blank");
            } else if (InputValidate.IsBlank(newStudent.getUsername())) {
                System.out.println("Username is blank");
                throw new AppException("Username cannot be blank");
            } else if (InputValidate.IsBlank(newStudent.getPassword())) {
                System.out.println("Password is blank");
                throw new AppException("Password cannot be blank");
            } else if (InputValidate.IsBlank(newStudent.getPhone()) || !InputValidate.IsPhoneNumber(newStudent.getPhone())) {
                System.out.println("Phone wrong format");
                throw new AppException("Phone not valid");
            } else if (InputValidate.IsBlank(newStudent.getEmail()) || !InputValidate.IsEmail(newStudent.getEmail())) {
                System.out.println("Email wrong format");
                throw new AppException("Email not valid");
            }

            User checkUser = User_Model.getUserByUsername(newStudent.getUsername());

            if (checkUser != null && checkUser.getUserId() != newStudent.getUserId()) {
                System.out.println("Username is existed");
                throw new AppException("Username has already existed");
            }

            if (User_Model.insertUser(newStudent)) {
                System.out.println("Successfully register student");
                JOptionPane.showMessageDialog(jFrame, "Success register new student");
                jFrame.dispose();
                new AdminMenuView().setVisible(true);
            } else {
                System.out.println("Failed register student");
                throw new AppException("Failed to register student");
            }

        } catch (AppException e) {
            JOptionPane.showMessageDialog(jFrame, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
       public static void userViewCourseByIdController(String courseId, boolean status, View jFrame){
         // Course that see by student and faculty
         List<Course> courses = Course_Model.getCoursesAsStatus(status, getUser().getUserRole());
         courses = courses.stream().filter(course -> course.getCourseId().contains(courseId)).toList();
         
        if("admin".equals(getUser().getUserRole())&& !status)
            // Course that see bt Admin
            courses = Course_Model.getAllCourses(courseId.trim());
         
         jFrame.renderTable(courses);
     }
     
     public static void userViewRegisterCourseController(String userId ,String userRole, String courseId, View tableView, JFrame jFrame){
         try {

             if (InputValidate.IsBlank(userId)) {
                 System.out.println("User id is blank");
                 throw new AppException("Enter student id");
             }

             if (User_Model.getUserById(Integer.parseInt(userId.trim())) == null) {
                 System.out.println("No user found");
                 throw new AppException("No user found");
             }

             tableView.renderTable(Course_Model.getCoursesByUserId(Integer.parseInt(userId.trim()), userRole, courseId));
         } catch (AppException e) {
             JOptionPane.showMessageDialog(jFrame, e.getMessage());
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
     
     public static void viewRegisterUserByCourseIdController(String courseId, View viewTable, JFrame jFrame){
         try {
             if (InputValidate.IsBlank(courseId)) {
                 System.out.println("Course's id is blank");
                 throw new AppException("Enter course's id");
             }

             if (Course_Model.getCourseById(courseId.trim()) == null) {
                 System.out.println("No course found");
                 throw new AppException("No course found");
             }

             viewTable.renderTable(User_Model.getStudentByCourseId(courseId));
         } catch (AppException e) {
             JOptionPane.showMessageDialog(jFrame, e.getMessage());
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     public static void userRegisterByCourseIdController(String courseId, JFrame jFrame){
         try {
             if (InputValidate.IsBlank(courseId)) {
                 System.out.println("Course's id is blank");
                 throw new AppException("Enter course id");
             }
             
             if (Course_Model.getCourseById(courseId)==null) {
                 System.out.println("Course's not found");
                 throw new AppException("Course not found or has not been registered");
             }

             List<Course> listCourse = Course_Model.getCoursesByUserId(getUser().getUserId(), getUser().getUserRole(), courseId);
             if (!listCourse.isEmpty()) {
                 System.out.println(getUser().getUserRole() + " has already registered this course!");
                 throw new AppException("User has already registered this course");
             }

             if (Course_Model.addUserToCourse(getUser().getUserId(), getUser().getUserRole(), courseId)) {
                 System.out.println("Successfull register " + getUser().getUserRole()+"to course");
                 JOptionPane.showMessageDialog(jFrame, "Successfull register course");
             } else {
                 System.out.println("Failed to register " + getUser().getUserRole()+"to course");
                 JOptionPane.showMessageDialog(jFrame, "Failed to register course");

             }
         } catch (AppException e) {
             JOptionPane.showMessageDialog(jFrame, e.getMessage());
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     public static void userWithdrawByCourseIdController(String courseId, JFrame jFrame){
         try {
             if (InputValidate.IsBlank(courseId)) {
                 System.out.println("Course's id is blank");
                 throw new AppException("Enter course id");
             }
             
             if (Course_Model.getCourseById(courseId)==null) {
                 System.out.println("Course's not found");
                 throw new AppException("Course not found or has not been registered");
             }

             List<Course> listCourse = Course_Model.getCoursesByUserId(getUser().getUserId(), getUser().getUserRole(), courseId);
             if (listCourse.isEmpty()) {
                 System.out.println(getUser().getUserRole() + " has not registered this course!");
                 throw new AppException("User has not registered this course");
             }

             if (Course_Model.deleteUserFromCourse(getUser().getUserId(), getUser().getUserRole(), courseId)) {
                 System.out.println("Successfull withdraw " + getUser().getUserRole()+"from course");
                 JOptionPane.showMessageDialog(jFrame, "Successfull withdraw from course");
             } else {
                 System.out.println("Failed to withdraw " + getUser().getUserRole() +"from course");
                 JOptionPane.showMessageDialog(jFrame, "Failed to withdraw from course");

             }
         } catch (AppException e) {
             JOptionPane.showMessageDialog(jFrame, e.getMessage());
         } catch (Exception e) {
             e.printStackTrace();
         }
         
     }
     
     
    
    
    
}
