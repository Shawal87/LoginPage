import java.util.HashMap;

public class IdAndPassw {


    HashMap<String,String> logininfo = new HashMap<String,String>();

    IdAndPassw () {
        logininfo.put("bRo","123");
        logininfo.put("wal","456abc");
        logininfo.put("tee","abc123");

    }
      // method to login and retrieve
      protected HashMap getlogininfo() {
        return logininfo;
      }
}
