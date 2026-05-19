package com.mycompany.treedistances;
import java.io.*;
import java.util.*;
public class Main {
    
    static ArrayList<Integer>[] arbol;
    static int nodoMasLejano;
    static int[] busqueda (int inicio, int n){
        
        boolean[] visitado = new boolean[n+1];
        
        int[] distancia = new int[n+1];
        
        Queue<Integer> cola = new LinkedList<>();
        
        cola.add(inicio);
        
        visitado[inicio] = true;
        
          nodoMasLejano = inicio;

        while (!cola.isEmpty()) {

            int nodo = cola.poll();

            for (int siguiente : arbol[nodo]) {

                if (!visitado[siguiente]) {

                    visitado[siguiente] = true;

                    distancia[siguiente] = distancia[nodo] + 1;

                    cola.add(siguiente);

                    if (distancia[siguiente] > distancia[nodoMasLejano]) {
                        nodoMasLejano = siguiente;
                    }
                }
            }
        }

        return distancia;
    }
    public static void main(String[] args) throws Exception{
        
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
        arbol = new ArrayList[n + 1];
        
        for (int i = 1; i<=n; i++){
            arbol[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
            
            arbol[a].add(b);
            arbol[b].add(a);
        }
       busqueda(1, n);
       
       int extremoA = nodoMasLejano;

        int[] distanciaA = busqueda(extremoA, n);

        int extremoB = nodoMasLejano;

        int[] distanciaB = busqueda(extremoB, n);

        StringBuilder respuesta = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            int maxima = Math.max(distanciaA[i], distanciaB[i]);

            respuesta.append(maxima).append(" ");
        }

        System.out.println(respuesta);
    }
}
