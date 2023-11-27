package Models;

public class User {
    private int userId;
    private String userRole;
    private String username;
    private String password;
    private String firstName;
    private String midName;
    private String lastName;
    private String email;
    private String phone;
    private boolean isFaceRecognized;

    public User() {
        this.isFaceRecognized = false;
    }

    public User(String username, String password, String firstName, String midName, String lastName) {
        this.username = username.trim();
        this.password = password.trim();
        this.firstName = firstName.trim();
        this.midName = midName.trim();
        this.lastName = lastName.trim();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole.toUpperCase();
    }
    
    

    public String getUserRole() {
        return userRole.toLowerCase();
    }
    
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getMidName() {
        return midName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public String getName() {
        return firstName+" "+midName+" "+lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIsFaceRecognized() {
        return isFaceRecognized;
    }

    public void setIsFaceRecognized(boolean isFaceRecognized) {
        this.isFaceRecognized = isFaceRecognized;
    }
    
    
    
    public Object[] toObject(int indx){
        return new Object[]{indx,userId,firstName,midName,lastName,phone,email};
    }
    
}
