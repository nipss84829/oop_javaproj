public class menu{
    public static void mainmenu(){
        System.out.print("****************************************\n" +
        "[1].Show_all [2].Show_per_page [3].Show_by_catalog\n"+
        "[4].Search [5].Modify [6].Delete [7].Add_contact\n"+
        "[8].Add_catalog [9].Show_all_catalog [10].Set_display_field\n"+
        "[11].Set_show_perpage [12].Set_order [13].Set_sort_by_field\n"+
        "[14].Show_raw_data [15].Data_optimize [99].Exit_system\n" +
        "****************************************\n");
    }
    public static void show_all(){
        System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
    }
    public static void search(){
        //System.out.print("****************************************\n");
        System.out.print("Search by:\n");
        System.out.print("[a].ID [b].Name [c].Birthday \n");
        System.out.print("[0].Go_back_to_main_menu [99].Exit_system\n");
        //System.out.print("****************************************\n");
    }
    
    public static void catalog(){

    }
    public static void wrong(){
        System.out.println("Error_wrong_command\n"+
        "Please_enter_again:");
    }
    public static void simplegoback(){
        System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
    }
    
}
