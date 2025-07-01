package operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import core.Decrypter;
import core.Converter;

//鍵をもとに暗号文を解く
public class EncryptText {
    public static void main(String[] args) throws IOException {
        //入力受付
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("暗号文を入力してください(大文字)");
        String cipher=buf.readLine();

        System.out.println("鍵を入力してください(大文字)");
        String key=buf.readLine();


        //アルファベットを数字に置き換え
        Converter conv=new Converter();
        int[] cipherIntArr = conv.siconv(cipher);
        int[] keyIntArr = conv.siconv(key);

        //Decrypterクラスのdecryptを使い、入力したカギをもとに暗号文を復号
        Decrypter decrypter = new Decrypter();
        decrypter.decrypt(cipherIntArr,keyIntArr);
    }
}

/*
AYETWFMBWGXAXRMBW
SYSTEM

CIPGRGPBLVPPJQPHH
JOHO
 */
