import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataArray{
    
    public static void load(){
        readfile();
    }
    private static ArrayList<Data> databook = new ArrayList<>();

    public static void show_all(){
        Config config = new Config();
        String show_sort_field = config.getvalue("show_sort_field");
        String show_sort_order = config.getvalue("show_sort_order");
        String s = show_sort_field+show_sort_order;
        //System.out.println(s);
        ArrayList<Data> sort = new ArrayList<>(databook);
        ranking(s,sort);
        for(Data x:sort){
            x.print();
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
    public static void ranking(String datatype,ArrayList <Data> rankinglist){
        Comparator<Data> id = new Comparator<Data>() {
                @Override
                public int compare(Data e1,Data e2){
                    return e1.getID().compareTo(e2.getID());
                }
            };
        Comparator<Data> name = new Comparator<Data>() {
            @Override
            public int compare(Data e1,Data e2){
                return e1.getName().compareTo(e2.getName());
            }
        };
        Comparator<Data> phone = new Comparator<Data>() {
            @Override
            public int compare(Data e1,Data e2){
                return e1.getPhoneNumber().compareTo(e2.getPhoneNumber());
            }
        };
        Comparator<Data> email = new Comparator<Data>() {
            @Override
            public int compare(Data e1,Data e2){
                return e1.getemail().compareTo(e2.getemail());
            }
        };
        Comparator<Data> catalog = new Comparator<Data>() {
            @Override
            public int compare(Data e1,Data e2){
                return e1.getcategory().compareTo(e2.getcategory());
            }
        };
        Comparator<Data> birthday = new Comparator<Data>() {
            @Override
            public int compare(Data e1,Data e2){
                return e1.getBirthday().compareTo(e2.getBirthday());
            }
        };
        switch(datatype){
            case "idasc":
                Collections.sort(rankinglist,id);
                break;
            case "iddes":
                Collections.sort(rankinglist,id);
                Collections.reverse(rankinglist);
                break;
            case "nameasc":
                Collections.sort(rankinglist,name);
                break;
            case "namedes":
                Collections.sort(rankinglist,name);
                Collections.reverse(rankinglist);
                break;
            case "phoneasc":
                Collections.sort(rankinglist,phone);
                break;            
            case "phonedes":
                Collections.sort(rankinglist,phone);
                Collections.reverse(rankinglist);
                break;
            case "catasc":
                Collections.sort(rankinglist,catalog);
                break;
            case "catdes":
                Collections.sort(rankinglist,catalog);
                Collections.reverse(rankinglist);
                break;
            case "emailasc":
                Collections.sort(rankinglist,email);
                break;
            case "emaildes":
                Collections.sort(rankinglist,email);
                Collections.reverse(rankinglist);
                break;
            case "bdasc":
                Collections.sort(rankinglist,birthday);
                break;
            case "bddes":
                Collections.sort(rankinglist,birthday);
                Collections.reverse(rankinglist);
                break;
        }

    }
    // static Comparator<Data> id = new Comparator<Data>() {
    //     @Override
    //     public int compare(Data e1,Data e2){
    //         return e1.getID().compareTo(e2.getID());
    //     }
    // };
    // static Comparator<Data> name = new Comparator<Data>() {
    //     @Override
    //     public int compare(Data e1,Data e2){
    //         return e1.getName().compareTo(e2.getName());
    //     }
    // };
    // static Comparator<Data> phone = new Comparator<Data>() {
    //     @Override
    //     public int compare(Data e1,Data e2){
    //         return e1.getPhoneNumber().compareTo(e2.getPhoneNumber());
    //     }
    // };
    // static Comparator<Data> email = new Comparator<Data>() {
    //     @Override
    //     public int compare(Data e1,Data e2){
    //         return e1.getemail().compareTo(e2.getemail());
    //     }
    // };
    // static Comparator<Data> catalog = new Comparator<Data>() {
    //     @Override
    //     public int compare(Data e1,Data e2){
    //         return e1.getcategory().compareTo(e2.getcategory());
    //     }
    // };
    // static Comparator<Data> birthday = new Comparator<Data>() {
    //     @Override
    //     public int compare(Data e1,Data e2){
    //         return e1.getBirthday().compareTo(e2.getBirthday());
    //     }
    // };
}