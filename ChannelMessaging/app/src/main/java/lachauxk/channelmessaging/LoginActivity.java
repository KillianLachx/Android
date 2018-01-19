package lachauxk.channelmessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubmit;
    private EditText edxLogin;
    private EditText edxPassword;

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
        infosConnexion.put("","");
        HttpPostHandler httpPostHandler = new HttpPostHandler();
        httpPostHandler.addOnDownloadListener(this);
        httpPostHandler.execute(new PostRequest());
    }
}
