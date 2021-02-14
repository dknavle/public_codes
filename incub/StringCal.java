import java.util.Scanner;

public class StringCal {
    public static void main(String[] args) {
        
        StringCal stringCal = new StringCal();
        int ans;
        // input from user
        Scanner sc = new Scanner(System.in);
        String calString = sc.next();

        ans = stringCal.Add(calString);

        System.out.println(ans);
    }

    // 
    int Add(String calString){

        String delemeter = ",";

        if(calString.startsWith("//") && calString.contains("\\n")){
            try {
                delemeter = calString.substring(2,calString.indexOf("\\n")); 
                calString = calString.substring(calString.indexOf("\\n")+2);
            } catch (Exception e) {
                System.out.println(" Exception Occurred : "+e.getMessage());
                return 0;
            }
            
           // System.out.println("dele "+delemeter + " "+calString);
        }

        // \n into ,
        calString = calString.replace("\\n",delemeter);

        String[] arr = calString.split(delemeter);
        int fans = 0;
        
        for(String str : arr){
            try{
                fans += Integer.parseInt(str);
            }catch(Exception e){
                System.out.println(" Exception Occurred : "+e.getMessage());
                return 0;
            }
        }
        return fans;
    }
}