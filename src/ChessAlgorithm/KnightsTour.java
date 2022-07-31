/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAlgorithm;

import static java.lang.System.exit;

/**
 *
 * @author ADMIN
 */
public class KnightsTour {
    
    private static KnightsTour instance;

    public static KnightsTour Instance(){
        if(instance == null){
            instance = new KnightsTour();
        }
        return instance;
    }
    
    int x, y; 
    int n=8;
    int move, dem;
    int A[][] = new int[8][8];
    boolean check=false;
    int amountSolu=0;
    public static int e=0;
    
    int[] X = {-2, -2, -1, -1 ,1, 1, 2, 2};
    int[] Y = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    boolean OK(int x, int y){
	return (x>=0 && x<n && y>=0 && y<n && A[x][y]==0);
    }
    
    void Try(int x, int y, int move){
        int i, j, z;
	A[x][y] = move;
        
        for(i=0; i<8; i++){
            if(move == n*n){
                Interface.Instance().receiveKnight(A, n);
                move=0;
                check = true;
		amountSolu++;
                for(j=0; j<n; j++){
                    for(z=0; z<n; z++)
                        dem++;
                }
            }
            int u = x + X[i];
            int v = y + Y[i];
            if(amountSolu==20){
                break;
            }
            if(OK(u, v)){
		Try(u, v, move+1);
            }
	}
	--move;
	A[x][y] = 0;
    }
    
    boolean SolveKnight(int n, int x, int y){
        check = false;
        this.n = n;
        this.move = 1;
        this.amountSolu=0;
        e+=1;
        Interface.Instance().resetdem();
        Try(x, y, move);
        return check;
    }
}
