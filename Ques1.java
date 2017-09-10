/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digicred;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 500038499  Nimish Srivastava
 */
public class Ques1 {

    /**
     * @param A1
     * @param B1
     * @param C1
     * @param X1
     * @param Y1
     * @return 
     */
    public static int selectRider(int A1[],int B1[],int C1[],int X1[],int Y1[]) { 
        
        int ab = Math.abs((B1[1]-A1[1])) + Math.abs((B1[0]-A1[0])); // distance from A to B
        int ac = Math.abs((C1[1]-A1[1])) + Math.abs((C1[0]-A1[0])); //distance between a to c
        int acxb = ac + Math.abs((X1[1]-C1[1])) + Math.abs((X1[0]-C1[0])) + Math.abs((B1[1]-X1[1])) + Math.abs((B1[0]-X1[0])); //Distace from A to C to X to B
        int acyb = ac + Math.abs((Y1[1]-C1[1])) + Math.abs((Y1[0]-C1[0])) + Math.abs((B1[1]-Y1[1])) + Math.abs((B1[0]-Y1[0])); ////Distace from A to C to Y to B
        int ret=0;
        if (acxb <= 2*ab && acyb <= 2*ab){ //if both nodes, X and Y, dont end up making the final distance twice of the original distance 
            if(acxb<=acyb){ //return 1 if ACXB dstance is less than ACYB dstance
                ret=1;
            }
            else ret=2;
        }
        else if (acxb <= 2*ab && acyb > 2*ab) ret=1; //if X node maked the distance less than twice of original, but Y node makes it greater, select X
        else if(acxb > 2*ab && acyb <= 2*ab) ret=2; //if Y node maked the distance less than twice of original, but X node makes it greater, select Y
        else ret=-1; 
        return ret;
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here        
        Scanner sc = new Scanner(System.in);
        int[] A = new int[2]; //array to store first pickup point
        int[] B = new int[2]; //array to store drop point
        int[] C = new int[2]; //array to store point where pickup request are recieved 
        int[] X = new int[2]; //array to store pickup of 'X'(recieved before Y)
        int[] Y = new int[2]; //array to store pickup location of 'Y'
        try{
        System.out.println("enter first pickup point (A)");
        A[0] = sc.nextInt(); //x coordinate of A
        A[1] = sc.nextInt(); //y coordinate of A
        System.out.println("enter drop point (B)");
        B[0] = sc.nextInt(); //x coordinate of A
        B[1] = sc.nextInt(); //y coordinate of A
        System.out.println("enter location of cab where new request is recieved (C)");
        C[0] = sc.nextInt(); //x coordinate of A
        C[1] = sc.nextInt(); //y coordinate of A
        System.out.println("enter pickup point of first new request (X)");
        X[0] = sc.nextInt(); //x coordinate of A
        X[1] = sc.nextInt(); //y coordinate of A
        System.out.println("enter pickup point of second new request (Y)");
        Y[0] = sc.nextInt(); //x coordinate of A
        Y[1] = sc.nextInt(); //y coordinate of A
        } catch (Exception e) {
            System.out.println("please enter only integer values");
            Runtime.getRuntime().exec("java -jar myApp.jar");
            System.exit(0);
        }
        int sel = selectRider(A, B, C, X, Y);
        System.out.println("1: accept first request, 2: accept second request, -1: dont accept any request");
        System.out.println(sel);
    }
}
