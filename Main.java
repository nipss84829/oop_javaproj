import java.util.Scanner;

public class Main {
    //static BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
    public static Scanner scn;
    public static Auth auth = new Auth();
    public static void main(String[] args) {
        scn = new Scanner(System.in);
        DataArray.load();
        auth.load();
        catalog.load();
        auth.calllogin();
        control.domainmenu();
    }
}
