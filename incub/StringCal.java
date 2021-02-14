import java.util.Scanner;

public class StringCal {
    String[] operators = new String[] {"-","+","/","*","x","^","X"};

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

        String delimeter = ",";
        //List<String> delimeters = new ArrayList<>();
        String[] delimeters = {};

        if(calString.startsWith("//[") && calString.contains("]\\n")){
            try {
                delimeter = calString.substring(3,calString.indexOf("]\\n")).replace("][","d"); 
                //System.out.println("Str "+calString.substring(3,calString.indexOf("]\\n")));
                calString = calString.substring(calString.indexOf("\\n")+2);

                if(delimeter.contains("d")){
                    delimeters = delimeter.split("d");
                }
                //System.out.println(" delesize " + delimeters.length);

            } catch (Exception e) {
                throw e;
                //System.out.println(" Exception Occurred : "+e.getMessage());
                //return 0;
            }
            
           // System.out.println("dele "+delimeter + " "+calString);
        }

        if (delimeters.length > 1){
            String tempDelimeter = delimeters[0];
            calString = calString.replace("\\n",tempDelimeter);

            for(int i = 1; i < delimeters.length; i++){
                //if()
                tempDelimeter += "|"+delimeters[i];
            }
            delimeter = tempDelimeter;
        }else
            calString = calString.replace("\\n",delimeter);

        // 
        delimeter = delimeter.replace("+","\\+");
        delimeter = delimeter.replace("*","\\*");
        delimeter = delimeter.replace("^","\\^");

        //System.out.println("dele: "+delimeter);
        //System.out.println("Cal: "+calString);

        String[] arr = calString.split(delimeter);
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

