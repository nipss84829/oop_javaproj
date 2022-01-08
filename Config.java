import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.validation.Validator;

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
    public void write(){
        String out = "";
        for(String k:myconfig.keySet()){
            out += k+":"+myconfig.get(k)+"\n";
        }
        out = out.trim();
        try {
            FileWriter fw = new FileWriter(new File("myconfig.txt"));
            fw.write(out);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // public void test(){
    //     System.out.println(myconfig.get("verify_string"));
    // }
    public int getbooltoint(String value){
        boolean x = Boolean.parseBoolean(myconfig.get(value));
        return x?1:0;
    }
    public void intwtoString(String key,int value){
        boolean res = (value == 0) ? false : true;
        String val = String.valueOf(res);
        myconfig.replace(key,val);
        write();
        read();
    }
    public String getvalue(String value){
        return myconfig.get(value);
    }
    public int getInt(String value){
        return Integer.valueOf(myconfig.get(value));
    }
    public void setInt(String key,int value){

    }
    public void setvalue(String key,String value){
        myconfig.replace(key,value);
        write();
        read();
    }
    public void wID(String key,int id){
        String pattern = "%04d";
        String Stringid = String.format(pattern,id);
        myconfig.replace(key,Stringid);
        write();
        read();
    }
}