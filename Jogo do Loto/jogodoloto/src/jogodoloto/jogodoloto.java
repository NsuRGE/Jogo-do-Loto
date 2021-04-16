package jogodoloto;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class jogodoloto {
boolean certo[][];
int Cartao[][];
public jogodoloto() {
    certo = new boolean[3][9];
    Cartao = new int[3][9];
    
    Random rand = new Random();
    for(int i = 0; i< Cartao.length; i++){
        for(int j = 0; j< 5; j++){
            int x = rand.nextInt(89) + 1;
            while(Cartao[i][x / 10] !=0) {
                x = rand.nextInt(89) + 1;
            }  
            Cartao[i][x / 10] = x;
        }
    }
}

public boolean tentativa(int row, int col, int numero) {
    if(Cartao[row][col] == numero) {
        certo[row][col] = true;
        return true;
    }
    return false;
}

public boolean Acabou() {
    for(boolean[] arr:certo) {
        for(boolean tentativa: arr) {
            if(!tentativa) 
                return false;
        }
    }
    return true;
}

public int getNumero(int row, int col) {
    return Cartao[row][col];
}

public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int row = 0; row < Cartao.length; row++) {
        for(int col = 0; col < Cartao[row].length; col++) {
            if(certo[row][col])
                sb.append(Cartao[row][col] + " ");
            else
                sb.append("X ");

        }
        
        sb.append("\n");
    }
    return sb.toString();
}

public static void main(String[] args) {
    jogodoloto cartao = new jogodoloto(); 
    
    Scanner sc = new Scanner(System.in);
    while(!cartao.Acabou()) { 
        System.out.println("Fila (1-3):");
        int row = sc.nextInt();
        System.out.println("Coluna (1-9):");
        int col = sc.nextInt();
        System.out.println("Numero:");
        int numero = sc.nextInt();
        if(cartao.tentativa(row, col, numero))
            System.out.println("Acertaste!");
        else
            System.out.println("Tenta outra vez!");
        System.out.println(cartao);
    }
    System.out.println("Ganhaste!");
    sc.close();
  }

}
