import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataArray{
    
    static{
        readfile();
    }
    private static ArrayList<Data> databook = new ArrayList<>();

    public static void show_all(){
        //System.out.println("showALL");
        for(Data x:databook){
            x.getlineData();
        }
    }

    public static void readfile(){
        try {
            File book = new File("data.txt");
            Scanner read = new Scanner(book);
            while(read.hasNextLine()){
                String data[] = new String[6];
                String rf = read.nextLine();
                StringTokenizer st = new StringTokenizer(rf);
                data[0] = st.nextToken();
                data[1] = st.nextToken();
                data[2] = st.nextToken();
                data[3] = st.nextToken();
                data[4] = st.nextToken();
                data[5] = st.nextToken();
                databook.add(new Data(data[0],data[1],data[2],data[3],data[4],data[5]));
            }
            //System.out.println("READFILE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}