package core;

public class Processor {
    Converter conv = new Converter();

    //平文に含まれる単語(ヒント)をもとに鍵を探すメソッド
    public void search(int[] cipherText,int[] hint) {
        int times = cipherText.length - hint.length + 1; //単語をずらして処理する回数
        int result; //暗号文とヒントの差分を記録する変数
        int num = 0; //暗号文の何文字目を処理しているか

        //ヒントの位置をずらして複数回処理
        for (int i = 0; i < times; i++) {
            //ヒントの中で巡回する
            for (int j = 0; j < hint.length; j++) {
                num = i + j;
                if (cipherText[num] >= hint[j]) {
                    result = cipherText[num] - hint[j]; //暗号文の数字がヒントの数字より大きい場合の差分
                    System.out.print(conv.icconv(result));
                } else {
                    result = cipherText[num] - hint[j] + 26; //暗号文のほうが小さければ、アルファベットの数26だけ足してから、差分を求める
                    System.out.print(conv.icconv(result));
                }
            }
            System.out.println();
        }
    }

    //鍵をもとに暗号文を復号するメソッド
    public void decrypt(int[] cipherText, int[] keyWord) {
        int result; //暗号文と鍵の差分を記録するための配列

        //暗号文の中を巡回して処理
        for (int i = 0; i < cipherText.length; i++) {
            int count = i % keyWord.length; //鍵の何文字目で復号しているか

            if (cipherText[i] >= keyWord[count]) {
                result = cipherText[i] - keyWord[count]; //暗号文のほうが鍵より大きい値の場合
            } else {
                result = cipherText[i] - keyWord[count] + 26; //暗号文のほうが小さければ、アルファベットの数26だけ足す
            }
            System.out.print(conv.icconv(result));
        }
    }

    //鍵をもとに平文を暗号化するメソッド
    public void encrypt(int[] plainText, int[] keyWord) {
        int result; //暗号文を記録するための配列

        //暗号文の中を巡回して処理
        for (int i = 0; i < plainText.length; i++) {
            int count = i % keyWord.length; //鍵の何文字目で暗号化しているか

            result = plainText[i] + keyWord[count]; //平文を鍵の分だけずらす
            
            //合計がアルファベットのzである25を超過した場合、26を引く
            if (result > 25) {
            result -= 26; 
            }
            System.out.print(conv.icconv(result));
        }
    }
}