package Models;


public class Course {
    private String courseId;
    private String courseName;
    private int maxStudentsRegister;
    private int currentStudentsRegister;
    private int courseCredits;
    private String courseLocation;

    public Course() {
    }
    
    public Course(String courseId, String courseName, int courseCredits, String courseLocation, int maxStudentsRegister) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maxStudentsRegister = maxStudentsRegister;
        this.courseCredits = courseCredits;
        this.courseLocation = courseLocation;
    }

    

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxStudentsRegister() {
        return maxStudentsRegister;
    }

    public void setMaxStudentsRegister(int maxStudentsRegister) {
        this.maxStudentsRegister = maxStudentsRegister;
    }

    public int getCurrentStudentsRegister() {
        return currentStudentsRegister;
    }

    public void setCurrentStudentsRegister(int currentStudentsRegister) {
        this.currentStudentsRegister = currentStudentsRegister;
    }
    
    


    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }


    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }
    
    public Object[] toObject(int indx){
        return new Object[] {indx,courseId, courseName, courseCredits,maxStudentsRegister, courseLocation};
    }

}
