package project109.backend.entity;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String loginId=null;//= Common.CreateRandomId(32);
    private String studentId;
    private String password=null;
    private String email="";
    private String name;
    private int level=1;
    private int point=0;
    private int currency=0;

    public User() {
    }

    //用於初始化測試資料，所有欄位都要有
    public User(String loginId, String studentId, String password, String email, String name, int level, int point, int currency) {
        this.loginId = loginId;
        this.studentId = studentId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.level = level;
        this.point = point;
        this.currency = currency;
    }
    //用於傳送用戶取得的資料，密碼不傳、logonId已經有了
    public User(String studentId, String email, String name, int level, int point, int currency) {
        this.studentId = studentId;
        this.email = email;
        this.name = name;
        this.level = level;
        this.point = point;
        this.currency = currency;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCurrency() {
        return this.currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(loginId, user.loginId) && Objects.equals(studentId, user.studentId) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && level == user.level && point == user.point && currency == user.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, studentId, password, email, name, level, point, currency);
    }

    @Override
    public String toString() {
        return "{" +
            " loginId='" + getLoginId() + "'" +
            ", studentId='" + getStudentId() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", name='" + getName() + "'" +
            ", level='" + getLevel() + "'" +
            ", point='" + getPoint() + "'" +
            ", currency='" + getCurrency() + "'" +
            "}";
    }

}
