import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

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
                //Show_per_page
                case "3":
                //Show_by_catalog
                case "4":
                    search();
                    break;
                    //Search
                case "5":
                //Modify
                case "6":
                //Delete
                case "7":
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
    public static void search(){
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