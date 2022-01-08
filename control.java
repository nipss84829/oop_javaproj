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
                    setdisplay();
                    break;
                //Set_display_field
                case "11":
                //Set_show_perpage
                case "12":
                    setorder();
                    break;
                // Set_order
                case "13":
                    sortbyfield();
                    break;
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
        // System.out.printf("%-4s %-12s %-11s %-12s %-24s %-4s\n","[ID]","[Name]","[Phone]","[Catalog]","[Email]","[BD]");
        bar();
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
            x.print();
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
                                    outbook.print();
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
                                    outbook.print();
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
                                    outbook.print();
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
            data.print();
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
    public static void setdisplay(){
        Config config = new Config();
        int valuearr[] = new int[5];
        String input;
        valuearr[0] = config.getbooltoint("show_name");
        valuearr[1] = config.getbooltoint("show_phone");
        valuearr[2] = config.getbooltoint("show_catalog");
        valuearr[3] = config.getbooltoint("show_email");
        valuearr[4] = config.getbooltoint("show_birthday");
        System.out.println("[1].Show_name:"+valuearr[0]
                        +" [2].Show_phone:"+valuearr[1]
                        +" [3].Show_cat:"+valuearr[2]
                        +" [4].Show_email:"+valuearr[3]
                        +" [5].Show_bd:"+valuearr[4]+"\n");

        System.out.println("New_show_name(0/1):");
        input = Main.scn.nextLine();
        config.intwtoString("show_name", Integer.parseInt(input));
        // if(!input.trim().equals("1")||!input.trim().equals("0")){
        //     System.out.println("Input_error_plaese_input_0_or_1:");
        // }
        // else{
        //     config.setvalue("show_name", input);
        // }

        System.out.println("New_show_phone(0/1):");
        input = Main.scn.nextLine();
        config.intwtoString("show_phone", Integer.parseInt(input));
        // if(!input.trim().equals("1")||!input.trim().equals("0")){
        //     System.out.println("Input_error_plaese_input_0_or_1:");
        // }
        // else{
        //     config.setvalue("show_phone", input);
        // }
        
        System.out.println("New_show_cat(0/1):");
        input = Main.scn.nextLine();
        config.intwtoString("show_catalog", Integer.parseInt(input));
        // if(!input.trim().equals("1")||!input.trim().equals("0")){
        //     System.out.println("Input_error_plaese_input_0_or_1:");
        // }
        // else{
        //     config.setvalue("show_catalog", input);
        // }

        System.out.println("New_show_email(0/1):");
        input = Main.scn.nextLine();
        config.intwtoString("show_email", Integer.parseInt(input));
        // if(!input.trim().equals("1")||!input.trim().equals("0")){
        //     System.out.println("Input_error_plaese_input_0_or_1:");
        // }
        // else{
        //     config.setvalue("show_email", input);
        // }

        System.out.println("New_show_bd(0/1):");
        input = Main.scn.nextLine();
        config.intwtoString("show_birthday", Integer.parseInt(input));
        // if(!input.trim().equals("1")||!input.trim().equals("0")){
        //     System.out.println("Input_error_plaese_input_0_or_1:");
        // }
        // else{
        //     config.setvalue("show_birthday", input);
        // }
        System.out.println();

        valuearr[0] = config.getbooltoint("show_name");
        valuearr[1] = config.getbooltoint("show_phone");
        valuearr[2] = config.getbooltoint("show_catalog");
        valuearr[3] = config.getbooltoint("show_email");
        valuearr[4] = config.getbooltoint("show_birthday");

        System.out.println("[1].Show_name:"+valuearr[0]
                        +" [2].Show_phone:"+valuearr[1]
                        +" [3].Show_cat:"+valuearr[2]
                        +" [4].Show_email:"+valuearr[3]
                        +" [5].Show_bd:"+valuearr[4]);
        simpleback();
    }
    public static void setorder(){
        //12
        Config config = new Config();
        
        System.out.println("show_sort_order:"+config.getvalue("show_sort_order"));
        System.out.println("Please_input_new_sort_order:");
        String input = Main.scn.nextLine();
        if(input.equals("asc")||input.equals("des")){
            config.setvalue("show_sort_order", input);
        }
        else{
            System.out.println("Input_error_plaese_input_asc_or_des:");
        }
        System.out.println("show_sort_order:"+config.getvalue("show_sort_order"));
        simpleback();
    }
    public static void bar(){
        Data data = new Data();
        data.printtitle();
    }
    public static void sortbyfield(){
        Config config = new Config();

        System.out.println("[1].ID [2].Name [3].Phone [4].Cat [5].Email [6].Bd");
        System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
        String select;
        while(true){
            select = Main.scn.nextLine();
            switch(select){
                case "1":
                    config.setvalue("show_sort_field","id");
                    System.out.println("Sorted_by:ID");
                    System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
                    break;
                case "2":
                    config.setvalue("show_sort_field","name");
                    System.out.println("Sorted_by:Name");
                    System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
                    break;
                case "3":
                    config.setvalue("show_sort_field","phone");
                    System.out.println("Sorted_by:Phone");
                    System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
                    break;
                case "4":
                    config.setvalue("show_sort_field","cat");
                    System.out.println("Sorted_by:Cat");
                    System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
                    break;
                case "5":
                    config.setvalue("show_sort_field","email");
                    System.out.println("Sorted_by:Email");
                    System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
                    break;
                case "6":
                    config.setvalue("show_sort_field","bd");
                    System.out.println("Sorted_by:Bd");
                    System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
                    break;
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