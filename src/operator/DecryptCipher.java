package operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import core.Converter;
import core.Processor;

//鍵をもとに復号する
public class DecryptCipher {
    public static void main(String[] args) throws IOException {
        //入力受付
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter ciphertext. (English capital letters)");
        String cipher=buf.readLine();
        System.out.println();

        System.out.println("Enter keyword. (English capital letters)");
        String key=buf.readLine();
        System.out.println();

        System.out.println("Below is the plaintext.");
        //アルファベットを数字に置き換え
        Converter conv=new Converter();
        int[] cipherIntArr = conv.siconv(cipher);
        int[] keyIntArr = conv.siconv(key);

        //Processorクラスのdecryptを使い、入力したカギをもとに暗号文を復号
        Processor decrypter = new Processor();
        decrypter.decrypt(cipherIntArr,keyIntArr);
    }
}

/*
 * VSDQEVTAAVBJPACJAGHKHPZHM
 * TERMINATOR
 */