package operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import core.Processor;
import core.Converter;

//鍵をもとに暗号化する
public class EncryptText {
    public static void main(String[] args) throws IOException {
        //入力受付
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter plaintext. (English capital letters)");
        String plainText=buf.readLine();
        System.out.println();

        System.out.println("Enter keyword. (English capital letters)");
        String key=buf.readLine();
        System.out.println();

        System.out.println("Below is the ciphertext.");
        //アルファベットを数字に置き換え
        Converter conv=new Converter();
        int[] textIntArr = conv.siconv(plainText);
        int[] keyIntArr = conv.siconv(key);

        //Processorクラスのdecryptを使い、入力したカギをもとに暗号文を復号
        Processor encrypter = new Processor();
        encrypter.encrypt(textIntArr,keyIntArr);
    }
}

/*
 *COMEWITHMEIFYOUWANTTOLIVE
 *TERMINATOR
 */
