package lachauxk.channelmessaging;

/**
 * Created by lachauxk on 29/01/2018.
 */
public class UserDatas {
    private String accesstoken;

    public UserDatas(){
    }

    public void setToken(String _accesstoken){
        accesstoken = _accesstoken;
    }

    public String getToken(){
        return accesstoken;
    }

}
