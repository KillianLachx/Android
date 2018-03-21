package lachauxk.channelmessaging;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lachauxk on 07/03/2018.
 */
public class Channels {
    private Channel[] channels;

    public Channels(){

    }

    public Channel[] getChannels(){
        return channels;
    }

    public String ToString(){
        String rtnStr ="";

        for ( Channel chan : channels ){
            rtnStr+= chan.ToString();
        }
        return rtnStr;
    }

    public ArrayList<String> ToArrayString(){
        ArrayList<String> reditus = new ArrayList<String>();

        for ( Channel chan : channels ){
            reditus.add(chan.ToString());
        }

        return reditus;
    }
}
