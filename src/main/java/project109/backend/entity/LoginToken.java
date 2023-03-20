package project109.backend.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import project109.backend.util.Common;

@Component
public class LoginToken {
    private String loginToken="";// = Common.CreateRandomId(16);
    private String loginId="";
    private String studentId="";
    private String timestamp= "";

    public LoginToken() {
    }

    //從資料庫接值
    public LoginToken(String loginToken, String loginId, String studentId, String timestamp) {
        this.loginToken = loginToken;
        this.loginId = loginId;
        this.studentId = studentId;
        this.timestamp = timestamp;
    }
    
    //建立新的token
    public LoginToken(String loginToken, String loginId, String studentId) {
        this.loginToken = loginToken;
        this.loginId = loginId;
        this.studentId = studentId;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    }

    //從client接值用DTO
    @JsonCreator
    public LoginToken(@JsonProperty("loginToken") String loginToken, @JsonProperty("loginId") String loginId){
        this.loginToken = loginToken;
        this.loginId = loginId;
    }

    public String getLoginToken() {
        return this.loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    // public void setTimestamp(String timestamp) {
    //     this.timestamp = timestamp;
    // }


    @Override
    public int hashCode() {
        return Objects.hash(loginToken, loginId, studentId, timestamp);
    }

    @Override
    public String toString() {
        return "{" +
            " loginToken='" + getLoginToken() + "'" +
            ", loginId='" + getLoginId() + "'" +
            ", studentId='" + getStudentId() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }
}
