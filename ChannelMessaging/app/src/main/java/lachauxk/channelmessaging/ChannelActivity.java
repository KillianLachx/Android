package lachauxk.channelmessaging;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class ChannelActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener, OnDownloadListener {

    private ListView lstChan;
    private String accessToken;
    private Gson gson = new Gson();

    private Channels channels;


    private ArrayAdapter<String> adapter;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        lstChan = (ListView) findViewById(R.id.lstChan);


        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        accessToken = prefs.getString("channelmessaging_accesstoken", null);

        HashMap<String, String> authDatas = new HashMap<String, String>();
        authDatas.put("accesstoken", accessToken);
        HttpPostHandler httpPostHandler = new HttpPostHandler();
        httpPostHandler.addOnDownloadListener(this);
        httpPostHandler.execute(new PostRequest("http://raphaelbischof.fr/messaging/?function=getchannels", authDatas));


    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void OnDownloadComplete(String downloadedContent) {
        //Toast.makeText(getApplicationContext(), downloadedContent, Toast.LENGTH_SHORT).show();
        //final ArrayAdapter<String> ido = new ArrayAdapter<>(ChannelActivity.this, android.R.layout.simple_expandable_list_item_1, channels);



        Channels channels = gson.fromJson(downloadedContent, Channels.class);
        ArrayList<String> stringedChans = channels.ToArrayString();

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stringedChans);
        lstChan.setAdapter(adapter);

        lstChan.setOnItemClickListener(this);





        /*
        for (Channel chan : channels.getChannels()){
            Toast.makeText(getApplicationContext(), chan.ToString(), Toast.LENGTH_SHORT).show();

            //lstChan.
        }*/
    }

    @Override
    public void onDownloadError(String downloadedContent) {

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(getApplicationContext(), "Get Clicked.", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(this, ChannelActivity.class);
            editor.putString("channelmessaging_accesstoken", logAns.getToken());
            editor.apply();
            Toast.makeText(getApplicationContext(), currentUser.getToken(), Toast.LENGTH_SHORT).show();
            startActivity(intent);

    }
}
