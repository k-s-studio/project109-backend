package project109.backend.dto;

public class LoginDTO {
    private String studentId;
    private String password;

    public String getStudentId() {
        return studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setStudentId(String str){
        this.studentId=str;
    }

    public void setPassword(String str){
        this.password=str;
    }
}
