import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class auth{
    private static String f_acc,f_pw,f_vs;
    private static Scanner rfile;
    public static void load(){
        readuser();
        readverifyString();
    }
    public static void calllogin(){
        String acc,pw,vs;
        int i=0;
        while(true){
            System.out.println("Account:");
            acc = Main.scn.nextLine();
            System.out.println("Password:");
            pw = Main.scn.nextLine();
            System.out.println("Verify_string:12345");
            System.out.println("Input_Verify_string:");
            vs = Main.scn.nextLine();
            if(auth.login(acc, pw, vs)){
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
    public static boolean login(String acc,String pw,String vs){
        if(acc.equals(f_acc)&&pw.equals(f_pw)&&vs.equals(f_vs)){
            return true;
        }
        return false;
    }
    private static void readuser(){
        try {
            File readfile = new File("account.txt");
            rfile = new Scanner(readfile);
            String st[] = rfile.nextLine().split(" ");
            f_acc = st[0];
            f_pw = st[1];
        } catch (Exception e) {
            System.out.println("read user error!");
        }
    }
    private static void readverifyString(){
        try {
            File readconfig = new File("myconfig.txt");
            rfile = new Scanner(readconfig);
            String st[]  = rfile.nextLine().split(":");
            f_vs = st[1];
        } catch (Exception e) {
            System.out.println("read string error!");
        }
    }
}