package 外观与享元模式.Fly;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random rm = new Random();
        PieceFactory pFactory = new PieceFactory();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                Apiece p;
                if(rm.nextInt()%2 == 0){
                    p=pFactory.GetPiece("白棋");
                }
                else{
                    p=pFactory.GetPiece("黑棋");
                }
                p.Play(rm.nextInt(19), rm.nextInt(19));
            }
        }
        System.out.println("总共棋子对象的个数是:"+pFactory.GetPieceCount());
    }
}
