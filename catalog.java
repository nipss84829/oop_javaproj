import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class catalog {
    private ArrayList<String> catalog = new ArrayList<>(); 
    public catalog(){
        readfile();
    }
    public void show(){
        System.out.println("current category:");
        int i = 0;
        for(String x: catalog){
            System.out.println(i+":"+x);
            i++;
        }
    }
    public void readfile(){
        try {
            File cate = new File("catalog.txt");
            if(cate.exists()){
                Scanner scn = new Scanner(cate);
                while(scn.hasNextLine()){
                    catalog.add(scn.nextLine());  
                }
                scn.close();
            }
            else{
                cate.createNewFile();
                System.out.println("Created file \"catalog.txt\"");
                add();
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
    public void writefile(){
        try {
            FileWriter FW = new FileWriter("catalog.txt");
            for(String x:catalog){
                FW.write(x+System.lineSeparator());
            }
            FW.close();
        } catch (Exception e) {
            System.out.println("error to write back file!");
        }
    }
    public void add(){
        System.out.println("please insert a word to add category,type \"exit\" to back:");
        Scanner scn = new Scanner(System.in);
        String newcate = scn.nextLine();
        
        if(newcate!=null){
            catalog.add(newcate);
            System.out.println("add category SUCCESS!");
            show();
            writefile();
        }
        else System.out.println("entered null, please retype it");
    }
    public String selectcategory(){
        System.out.println("please enter number of category");
        show();
        int index=0;
        Scanner scn = new Scanner(System.in);
        String selcate="";
        while(true){
            try{
                index = Integer.parseInt(scn.nextLine());
                selcate = catalog.get(index);
                break;
            }catch(Exception e){
                System.out.println("error! index not found or not index ! please retype it");
                System.out.println();
            }
        }
        return selcate;
    }
}