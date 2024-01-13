/*
 * easy come, easy go.
 *
 * contact : syiae.jwy@gmail.com
 *
 * · · · · ||   ..     __       ___      ____  ®
 * · · · · ||  ||  || _ ||   ||    ||   ||      ||
 * · · · · ||  ||  \\_ ||_.||    ||   \\_  ||
 * · · _//                                       ||
 * · · · · · · · · · · · · · · · · · ·· ·    ___//
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *     用来写leetcode代码
 *      TODO  some word
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/10
 */
public class Solution {

    /**
     * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
     *
     *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
     *
     * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
     * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
     *
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int sN = s.length();
        int wordsN = words.length;
        int wordN = words[0].length();
        int mulN = wordsN*wordN;

        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!map.containsKey(word)){
                map.put(word, 0);
            }
            map.put(word, map.get(word)+1);
        }

        for (int i = 0; i < sN; i++) {

            int j = i;
            int times=0;
            Map<String, Integer> tmpMap = new HashMap<>();
            while(j+wordN <= sN && j-i+wordN <= mulN){
                String sub = s.substring(j, j+wordN);
                if(!tmpMap.containsKey(sub)){
                    tmpMap.put(sub, 0);
                }
                tmpMap.put(sub, tmpMap.get(sub)+1);

                if(map.containsKey(sub) && map.get(sub) >= tmpMap.get(sub)){
                    j = j+wordN;
                    times++;
                }else{
                    break;
                }
            }
            if(times == wordsN){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};

        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);

    }


}
