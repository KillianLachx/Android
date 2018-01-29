package lachauxk.channelmessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnDownloadListener {

    private Button btnSubmit;
    private EditText edxLogin;
    private EditText edxPassword;
    private ConnectResponse logAns = new ConnectResponse();
    private Gson gson = new Gson();
    private UserDatas currentUser = new UserDatas();

    private String stLogin;
    private String stPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        edxLogin = (EditText) findViewById(R.id.edxLogin);
        edxPassword = (EditText) findViewById(R.id.edxPassword);

        stLogin = edxLogin.getText().toString();
        stPassword = edxPassword.getText().toString();

        btnSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        HashMap<String, String> infosConnexion = new HashMap<String, String>();
        //infosConnexion.put("{\"username\":"+"\""+stLogin+"\"","password\":"+"\""+stPassword+"\"}");
        infosConnexion.put("username", edxLogin.getText().toString());
        infosConnexion.put("password", edxPassword.getText().toString());
        HttpPostHandler httpPostHandler = new HttpPostHandler();
        httpPostHandler.addOnDownloadListener(this);
        httpPostHandler.execute(new PostRequest("http://raphaelbischof.fr/messaging/?function=connect",infosConnexion));
    }

    @Override
    public void OnDownloadComplete(String downloadedContent) {
        logAns = gson.fromJson(downloadedContent, ConnectResponse.class);
        currentUser.setToken(logAns.getToken());

        Toast.makeText(getApplicationContext(), currentUser.getToken(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDownloadError(String downloadedContent) {

    }
}
