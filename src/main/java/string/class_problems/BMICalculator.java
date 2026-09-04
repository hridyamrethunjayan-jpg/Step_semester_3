package string.class_problems;

import java.util.Scanner;

class BMICalculator{
    static String getBmiStatus(double bmi){
        if(bmi<18.5)
            return "Underweight";
        else if(bmi<25)
            return "Normal";
        else if(bmi<30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] heights,double[] weights){
        for(int i=0;i<heights.length;i++){
            double bmi=weights[i]/(heights[i]*heights[i]);

            System.out.printf("Person %d | Height: %.2f | Weight: %.2f | BMI: %.2f | Status: %s%n",
                    i+1,heights[i],weights[i],bmi,getBmiStatus(bmi));
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n=in.nextInt();

        double[] heights=new double[n];
        double[] weights=new double[n];

        for(int i=0;i<n;i++){
            System.out.print("Enter height for Person "+(i+1)+": ");
            heights[i]=in.nextDouble();

            System.out.print("Enter weight for Person "+(i+1)+": ");
            weights[i]=in.nextDouble();
        }

        printWellnessReport(heights,weights);
    }
}