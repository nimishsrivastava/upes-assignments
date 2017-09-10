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
public class Ques2 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter total number of riders or total number of requests");
        int n= sc.nextInt();
        int[] readyTime= new int[n];
        int[] cancelTime= new int[n];
        int[] travelTime= new int[n-1];
        for(int i=0; i<readyTime.length; i++){
            int x= i+1;
            System.out.println("enter ready time, cancel time, travel time for request number " + x);
            readyTime[i]= sc.nextInt();
            cancelTime[i]= sc.nextInt();
            //System.out.println("hello");
            if(i<readyTime.length-1){ //don't accept travel time for last rider
                
                travelTime[i]= sc.nextInt();
            //    System.out.println("hello111");
            }
            if (cancelTime[i]<readyTime[i]){ //exit program if this condition occurs
                System.out.println("Cancel time cannot be less than ready time. ");
                System.out.println("minimum Time: -1");
                Runtime.getRuntime().exec("java -jar myApp.jar");
                System.exit(0);
            }
        }
        int res= minTravelTime(travelTime, readyTime, cancelTime);
        if(res>=86400){ //final time cannot be greater than total seconds in a day
            res= -1;
        }
        System.out.println("Minimum time would be: "+res);
    }
    
    public static int minTravelTime(int travelTime[], int readyTime[], int cancelTime[])
    {
        int minTime = 0; //minimum time 
        for(int i=0; i<= readyTime.length-1;i++)
        {
            if(i == readyTime.length-1){
                if(minTime <= readyTime[i]) //cab will have to wait
                {
                    int waitingTime = readyTime[i] - minTime;
                    minTime = minTime + waitingTime;
                }
                else if(minTime>readyTime[i]&& minTime<cancelTime[i]){ //cab will be late but ride will not be cancelled
                    minTime = minTime;
                }
                else
                    minTime = -1;
            }
            else{
                if(minTime <= readyTime[i]) //cab will have to wait
                {
                    int waitingTime = readyTime[i] - minTime;
                    minTime = minTime + waitingTime + travelTime[i];
                }
                else if(minTime>readyTime[i]&& minTime<cancelTime[i])
                    minTime = minTime + travelTime[i];
                else
                    minTime = -1;
            }
        }
        return minTime;
         
    }
}
