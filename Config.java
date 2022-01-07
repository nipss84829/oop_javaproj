import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Config {
    HashMap<String,String> myconfig = new HashMap<>();

    Config(){
        read();
    }

    public void read(){
        try {
            Scanner read = new Scanner(new File("myconfig.txt"));
            while(read.hasNextLine()){
                String r = read.nextLine();
                String sp [] = r.split(":");
                myconfig.put(sp[0].trim(),sp[1].trim());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test(){
        System.out.println(myconfig.get("verify_string"));
    }

    public String getvalue(String value){
        return myconfig.get(value);
    }
}