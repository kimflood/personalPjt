package Factorial;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(String.format("%.30s...", FactorialToBigInteger.factorial(FactorialToBigInteger.TWENTY_K)));
        }catch (VirtualMachineError ex){
            System.out.println(ex);
        }

    }
}
