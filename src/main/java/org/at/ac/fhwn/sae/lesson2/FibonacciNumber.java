package org.at.ac.fhwn.sae.lesson2;

public class FibonacciNumber {
    public static void main(String[] agrs){
        long result1 = getFibonacciNumberRecursive(5);
        System.out.println(result1);
        long result2 = getFibonacciNumberIterative(-1);
        System.out.println(result2);

    }

    /**
     * Gets the fibonacci-number of a given number with a recursive method
     *
     * With an Integer you will receive a StackOverflow/VariableOverflow starting at the number 46. -> False result,
     * because an Integer can not store the amount of the number anymore.
     *
     * The runtime is exponential! O(2^n)! Iterative one is better
     *
     * Negative numbers can't be solved in this method. -> StackOverflowError
     * You have to adapt the code with an if statement for the negative Fibonacci squence
     *
     * @param number the given number as Integer
     * @return the fibonacci-number of the given number as long
     */

    public static long getFibonacciNumberRecursive (int number){
        if (number==0){
            return 0;
        }else if (number==1){
            return 1;
        }else{
            return getFibonacciNumberRecursive(number-1)+getFibonacciNumberRecursive(number-2);

        }
    }

    /**
     * Gets the fibonacci-number of a given number iterative with a for loop
     *
     * Same problem with the Overflow by using Integer and numbers starting at 46 -> solved with long
     *
     * Runtime of 0(1) for the numbers 0 and 1
     * Runtime of O(n) for higher numbers -> faster than recursion
     *
     * Negative numbers can't be solved also! -> else statement -> result= 0 -> no for loop -> return result=0
     *
     * @param number the given number
     * @return the fibonacci-number of the given number
     */
    public static long getFibonacciNumberIterative (int number){
        if(number==0){
            return 0;
        } else if (number==1){
            return 1;
        }else{
            long temp1=0;
            long temp2=1;
            long result = 0;
            for(int i=1;i<number;i++){
                result=temp1+temp2;
                temp1=temp2;
                temp2=result;
            }
            return result;
        }


    }
}
