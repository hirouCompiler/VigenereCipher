package operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import core.Processor;
import core.Converter;

//暗号文と平文に含まれる単語のヒントをもとに、鍵を探し出す
public class SearchKey {
    public static void main(String[] args) throws IOException {
        //入力受付
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter cipher text. (English capital letters)");
        String cipher=buf.readLine();
        System.out.println();

        System.out.println("Enter the words contained in the plain text. (English capital letters)");
        System.out.println("Note, must be longer than the key.");
        String hint=buf.readLine();
        System.out.println();

        System.out.println("Of the multiple lines presented, the correct answer is one.");
        System.out.println("The key is looped in the correct row.");
        System.out.println();

        //アルファベットを数字に置き換え
        Converter conv=new Converter();
        int[] cipherIntArr = conv.siconv(cipher);
        int[] hintIntArr = conv.siconv(hint);


        //Decrypterクラスのsearchを使い、暗号文の先頭から順に、平文に含まれる単語を繰り返し引く。
        Processor processor = new Processor();
        processor.search(cipherIntArr,hintIntArr);
    }
}

/*
 *VSDQEVTAAVBJPACJAGHKHPZHM
 *WITHMEIFYOU
 */
