import java.util.Arrays;
import java.util.Random;

class Loto {

public static void main(String[] args) {
    int[][] cartao = new int[3][9];

    Random rand = new Random();
    for(int i = 0; i< cartao.length; i++){
        for(int j = 0; j< 5; j++){
            int x = rand.nextInt(89) + 1;
            while(cartao[i][x / 10] !=0) {
                x = rand.nextInt(89) + 1;
            }
            cartao[i][x / 10] = x;
        }
    }

    for(int[] row : cartao){
        System.out.println(Arrays.toString(row));
    }
}
}
