/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAlgorithm;

import static java.lang.Math.abs;
import ChessAlgorithm.Interface.*;

/**
 *
 * @author ADMIN
 */
public class EightQueen {
    
    private static EightQueen instance;

    public static EightQueen Instance(){
        if(instance == null){
            instance = new EightQueen();
        }
        return instance;
    }
    
    int dem=1;
    int a[] = new int[20];
    int n;
    
    boolean OK(int x, int y){
        int i;
        for(i=1; i<x; i++)
            if(a[i]==y || abs(i-x)==abs(a[i]-y))
                return false;
        return true;
    }
    
    void Try(int i){
        int j;
        
        for(j=1; j<=n; j++){
            if(OK(i, j)){
                a[i] = j;
                if(i==n){
                    for(int z=1; z<=n; z++){
                        dem++;
                    }
                    Interface.Instance().receiveQueen(a, n);
                }
                Try(i+1);
            }
        }
    }
    
    void SolveQueen(int n){
        this.dem = 1;
        this.n = n;
        Interface.Instance().resetdem();
        Try(1);
    }
}
