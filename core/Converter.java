package core;

public class Converter {
    //すべてのアルファベットが格納された、比較用のchar型配列
    private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    //文字列を対応する数値に変換するメソッド
    public int[] siconv(String target){
        char[] targetCharArray = target.toCharArray(); //数値に変換しやすいよう、文字列をchar型配列に変換
        int[] result = new int[targetCharArray.length]; //変換した数値を格納する配列

        //char型配列を巡回
        for(int i=0; i<targetCharArray.length; i++){
            //一要素ごとにすべてのアルファベットと比較
            for(int j=0; j<26; j++){
                if(targetCharArray[i]==alphabet[j]){
                    result[i] = j;
                }
            }
        }
        return result;
    }

    //数値を対応する文字に変換
    public char icconv(int index){
        return alphabet[index];
    }
}