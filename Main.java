import java.util.Scanner;

public class Main {
    //static BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
    public static Scanner scn;
    public static void main(String[] args) {
        DataArray.load();
        auth.load();
        catalog.load();
        scn = new Scanner(System.in);
        auth.calllogin();
        control.domainmenu();
    }
}
