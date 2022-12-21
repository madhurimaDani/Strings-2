/*
 Time Complexity = O(n)  n is length of string s
 Space Complexity = O(1) -> max entries in hashmap will be 26 distinct letters -> so this is constant space.
 Did it run on LeetCode: yes

 */

package com.madhurima;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int match = 0;

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i = 0; i < s.length(); i++){
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)){
                int cnt = map.get(incoming);
                cnt--;
                if(cnt == 0){
                    match++;
                }
                map.put(incoming, cnt);
            }

            if(i >= p.length()){
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)){
                    int cnt = map.get(outgoing);
                    cnt++;
                    if(cnt  == 1){
                        match--;
                    }
                    map.put(outgoing, cnt);
                }
            }

            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }

        return result;

    }
}
