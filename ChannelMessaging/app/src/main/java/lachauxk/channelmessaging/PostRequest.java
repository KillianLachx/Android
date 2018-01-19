package lachauxk.channelmessaging;

import java.util.HashMap;

/**
 * Created by lachauxk on 19/01/2018.
 */

public class PostRequest {
    String url ="";
    HashMap<String, String> postParams;

    public PostRequest(String _url, String _postParams)
    {
        url = _url;


    }
}