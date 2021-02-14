import java.util.Scanner;

public class StringCal {
    public static void main(String[] args) {
        
        StringCal stringCal = new StringCal();
        int ans;
        // input from user
        Scanner sc = new Scanner(System.in);
        String calString = sc.next();

        try{
            ans = stringCal.Add(calString);
            System.out.println(ans);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

        
    }

    // 
    int Add(String calString) throws NegetiveNumberException{

        String delemeter = ",";

        if(calString.startsWith("//") && calString.contains("\\n")){
            try {
                delemeter = calString.substring(2,calString.indexOf("\\n")); 
                calString = calString.substring(calString.indexOf("\\n")+2);
            } catch (Exception e) {
                throw e;
                //System.out.println(" Exception Occurred : "+e.getMessage());
                //return 0;
            }
            
           // System.out.println("dele "+delemeter + " "+calString);
        }

        // \n into ,
        calString = calString.replace("\\n",delemeter);

        String[] arr = calString.split(delemeter);
        int fans = 0;
        
        for(String str : arr){
            try{
                if(str.contains("-")) throw new NegetiveNumberException("negatives not allowed. "+ str);
                int number = Integer.parseInt(str);
                if(number > 1000) continue;
                fans += number;
            }catch(Exception e){
                throw e;//new Exception(" Exception Occurred : "+e.getMessage());
                //System.out.println(" Exception Occurred : "+e.getMessage());
                //return 0;
            }
        }
        return fans;
    }
}

class NegetiveNumberException extends Exception{  
    NegetiveNumberException(String s){  
     super(s);  
    }  
}

