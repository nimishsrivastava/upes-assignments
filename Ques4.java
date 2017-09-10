/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digicred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 500038499 Nimish Srivastava
 */
public class Ques4 {
    static ArrayList<Integer> savedGcd;
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //System.out.println("Enter number of test cases");
        int t= sc.nextInt();
        
        for(int l=1; l<=t; l++){
            savedGcd= new ArrayList<>();
            //System.out.println("enter number of elements of the list: ");
            int n= sc.nextInt();
            //System.out.println("enter " + n + " elements for the list");
            int[] L =new int[n];
            for(int x=0; x<n; x++){
                
                L[x]= sc.nextInt();
            }
            int m = L.length;

            // Run a loop for printing all 2^n
            // subsets one by obe
            for (int i = 0; i < (1<<n); i++)
        {
            //System.out.print("{ ");
            ArrayList<Integer> al= new ArrayList<>();
            // Print current subset
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) > 0){
                  //  System.out.print(L[j] + " ");
                    al.add(L[j]);
                }
            }
            saveGCD(al); 
            //System.out.println("}");
        }
            int temp=1;
            for(int k=0;k<savedGcd.size();k++){
              //  System.out.println(savedGcd.get(k));
                temp*=savedGcd.get(k);
            }
            
            System.out.println(temp);
                
        }   
    }
    
    public static void saveGCD(ArrayList<Integer> al){
        int n=al.size();
        if(n==0){ //if no elements in subset
             savedGcd.add(1);
        return;
        }
        if (n==1){ //if only one element in subset
            savedGcd.add(al.get(0));
            return;
        }
        int m=gcdTwoNum(al.get(0),al.get(1));
        if(n==2){ //for subset of 2 elements
            savedGcd.add(m);
            return;
        }
        else if(n>2){ //for more than two elements
            for(int i=2;i<n;i++)
                m=gcdTwoNum(m,al.get(i)); //GCD of 3 elements, is gdc of gdc of two elements and third element
        }
        savedGcd.add(m);
    }
    public static int gcdTwoNum(int m, int n){ // function to calculate GDC of 2 elements
        if(m==0 || n==0)
            return 0;
        if(m==n)
            return m;
        if(m>n)
            return gcdTwoNum(m-n,n);
        return gcdTwoNum(m,n-m);
    }
    
}
