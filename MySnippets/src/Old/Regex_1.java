package Old;

import java.util.LinkedHashMap;
import java.util.Map;


public class Regex_1 {

	private static Map<String, String> TEST_DATA = new LinkedHashMap<String, String>();
	
	private static void prepareTestData() {
		//TEST_DATA.put("a*..", "aaa");
		
		TEST_DATA.put("a*", "aab"); 			//0. a*, aab , false
		TEST_DATA.put("ab", "ab"); 				//1. ab, ab , false 
		TEST_DATA.put("a*b", "aaaaaab"); 		//		 2. a*b , aaaaaab , true 
		TEST_DATA.put("a*b*c*", "abc"); 		//		 3. a*b*c*, abc , true 
		TEST_DATA.put("a*b*c", "aaabccc");		//		 4. a*b*c , aaabccc, false
		TEST_DATA.put("^abc*b", "abccccb"); 	//		5. ^abc*b, abccccb , true 
		TEST_DATA.put("^abc*b", "abbccccb"); 	//		6 ^abc*b, abbccccb , false 
		TEST_DATA.put("^abcd$", "abcd"); 		//		7 ^abcd$, abcd , true 
		TEST_DATA.put("^abc*abc$", "abcabc"); 	//		8 ^abc*abc$ , abcabc, true 
		TEST_DATA.put("^abc.abc$", "abczabc"); 	//		9 ^abc.abc$, abczabc , true 
		TEST_DATA.put("^ab..*abc$", "abyxxxxabc"); //		9 ^ab..*abc$, abyxxxxabc, true
	}
	
	public static void main(String[] args) {
		prepareTestData();
		for(Map.Entry<String, String> entry : TEST_DATA.entrySet()) {
			String regex = entry.getKey();
			String testString = entry.getValue();
			boolean result = match(regex, testString);
			System.out.println(regex + ", " + testString + ", " + result);
		}
	}
	
	public static boolean match(String regex, String testString)
	{
	    boolean result = false;
	    if (regex.isEmpty() || testString.isEmpty())
	    {
	        result = false;
	    }
	    else
	    {
	    	int testStringPt = 0;
	    	int regexLen = regex.length();
	    	for(int regexPt = 0; regexPt < regexLen; regexPt++) {
	    		char regexChar = regex.charAt(regexPt);
	    		if(regexChar == '*') {
	    			if(regexPt == 0 || regexPt == (regexLen - 1)) {
		    			result = true;
	    			} else {
	    				char rChar = regex.charAt(regexPt - 1);
	    				if('.' == rChar) {
	    					char nextChar = regex.charAt(regexPt + 1);
	    					if('*' == nextChar && '$' == nextChar && '.' == nextChar){
	    						result = true;
	    					} else {
		    					while(nextChar != testString.charAt(testStringPt)){
			    					result = true;
			    					testStringPt++;
			    				}
	    					}
	    				} else {
		    				while(rChar == testString.charAt(testStringPt)){
		    					result = true;
		    					testStringPt++;
		    				}
	    				}
	    			}
	    		} else if(regexChar == '^') {
	    			char rChar = regex.charAt(regexPt);
    				while('*' != regex.charAt(regexPt+1) && '$' != regex.charAt(regexPt+1) && '.' != regex.charAt(regexPt+1)){
    					if(regexPt+1 < regexLen) {
    						rChar = regex.charAt(++regexPt);
    						if(testString.charAt(testStringPt) == rChar) {
    	    					result = true;
    	    					testStringPt++;
    						} else {
    							result = false;
    							break;
    						}
    					} else {
    						break;
    					}
    				}
	    		} else if(regexChar == '$') {
	    			if(testStringPt != testString.length())
	    				result = false;
	    		} else if(regexChar == '.') {
	    			testStringPt++;
	    			result = true;
	    		} else {
	    			if(regexChar == testString.charAt(testStringPt)) {
	    				testStringPt++;
	    				result = true;
	    			} else {
	    				result = false;
	    				break;
	    			}
	    		}
	    	}
	    	if(testStringPt != testString.length()) {
	    		if(regex.charAt(regexLen-1) != '*') {
	    			result = false;
		    	} else {
		    		char rChar = regex.charAt(regexLen - 1);
    				while(rChar == testString.charAt(testStringPt)){
    					result = true;
    					testStringPt++;
    				}
    				if(testStringPt != testString.length()) {
    					result = false;
    				}
		    	}
	    	}
	    }
	    return result;
	}

}

