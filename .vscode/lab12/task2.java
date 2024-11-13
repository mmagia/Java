import java.io.*;
public class task2 {
    public static void main(String[] args) {
        Throwable firstException = null;
        String[] numbers = {};
        try(FileInputStream in = new FileInputStream("input.txt");
        FileOutputStream out = new FileOutputStream("output.txt"))
        {
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            String sep = new String(buffer);
            numbers = sep.split(" ");
            if(numbers.length!=2){
                throw new WrongAmountOfArgException();
            }
        } catch(IOException ex){
        System.out.println(ex.getMessage());
        } catch(WrongAmountOfArgException ex){
            firstException = ex;
            System.out.println(ex.getMessage());
        } finally{
            try{
                boolean test = check_valid(numbers);
                if(!(test))
                {
                    throw new NotIntegerExpection();
                }
    
                if(Double.parseDouble(numbers[1]) == 0.0){
                    throw new ArithmeticException("Division by zero!");
                }
    
                else{
                    double answer = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                    System.out.println(answer);
                }
            }
            catch(NotIntegerExpection ex){
                if (firstException != null){
                    ex.addSuppressed(firstException);
                }
                System.out.println(ex.getMessage());
                throw ex;
            }
            catch(ArithmeticException ex){
                if (firstException !=null){
                    ex.addSuppressed(firstException);
                }
                System.out.println(ex.getMessage());
                throw ex;
            }
        }
        
    }

    public static class NotIntegerExpection extends NullPointerException{
        public NotIntegerExpection(){
            super("Invalid inputs, insert only integers!");
        }
    }

    public static class WrongAmountOfArgException extends Exception{
        public WrongAmountOfArgException(){
            super("Wrong amount of inputs!");
        }
    }

    public static boolean check_valid(String[] array){
        boolean flag = true;
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array[i].length(); j++){
                if (!(array[i].charAt(j)>='0' && array[i].charAt(j)<='9')){
                    flag = false;
            }
            }
        }
        return flag;
    }
}
