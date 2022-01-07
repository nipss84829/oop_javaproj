import java.io.File;
import java.util.Scanner;

public class Auth{
    private String f_acc,f_pw,f_vs;
    Config config;

    public void load(){
        readuser();
        readverify();
    }

    private void readverify(){
        config = new Config();
        f_vs = config.getvalue("verify_string");
    }

    public void calllogin(){
        String acc,pw,vs;
        int i=0;
        while(true){
            System.out.println("Account:");
            acc = Main.scn.nextLine();
            System.out.println("Password:");
            pw = Main.scn.nextLine();
            System.out.println("Verify_string:"+f_vs);
            System.out.println("Input_Verify_string:");
            vs = Main.scn.nextLine();
            if(login(acc, pw, vs)){
                System.out.println("Login_success");
                break;
            }
            else{
                System.out.println("Error_wrong_account_password_or_verify_string");
                i++;
            }
            if(i==3){
                System.exit(0);
            }
        }
    }
    public boolean login(String acc,String pw,String vs){
        if(acc.equals(f_acc)&&pw.equals(f_pw)&&vs.equals(f_vs)){
            return true;
        }
        return false;
    }
    public void readuser(){
        try {
            Scanner rfile = new Scanner(new File("account.txt"));
            while(rfile.hasNextLine()){
                String st[] = rfile.nextLine().split(" ");
                f_acc = st[0];
                f_pw = st[1];
            }
            rfile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}