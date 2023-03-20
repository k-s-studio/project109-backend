package project109.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import project109.backend.entity.LoginToken;
import project109.backend.entity.User;
import project109.backend.util.Common;

@Service
public class UserService {

    private List<User> db_user = new ArrayList<User>();
    private List<LoginToken> db_logintoken = new ArrayList<LoginToken>(); 
    
    public UserService(){
        db_user.add(new User(Common.CreateRandomId(32),"409402491","409402491","409402491@gapp.fjcu.edu.tw","林裕全欠",45,4500,4500));
        db_user.add(new User(Common.CreateRandomId(32),"409402374","409402374","409402374@gapp.fjcu.edu.tw","徐土維",45,4500,4500));
        db_user.add(new User(Common.CreateRandomId(32),"409040334","409040334","409040334@gapp.fjcu.edu.tw","林詩旋",45,4500,4500));
        db_user.add(new User(Common.CreateRandomId(32),"409401368","409401368","409401368@gapp.fjcu.edu.tw","徐涵萓",45,4500,4500));
        db_user.add(new User(Common.CreateRandomId(32),"409290408","409290408","409290408@gapp.fjcu.edu.tw","張塏蓉",45,4500,4500));
    }

    public User getUserData(LoginToken t) throws Exception{
        if(validLogin(t)){
            for(User u : db_user){
                if(u.getLoginId().equals(t.getLoginId())) 
                return new User(u.getLoginId(),u.getStudentId(),u.getEmail(),u.getName(),u.getLevel(),u.getPoint(),u.getCurrency());
            }
            throw new Exception("user not found");
        }else throw new Exception("unauthorized");
    }

    public LoginToken loginCheck(String studentId, String password) throws Exception{
        for(User u: db_user){
            if(u.getStudentId().equals(studentId)){
                if(u.getPassword().equals(password)){
                    LoginToken newLoginToken= new LoginToken(Common.CreateRandomId(16),u.getLoginId(),studentId);
                    db_logintoken.add(newLoginToken);
                    return newLoginToken;
                }else throw new Exception("wrong password."); 
            }
        }
        throw new Exception("student not found.");
    }

    public boolean validLogin(LoginToken token){
        for(LoginToken t : db_logintoken){
            if(t.getLoginToken().equals(token.getLoginToken())&&t.getLoginId().equals(token.getLoginId())) return true;
        }
        return false;
    }

    public boolean validLogin(String loginId, String loginToken){
        for(LoginToken t : db_logintoken){
            if(t.getLoginToken().equals(loginToken)&&t.getLoginId().equals(loginId)) return true;
        }
        return false;
    }
}
