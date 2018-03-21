package lachauxk.channelmessaging;

/**
 * Created by lachauxk on 07/03/2018.
 */
public class Channel {
    private int channelID;
    private String name;
    private int connectedusers;

    public Channel(){

    }

    public String ToString(){
        return "Channel : "+ channelID+"\n" + "Connected users :"+ connectedusers + "\n";
    }
}
