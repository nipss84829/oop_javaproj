import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class catalog {
    private static SortedSet <String> cata = new TreeSet<>();

    //private ArrayList<String> catalog = new ArrayList<>(); 
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
        System.out.println("Please_input_new_catalog:");
        String newcat = Main.scn.nextLine();
        if(!(newcat.length()>12)){
            String fnewcat = newcat.substring(0,1);
            String rnewcat = newcat.substring(1,newcat.length());
            newcat = fnewcat+rnewcat;
    
            if(addcat(newcat)){
                System.out.println("Add_catalog_Gamers_success");
            }
            else{
                System.out.println("Error_catalog_existed");
            }
        }
        else{
            System.out.println("Error_catalog_to_long");
        }
        
    }
    private static boolean addcat(String adc){
        try {
            cata.add(adc);
            return true;
        } catch (Exception e) {
            return false;
        }
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