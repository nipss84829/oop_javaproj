import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataArray{
    
    public static void load(){
        readfile();
    }
    private static ArrayList<Data> databook = new ArrayList<>();

    public static void show_all(){
        for(Data x:databook){
            x.getlineData();
        }
    }
    public static void additem(){
        Data newdata = new Data();
        Config config = new Config();
        int id = config.getInt("used_last_id");
        newdata.setID(id+1);
        config.wID("used_last_id", id+1);
        System.out.println("Name:");
        while(true){
            if(newdata.setName(Main.scn.nextLine()))break;
        }
        System.out.println("Phone_number:");
        while(true){
            if(newdata.setphoneNumber(Main.scn.nextLine()))break;
        }
        //catalogs
        newdata.setcategory();
        System.out.println("Email:");
        while(true){
            if(newdata.setemail(Main.scn.nextLine()))break;
        }
        System.out.println("Birthday:");
        while(true){
            if(newdata.setBirthday(Main.scn.nextLine()))break;
        }
        databook.add(newdata);
        System.out.println("Add_contact_success");
    }
    public static boolean delete(String id){
        int flag=0;
        Data deleteitem = new Data();
        for(Data book:databook){
            if(book.getID().equals(id)){
                flag = 1;
                deleteitem = book;
            }
        }
        if(flag==0){
            //System.out.println("Error_no_such_data");
            return false;
        }
        else{
            databook.remove(deleteitem);
            //System.out.println("Delete_data_success");
            return true;
        }
        
    }
    public static void modify(Data newData){
        int index = Integer.parseInt(newData.getID());
        index -=1;
        databook.set(index,newData);
    }

    public static ArrayList<Data> searchitem(String datatype,String value){
        ArrayList<Data> searchedData = new ArrayList<>();
        switch(datatype){
            case "id":case "ID":
                for(Data book:databook){
                    if(book.getID().equals(value)){
                        searchedData.add(book);
                    }
                }
                break;
            case "name":case "Name":
                for(Data book:databook){
                    if(book.getName().equals(value)){
                        searchedData.add(book);
                    }
                }
                break;
            case "birthday":case "Birthday":
                for(Data book:databook){
                    if(book.getBirthday().equals(value)){
                        searchedData.add(book);
                    }
                }
            case "catalog":
                for(Data book:databook){
                    if(book.getcategory().equals(value)){
                        searchedData.add(book);
                    }
                }
        }
        return searchedData;
    }
    public static void readfile(){
        try {
            Scanner read = new Scanner(new File("data.txt"));
            while(read.hasNextLine()){
                String d[] = new String[6];
                String rf = read.nextLine();
                StringTokenizer st = new StringTokenizer(rf);
                int id = Integer.parseInt(st.nextToken());
                d[1] = st.nextToken();
                d[2] = st.nextToken();
                d[3] = st.nextToken();
                d[4] = st.nextToken();
                d[5] = st.nextToken();
                databook.add(new Data(id,d[1],d[2],d[3],d[4],d[5]));
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}