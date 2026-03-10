package leetcode.array_hashing;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    public String encode(List<String> strs) {
        String res = "";
        for (String str:strs){
            int size = str.length();
            res += String.valueOf(size) + '#'+str;
        }

        return res;
    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        String tmpNumber = "";

        if (str.isEmpty()){
            return res;
        }

        for (int i = 0; i < str.length();i++){
            if ( str.charAt(i) == '#'){

                int wordLength = Integer.valueOf(tmpNumber);
                res.add(str.substring(i+1,wordLength+i+1));
                i  = i + wordLength;
                tmpNumber ="";
            }

            else {
                tmpNumber += str.charAt(i);
            }
        }
        return res;
    }
}
