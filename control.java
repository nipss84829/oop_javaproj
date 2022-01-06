import java.util.Scanner;
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
                    menu.search();
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
        String select ;
        while(true){
            menu.show_all();
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