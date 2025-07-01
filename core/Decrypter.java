package core;

public class Decrypter {
    Converter conv = new Converter();

    //平文に含まれる単語をもとに鍵を探すメソッド
    public void search(int[] cipherText,int[] shiftPhrase) {
        int times = cipherText.length - shiftPhrase.length + 1; //単語をずらして処理する回数
        int result; //暗号文と単語の差分を記録する変数
        int num = 0; //暗号文の何文字目を処理しているか

        //単語の位置をずらして複数回処理
        for (int i = 0; i < times; i++) {
            //単語の先頭から終わりまで、繰り返し処理
            for (int j = 0; j < shiftPhrase.length; j++) {
                num = i + j;
                if (cipherText[num] >= shiftPhrase[j]) {
                    result = cipherText[num] - shiftPhrase[j]; //暗号文のほうが単語より大きい場合
                    System.out.print(conv.icconv(result));
                } else {
                    result = cipherText[num] - shiftPhrase[j] + 26; //暗号文のほうが小さければ、アルファベットの数26だけ足す
                    System.out.print(conv.icconv(result));
                }
            }
            System.out.println();
        }
    }

    //鍵をもとに暗号文を復号するメソッド
    public void decrypt(int[] cipherText, int[] shiftPhrase) {
        int result; //暗号文と鍵の差分を記録するための配列

        //暗号文の中を巡回して処理
        for (int i = 0; i < cipherText.length; i++) {
            int count = i % shiftPhrase.length; //鍵の何文字目で復号しているか

            if (cipherText[i] >= shiftPhrase[count]) {
                result = cipherText[i] - shiftPhrase[count]; //暗号文のほうが鍵より大きい値の場合
            } else {
                result = cipherText[i] - shiftPhrase[count] + 26; //暗号文のほうが小さければ、アルファベットの数26だけ足す
            }
            System.out.print(conv.icconv(result));
        }
    }
}