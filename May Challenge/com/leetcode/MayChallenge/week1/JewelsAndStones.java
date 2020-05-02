package com.leetcode.MayChallenge.week1;

import java.util.HashMap;
import java.util.stream.Stream;

public class JewelsAndStones {

	public int numJewelsInStones(String J, String S) {
		
		if(J.length() == 0 || S.length() == 0) return 0;
		
		
        HashMap<Character,Integer> cache =  new HashMap<Character, Integer>();
       
        for(int i=0;i<S.length();i++) {
        	char c = S.charAt(i);
        	if(cache.containsKey(c)) {
        		int count = cache.get(c);
        		count++;
        		cache.put(c, count);
        	}
        	else {
        		cache.put(c,1);
        	}
        }
        
        int result=0;
        for(int i=0;i<J.length();i++)
        {
        	char c=J.charAt(i);
        	if(cache.containsKey(c)) {
        		result=result+cache.get(c);	
        	}
        }
        
        return result;
	}

	public static void main(String[] args) {

		String J = "aA", S = "aAAbbbb";
		System.out.println(new JewelsAndStones().numJewelsInStones(J, S));
	}

}
