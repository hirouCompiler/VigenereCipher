package operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import core.Decrypter;
import core.Converter;

//暗号文と平文に含まれる単語のヒントをもとに、鍵を探し出す
public class SearchKey {
    public static void main(String[] args) throws IOException {
        //入力受付
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("暗号文を入力してください(大文字)");
        String cipher=buf.readLine();

        System.out.println("平文に含まれる文字列を入力してください(大文字)");
        String hint=buf.readLine();


        //アルファベットを数字に置き換え
        Converter conv=new Converter();
        int[] cipherIntArr = conv.siconv(cipher);
        int[] hintIntArr = conv.siconv(hint);


        //Decrypterクラスのsearchを使い、暗号文の先頭から順に、平文に含まれる単語を繰り返し引く。
        Decrypter decrypter = new Decrypter();
        decrypter.search(cipherIntArr,hintIntArr);
    }
}

/*
AYETWFMBWGXAXRMBW
STUDENT

CIPGRGPBLVPPJQPHH
CHIBA
 */
