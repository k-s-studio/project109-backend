package project109.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginDTO {
    @Schema(description = "學號")
    private String studentId="";
    @Schema(description = "密碼")
    private String password="";

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
