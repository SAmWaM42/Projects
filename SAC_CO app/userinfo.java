import java.util.HashMap;

public class userinfo {

  private  HashMap<String,String>login_info= new HashMap <String,String>();

  public userinfo()
  {
    login_info.put("sam","256");
  }
protected HashMap<String,String> getLogin_info()
{
    return login_info;
}
    
}
