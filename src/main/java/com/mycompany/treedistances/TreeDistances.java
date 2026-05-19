package com.mycompany.treedistances;

import java.util.*;
public class TreeDistances {
    
    static ArrayList<Integer>[] arbol;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arbol = new ArrayList[n + 1];
        
        for (int i = 1; i<=n; i++){
            arbol[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            arbol[a].add(b);
            arbol[b].add(a);
        }
       
    }
}
