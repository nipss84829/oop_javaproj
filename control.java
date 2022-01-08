import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class control{
    public static void domainmenu(){
        String mainselect;
        while(true){
            menu.mainmenu();
            mainselect = Main.scn.nextLine();
            switch(mainselect){
                case "1":
                    doshow_all();
                    break;
                //Show_all
                case "2":
                    showperpage();
                    break;
                //Show_per_page
                case "3":
                //Show_by_catalog
                    showbycatalog();
                    break;
                case "4":
                    search();
                    break;
                    //Search
                case "5":
                    modify();
                    break;
                //Modify
                case "6":
                    deletedata();
                    break;
                //Delete
                case "7":
                    Add_contact();
                    break;
                //Add_contact
                case "8":
                    catalog.doaddcat();
                    simpleback();
                    break;
                //Add_catalog
                case "9":
                    catalog.show();
                    simpleback();
                    break;
                //show_all_catalog
                case "10":
                //Set_display_field
                case "11":
                //Set_show_perpage
                case "12":
                // Set_order
                case "13":
                // Set_sort_by_field
                case "14":
                //showRawDATA
                    doshow_all();
                    break;
                case "15":
                // Data_optimize 
                case "99":
                    System.exit(0);
                    break;
                default:
                    menu.wrong();
            }
        }
    }
    public static void doshow_all(){
        //1
        System.out.printf("%-4s %-12s %-11s %-12s %-24s %-4s\n","[ID]","[Name]","[Phone]","[Catalog]","[Email]","[BD]");
        DataArray.show_all();
        menu.show_all();
        String select ;
        while(true){
            select = Main.scn.nextLine();
            switch(select){
                case "0":
                    return;
                case "99":
                    System.exit(0);
                default:
                    menu.wrong();
                    break;
            }
        }
    }
    public static void showperpage(){
        //2
    }
    public static void showbycatalog(){
        //3
        ArrayList<Data> searched;
        ArrayList<String> cata = catalog.getcata();
        System.out.println("Catalogs:");
        String index;
        String selcate="";
        int i=97;
        for(String x: cata){
            System.out.print("["+(char)i+"].");
            System.out.print(x+" ");
            i++;
        }
        System.out.println();
        System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
        System.out.println("Input_catalog_to_show:");
        while(true){
            try {
                index = Main.scn.nextLine();
                //System.out.println("index: "+index);
                if(index.equals("0")){
                    domainmenu();
                    break;
                }
                else if(index.equals("99")){
                    System.exit(0);
                }
                else{
                    byte[] bytes = index.getBytes(StandardCharsets.US_ASCII);
                    if(bytes[0]<=i&&bytes[0]>=97){
                        selcate = cata.get(bytes[0]-97);
                        //System.out.println("selecate2: "+selcate);
                        break;
                    }
                    else {
                        System.out.println("Error_wrong_data");
                        System.out.println("Please_input_again:");
                        //throw new Exception();
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Error_wrong_data");
                System.out.println("Please_input_again:");
            }
        }
        //System.out.println("selcate:"+selcate);
        searched = DataArray.searchitem("catalog",selcate);
        
        bar();
        for(Data x:searched){
            x.getlineData();
        }
        simpleback();
    }
    public static void search(){
        //4
        ArrayList<Data> x = null;
        menu.search();
        String select;
        String value;
        String sub;
        Data data = new Data();
        while(true){
            select = Main.scn.nextLine();
            switch(select){
                case "a":
                    //ID
                    System.out.println("Input_target:");
                    while(true){
                        value = Main.scn.nextLine();
                        if(data.checkID(value)){
                            int convert = Integer.parseInt(value);
                            value = Integer.toString(convert);
                            x = DataArray.searchitem("ID", value);
                            if(x.isEmpty()){
                                System.out.println("Error_no_result");
                                break;
                            }else{
                                System.out.println("Search_result:");
                                bar();
                                for(Data outbook:x){
                                    outbook.getlineData();
                                }break;

                            }
                        }
                        else{
                            System.out.println("Error_wrong_data");
                            System.out.println("Please_input_again:");
                        }
                    }
                    System.out.println("[1].Restart_search [0].Go_back_to_main_menu [99].Exit_system");
                    sub = Main.scn.nextLine();
                    if(sub.equals("1")){
                        search();
                        break;
                    }
                    else if(sub.equals("0")){
                        domainmenu();
                        break;
                    }
                    else if(sub.equals("99")){
                        System.exit(0);
                    }
                case "b":
                    //name
                    System.out.println("Input_target:");
                    while(true){
                        value = Main.scn.nextLine();
                        if(data.checkName(value)){
                            x = DataArray.searchitem("name", value);
                            if(x.isEmpty()){
                                System.out.println("Error_no_result");
                                break;
                            }else{
                                System.out.println("Search_result:");
                                bar();
                                for(Data outbook:x){
                                    outbook.getlineData();
                                }
                                break;
                            }
                        }
                        else{
                            System.out.println("Error_wrong_data");
                            System.out.println("Please_input_again:");
                        }
                    }
                    System.out.println("[1].Restart_search [0].Go_back_to_main_menu [99].Exit_system");
                    sub = Main.scn.nextLine();
                    if(sub.equals("1")){
                        search();
                        break;
                    }
                    else if(sub.equals("0")){
                        domainmenu();
                        break;
                    }
                    else if(sub.equals("99")){
                        System.exit(0);
                    }
                case "c":
                    //birthday
                    System.out.println("Input_target:");
                    while(true){
                        value = Main.scn.nextLine();
                        if(data.checkDate(value)){
                            x = DataArray.searchitem("birthday", value);
                            if(x.isEmpty()){
                                System.out.println("Error_no_result");
                                break;
                            }else{
                                System.out.println("Search_result:");
                                bar();
                                for(Data outbook:x){
                                    outbook.getlineData();
                                }
                                break;
                            }
                        }
                        else{
                            System.out.println("Error_wrong_data");
                            System.out.println("Please_input_again:");
                        }
                    }
                    System.out.println("[1].Restart_search [0].Go_back_to_main_menu [99].Exit_system");
                    sub = Main.scn.nextLine();
                    if(sub.equals("1")){
                        search();
                        break;
                    }
                    else if(sub.equals("0")){
                        domainmenu();
                        break;
                    }
                    else if(sub.equals("99")){
                        System.exit(0);
                    }
                case "0":
                    domainmenu();
                    break;
                case "99":
                    System.exit(0);
                default:
                    menu.wrong();
                    break;
            }
        }
    }
    public static void Add_contact(){
        DataArray.additem();
        simpleback();
    }
    public static void deletedata(){
        while(true){
            System.out.println("Input_ID_to_be_deleted:");
            String id = Main.scn.nextLine();
            String value="";
            try {
                int convert = Integer.parseInt(id);
                value = Integer.toString(convert);
            } catch (Exception e) {
                //System.out.println("Error_no_such_data");
                
            }
            if(DataArray.delete(value)){
                System.out.println("Delete_data_success");
                break;
            }
            else{
                System.out.println("Error_no_such_data");
            }
        }
        simpleback();
    }
    public static void modify(){
        System.out.println("Input_ID_to_be_modified:");
        String id = Main.scn.nextLine();
        int s_id = Integer.valueOf(id);
        id = String.valueOf(s_id);
        ArrayList<Data> sdata = DataArray.searchitem("ID",id);
        Data data ;
        if(!sdata.isEmpty()){
            data = sdata.get(0);
            System.out.println("Search_result:");
            bar();
            data.getlineData();
            System.out.println("New_name:");
            String name = Main.scn.nextLine();
            if(!name.isEmpty()){
                data.setName(name);
            }
            System.out.println("New_phone:");
            String phone = Main.scn.nextLine();
            if(!phone.isEmpty()){
                data.setphoneNumber(phone);
            }
            data.modselectcatalog();
            System.out.println("New_email:");
            String mail = Main.scn.nextLine();
            if(!phone.isEmpty()){
                data.setemail(mail);
            }
            System.out.println("New_birthday:");
            String birthday = Main.scn.nextLine();
            if(!birthday.isEmpty()){
                data.setBirthday(birthday);
            }
            DataArray.modify(data);
            System.out.println("Modify_data_success");
        }   
        simpleback();
    }
    public static void bar(){
        System.out.printf("%-4s %-12s %-11s %-12s %-24s %-4s\n",
        "[ID]","[Name]","[Phone]","[Catalog]","[Email]","[BD]");
    }
    public static void simpleback(){
        String select;
        while(true){
            menu.simplegoback();
            select = Main.scn.nextLine();
            switch(select){
                case "0":
                    return;
                case "99":
                    System.exit(0);
                default:
                    menu.wrong();
                    break;
            }
        }
    }
}