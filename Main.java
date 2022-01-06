import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class config {
    static Scanner read;
    static String verify_string,used_last_id,show_sort_field,
    show_sort_order,show_name,show_phone,show_catalog,
    show_email,show_birthday,show_defalt_perpage;
    static {
        read();
    }
    public static void read(){
        try {
            File readconfig = new File("myconfig.txt");
            read = new Scanner(readconfig);
            String vs[]  = read.nextLine().split(":");
            String uli[]  = read.nextLine().split(":");
            String ssf[]  = read.nextLine().split(":");
            String sso[]  = read.nextLine().split(":");
            String sn[]  = read.nextLine().split(":");
            String sp[]  = read.nextLine().split(":");
            String sc[]  = read.nextLine().split(":");
            String se[]  = read.nextLine().split(":");
            String sb[]  = read.nextLine().split(":");
            String sdp[]  = read.nextLine().split(":");
            verify_string = vs[1].replaceAll("\\s+","");
            used_last_id = uli[1].replaceAll("\\s+","");
            show_sort_field = ssf[1].replaceAll("\\s+","");
            show_sort_order = sso[1].replaceAll("\\s+","");
            show_name = sn[1].replaceAll("\\s+","");
            show_phone = sp[1].replaceAll("\\s+","");
            show_catalog = sc[1].replaceAll("\\s+","");
            show_email = se[1].replaceAll("\\s+","");
            show_birthday = sb[1].replaceAll("\\s+","");
            show_defalt_perpage = sdp[1].replaceAll("\\s+","");

        } catch (Exception e) {
            System.out.println("read p error!");
        }
    }
}
public class Main {
    //static BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
    public static Scanner scn;
    public static void main(String[] args) throws IOException{
        auth.load();
        scn = new Scanner(System.in);
        auth.calllogin();
        control.domainmenu();
    }
}
