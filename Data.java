import java.text.SimpleDateFormat;
import java.util.Date;

public class Data{
    private int ID;
    private String Name;
    private String Birthday;
    private String phoneNumber;
    private catalog Cate = new catalog();
    private String category;
    private String email;
    public Data(){
        Name = "NONAME";
        Birthday = "NOBIRTHDAY";
        phoneNumber = "NOPHONENUMBER";
        category = "NOCATEGORY";
        email = "NOEMAIL";
    }
    public Data(int ID ,String Name,String phoneNumber,String category,String email,String Birthday){
        this.ID=ID;
        this.Name=Name;
        this.Birthday=Birthday;
        this.phoneNumber=phoneNumber;
        this.category=category;
        this.email=email;
    }
    // public void getlineData(){
    //     System.out.printf("%04d %-12s %-11s %-12s %-24s %-4s\n",ID,Name,phoneNumber,category,email,Birthday);
    //     //System.out.println(getName()+"\t"+getBirthday()+"\t"+getPhoneNumber()+"\t"+getcategory()+"\t"+getemail());
    // }
    public void printtitle(){
        Config config = new Config();
        titleformat(config.getbooltoint("show_name"), 
        config.getbooltoint("show_phone"), 
        config.getbooltoint("show_catalog"), 
        config.getbooltoint("show_email"),
        config.getbooltoint("show_birthday"));
    }
    public void print(){
        Config config = new Config();
        dataformat(config.getbooltoint("show_name"), 
        config.getbooltoint("show_phone"), 
        config.getbooltoint("show_catalog"), 
        config.getbooltoint("show_email"),
        config.getbooltoint("show_birthday"));
    }
    public void titleformat(int n,int p,int c,int e,int b){
        // "%-4s %-12s %-11s %-12s %-24s %-4s\n","[ID]","[Name]","[Phone]","[Catalog]","[Email]","[BD]")
        String format="";
        format +=String.format("%-4s","[ID]");
        if(n==1){
            format+=String.format(" %-12s","[Name]");
        }
        if(p==1){
            format+=String.format(" %-11s","[Phone]");
        }
        if(c==1){
            format+=String.format(" %-12s","[Catalog]");
        }
        if(e==1){
            format+=String.format(" %-24s","[Email]");
        }
        if(b==1){
            format+=String.format(" %-4s","[BD]");
        }
        format+="\n";
        System.out.printf(format);
    }
    public void dataformat(int n,int p,int c,int e,int b){
        String format="";
        format +=String.format("%04d",this.ID);
        if(n==1){
            format+=String.format(" %-12s",this.Name);
        }
        if(p==1){
            format+=String.format(" %-11s",this.phoneNumber);
        }
        if(c==1){
            format+=String.format(" %-12s",this.category);
        }
        if(e==1){
            format+=String.format(" %-24s",this.email);
        }
        if(b==1){
            format+=String.format(" %-4s",this.Birthday);
        }
        format+="\n";
        System.out.printf(format);
    }    
    public String showformate(String datatype){
        String name="%-12s",phonenumber="%-11s",category="%-12s",email="%-24s",birthday="%-4s";
        switch(datatype){
            case "name":
                return name;
            case "phonenumber":
                return phonenumber;
            case "category":
                return category;
            case "email":
                return email;
            case "birthday":
                return birthday;  
            default: return "";
        }
    }
    
    public String getallData(){
        return(getName()+"\t"+getBirthday()+"\t"+getPhoneNumber()+"\t"+getcategory()+"\t"+getemail()+"\n");
    } 
    public void setID(int ID){
        this.ID = ID;
    }

    public boolean setName(String Name){
        if(Name!=null&&Name.length()<=12){
            this.Name = Name;
            //System.out.println("OK");
            return true;
        }
        else {
            System.out.println("Error_wrong_data");
            System.out.println("Please_input_again:");
            return false;
        }
    }
    public boolean setBirthday(String Birthday){
        if(Birthday!=null&&checkDate(Birthday)){
            this.Birthday = Birthday;
            // System.out.println("OK");
            return true;
        }
        else {
            System.out.println("Error_wrong_data");
            System.out.println("Please_input_again:");
            return false;
        }
        
    }
    public boolean setphoneNumber(String phoneNumber){
        if(phoneNumber!=null&&checkPhone(phoneNumber)){
            this.phoneNumber = phoneNumber;
            // System.out.println("OK");
            return true;
        }
        else {
            System.out.println("Error_wrong_data");
            System.out.println("Please_input_again:");
            return false;
        }
    }
    //category.java
    public void setcategory(){
        //while(Cate.selectcategory().equals("")){
            category = Cate.selectcatalog();
        //}
    }
    public void modselectcatalog(){
        if(!Cate.modselectcatalog().isEmpty()){
            category = Cate.modselectcatalog();
        }

    }
    public boolean setemail(String email){
        if(email!=null&&checkEmail(email)&&email.length()<=24){
            this.email = email;
            //System.out.println("OK");
            return true;
        }
        else {
            System.out.println("Error_wrong_data");
            System.out.println("Please_input_again:");
            return false;
        }
    }
    public String getID(){
        //String Stringid = String.format("%04d",id);
        return String.format("%04d",this.ID);
        //Integer.toString(this.ID);
    }
    public String getName(){
        return this.Name;
    }
    public String getBirthday(){
        return this.Birthday;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getcategory(){
        return this.category;
    }
    public String getemail(){
        return this.email;
    }

    public boolean equals(Data compData){
        if(this.Name.equals(compData.getName())
        &&this.Birthday.equals(compData.getBirthday())
        &&this.phoneNumber.equals(compData.getPhoneNumber())
        &&this.category.equals(compData.getcategory())
        &&this.email.equals(compData.getemail())){
            return true;
        }
        return false;
    }
    public boolean checkID(String ID){
        int convert;
        try {
            convert = Integer.parseInt(ID);
        } catch (Exception e) {
            return false;
        }
        String theid = Integer.toString(convert);
        if(theid.length()<5){
            return true;
        }else{
            return false;
        }

    }
    public boolean checkName(String name){
        if(name.trim().equals("")||name.matches("^[0-9]*$")){
            return false;
        }
        else return true;
    }
    public boolean checkDate(String Birthday){
        if(Birthday.trim().equals("")){
            return false;
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
            sdf.setLenient(false);

            try{
                Date testDate = sdf.parse(Birthday);
                testDate.getTime();
                //vaild Date
            }catch (Exception e) {
                //System.out.println("invaild Date");
                return false;
                //invaild Date
            }
            //System.out.println("vaild Date");
            this.Birthday = Birthday;
            return true;
        }
    }
    public boolean checkPhone(String phoneNumber){
        if(phoneNumber.matches("[0-9]{4}-[0-9]{6}")){
            return true;
        }
        return false;
    }
    public boolean checkEmail(String email){
        // if(email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")){
        if(email.matches(".+@.+\\..+")){
            return true;
        }
        return false;
    }
}