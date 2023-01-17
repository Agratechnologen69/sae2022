package org.at.ac.fhwn.sae.lesson2;

public class Loop {
    public static void main(String[] agrs){
        String monthString;
        int month = 7;

        switch (month){
            case 1: monthString = "January" ;
                break;
            case 2: monthString = "February";
                break;
            case 3: monthString = "March";
                break;
            case 4: monthString = "April";
                break;
            case 5: monthString = "May";
                break;
            case 6: monthString = "June";
                break;
            case 7: monthString = "July";
                break;
            case 8: monthString = "August";
                break;
            case 9: monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default:
                monthString = "Invalid Month";


        }

        System.out.println(monthString);

        for(int i=0;i<10;i++){
            System.out.println(i);
        }

        int i = 0;
        while (i<10){
            System.out.println(i);
            i++;
        }

        do{
            System.out.println(i);
            i--;
        }while (i>-1);

        System.out.println(add(16,4));
        System.out.println(add(12,40,8));

        int[] intArr = new int[10];
        System.out.println(intArr[0]);
        intArr[0]=42;
        intArr[9]=14;

        System.out.println(" FOR EACH");

        for(int value: intArr){
            System.out.println(value);
        }


        System.out.println("Max number:" + getMaxOfBits(8));
    }

    public static int add(int number1, int number2){
        return number1 + number2;
    }

    public static int add(int number1, int number2, int number3) {
        return add(add(number1, number2), number3);
    }

    public static long getMaxOfBitsRecursive(int numberOfBits){
        return getMaxOfBits(1,numberOfBits);
    }
    private static long getMaxOfBits(long number, int numberOfBitsLeft){
        if(numberOfBitsLeft > 0){
            return getMaxOfBits(number*2, --numberOfBitsLeft);
        }
        return number;
    }
    // This is a comment
    /* This is a comment */

    /**
     * Gets the maximum value of a datatype with a given number of bits.
     *
     * @param numberOfBits the number of bits
     * @return the maximum value
     */

    public static long getMaxOfBits(int numberOfBits){
        long result = 1;
        while(numberOfBits>0){
            result*=2; numberOfBits--;
        }
        return result;
    }








}
