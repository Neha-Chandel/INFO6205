package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.graphs.BFS_and_prims.StdRandom;

import java.util.Scanner;

public class UPair_Client {
    public static int o;

    public static int objects(int o){
        UPair_Client.o = o;
        UF_HWQUPC ufObject = new UF_HWQUPC(o);
        int p = 0;
        while(ufObject.components()>1){
            int a= StdRandom.uniform(o),b=StdRandom.uniform(o);//Using uniform distribution for generating random numbers (a,b).
            if(!ufObject.isConnected(a,b)){//Checking the connection between both the components.
                ufObject.union(a,b);//Performing union in case they are not connected.
            }
            p++;
        }
        return p;
    }

    public static void main() {
        main();
    }

    public static void main(String... args){
        Scanner scan = new Scanner(System.in);//Implementing command line input from scanner class
        System.out.print("Enter the Initial Number of Sites(o): ");
        int sites=scan.nextInt();
        int trails=30;//Taking 30 to be the number of trails performed.
        for(int i=sites;i<100000;i+=i){//using doubling method to get the average number of pairs required to reduce the components to one
            double sum=0;
            for (int j=0;j<trails;j++){
                sum+=objects(i);
            }
            System.out.println("Number of objects taken (o): " + i + ", Number of pairs generated (p) :" + sum/trails);//computing the averages of the trails
        }
    }
}