/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digicred;

import java.util.Scanner;

/**
 *
 * @author 500038499  Nimish Srivastava
 */
public class Ques3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of test cases (T)");
        int t= sc.nextInt(); 
        
        //no of test cases
        for (int i=1; i<=t; i++){
            System.out.println("enter number of itmes for list in test case number " + i);
            int n= sc.nextInt();
            int[] L= new int[n];
            System.out.println("Enter elements of list ");
            for (int x=0; x<n; x++){
                L[x]= sc.nextInt();
            }
            System.out.println("Enter 3 integers (A, B, C)");
            int a= sc.nextInt();
            int b= sc.nextInt();
            int c= sc.nextInt();
            
            System.out.println("Enter a string of " + n + "letters");
            char[] S= sc.next().toCharArray();
            ancientAlgo(S, a, b, c, L);
        }
    }
    public static void ancientAlgo(char S1[], int a1, int b1, int c1, int L1[]) {
        //char[] op= new char[S1.length];
        
        for (int i=0; i<=S1.length-1; i++){
            if(S1[i]=='R' || S1[i]=='r'){ //if ith letter is R, reverse the array from i to N
                int n=S1.length;
                for (int x= i; x<(i)+(S1.length-(i))/2 ; x++){
                    int temp= L1[x];
                    L1[x]=L1[n-1];
                    L1[n-1]=temp;
                    n--;
                }

            }
            else if(S1[i]=='A' || S1[i]=='a'){ //if ith element is A, add 'a' to elements from i to N
                for (int x=i; x<=S1.length-1; x++){
                    L1[x]= L1[x]+a1;
                }
            }
            else if(S1[i]=='M' || S1[i]=='m'){ //if ith element is M, multiply b to all elements from i to N
                for (int x=i; x<=S1.length-1; x++){
                    L1[x]= L1[x]*b1;
                }
            }
            else { //for any other letter on ith position, module elements from i to N by C
                for (int x=i; x<=S1.length-1; x++){
                    L1[x]= L1[x]%c1;
                }
            }
            System.out.println("Final list:   "+L1[i]);
        }
    }
}
