public class main_app 
{

    public static void main(String[] args)
    {
        userinfo info=new userinfo();
        
        login_screen login=new login_screen(info.getLogin_info());
        
        
    }

    
}
