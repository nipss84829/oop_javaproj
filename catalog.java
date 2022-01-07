import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


public class catalog {
    //private static SortedSet <String> cata = new TreeSet<>();
    private static ArrayList <String> cata = new ArrayList<>();
    public static void load(){
        readfile();
    }
    public static void show(){
        System.out.println("[Catalog]");
        for(String x: cata){
            System.out.println(x);
        }
    }
    private static void readfile(){
        try {
            Scanner scn = new Scanner(new File("catalog.txt"));
            while(scn.hasNextLine()){
                cata.add(scn.nextLine());
            }
            scn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writefile(){
        try {
            FileWriter FW = new FileWriter("catalog.txt");
            for(String x:cata){
                FW.write(x+System.lineSeparator());
            }
            FW.close();
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("error to write back file!");
        }
    }
    public static void doaddcat(){
        while(true){
            System.out.println("Please_input_new_catalog:");
            String newcat = Main.scn.nextLine();
            if(newcat.length()>12){
                System.out.println("Error_catalog_too_long");
                continue;
            }else if(!addcat(newcat)){
                System.out.println("Error_catalog_existed");
                continue;
            }
            else {
                addcat(newcat);
                System.out.println("Add_catalog_"+newcat+"_success");
                break;
            }
        }
    }
    private static boolean addcat(String adc){
        for(String check:cata){
            if(check.equals(adc))return false;
        }
        cata.add(adc);
        Collections.sort(cata);
        return true;
    }
    public String selectcatalog(){
        System.out.print("Catalogs:");
        // int index;
        String index;
        String selcate="";
        int i=97;
        for(String x: cata){
            System.out.print("["+(char)i+"].");
            System.out.print(x+" ");
            i++;
        }
        System.out.println();
        System.out.println("Catalog:");
        while(true){
            try {
                index = Main.scn.nextLine();
                byte[] bytes = index.getBytes(StandardCharsets.US_ASCII);
                if(bytes[0]<=i&&bytes[0]>=97){
                    selcate = cata.get(bytes[0]-97);
                    break;
                }
                else {
                    System.out.println("Error_wrong_data");
                    System.out.println("Please_input_again:");
                    //throw new Exception();
                }
            } catch (Exception e) {
                e.printStackTrace();
                // System.out.println("Error_wrong_data");
                // System.out.println("Please_input_again:");
            }
        }
        return selcate;
    }
    // public String selectcategory(){
    //     System.out.println("please enter number of category");
    //     show();
    //     int index=0;
    //     String selcate="";
    //     while(true){
    //         try{
    //             index = Integer.parseInt(Main.scn.nextLine());
    //             selcate = catalog.get(index);
    //             break;
    //         }catch(Exception e){
    //             System.out.println("error! index not found or not index ! please retype it");
    //             System.out.println();
    //         }
    //     }
    //     return selcate;
    // }
}