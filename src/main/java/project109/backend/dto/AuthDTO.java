package project109.backend.dto;


//所有與讀取、修改、刪除擁護資料相關的都要POST夾著AuthDTO一起送
public class AuthDTO {
    private String loginToken;
    private String loginId;

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
}
