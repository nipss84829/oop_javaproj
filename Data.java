import java.text.SimpleDateFormat;
import java.util.Date;

public class Data{
    private String ID;
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
    public Data(String ID ,String Name,String phoneNumber,String category,String email,String Birthday){
        this.ID=ID;
        this.Name=Name;
        this.Birthday=Birthday;
        this.phoneNumber=phoneNumber;
        this.category=category;
        this.email=email;
    }
    public void getlineData(){
        System.out.printf("%-4s %-12s %-11s %-12s %-24s %-4s\n",ID,Name,phoneNumber,category,email,Birthday);
        //System.out.println(getName()+"\t"+getBirthday()+"\t"+getPhoneNumber()+"\t"+getcategory()+"\t"+getemail());
    }
    public String getallData(){
        return(getName()+"\t"+getBirthday()+"\t"+getPhoneNumber()+"\t"+getcategory()+"\t"+getemail()+"\n");
    } 
    public void setID(){
        
    }
    public boolean setName(String Name){
        if(Name!=null){
            this.Name = Name;
            System.out.println("OK");
            return true;
        }
        else {
            System.out.println("Name cannnot be blank");
            System.out.println("please retype it!");
            return false;
        }
    }
    public boolean setBirthday(String Birthday){
        if(Birthday!=null&&checkDate(Birthday)){
            this.Birthday = Birthday;
            System.out.println("OK");
            return true;
        }
        else {
            System.out.println("Birthday cannnot be blank or format error");
            System.out.println("please retype it!");
            return false;
        }
        
    }
    public boolean setphoneNumber(String phoneNumber){
        if(phoneNumber!=null&&checkPhone(phoneNumber)){
            this.phoneNumber = phoneNumber;
            System.out.println("OK");
            return true;
        }
        else {
            System.out.println("phoneNumber cannnot be blank or format error");
            System.out.println("please retype it!");
            return false;
        }
    }
    //category.java
    public void setcategory(){
        //while(Cate.selectcategory().equals("")){
            category = Cate.selectcategory();
        //}
    }

    public boolean setemail(String email){
        if(email!=null&&checkEmail(email)){
            this.email = email;
            System.out.println("OK");
            return true;
        }
        else {
            System.out.println("email cannnot be blank or format error");
            System.out.println("please retype it!");
            return false;
        }
    }
    //String Name,String Birthday,String phoneNumber,String category,String email
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
    private boolean checkDate(String Birthday){
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
    private boolean checkPhone(String phoneNumber){
        if(phoneNumber.matches("[0-9]{4}-[0-9]{6}")){
            return true;
        }
        return false;
    }
    private boolean checkEmail(String email){
        if(email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")){
            return true;
        }
        return false;
    }
}