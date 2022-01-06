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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}