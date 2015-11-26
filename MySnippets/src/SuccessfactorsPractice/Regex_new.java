public class Regex_new {
	static int expressionIndex = -1;
	static int patternIndex = -1;
	static boolean result = false;

	public static void main(String[] args){
		String regex = "a*..";
		String pattern = "aaaaabc";
		parseRegex(regex,pattern);
		System.out.println(regex + ", " + pattern + ", " + result);		
	}
	
	public static void parseRegex(String regex,String pattern){
		
		char[] exp = regex.toCharArray();
		char[] pat = pattern.toCharArray();
		
		for(int i=0;i<exp.length;i++){
			expressionIndex ++;
			
			if(exp[i]=='*'){
				boolean charResult = handleStar(exp,pat);
				if(! charResult)
					break;
				
			}
			else if(exp[i]=='$'){
				boolean charResult = handleDollar(exp,pat);
				if(! charResult)
					break;
			}
			else if(exp[i]=='^'){
				boolean charResult = handleCaps(exp,pat);
				if(! charResult)
					break;
			}
			else if(exp[i]=='.'){
				boolean charResult = handleDot(exp,pat);
				if(! charResult)
					break;
			}
			else{
				patternIndex ++;
				boolean charResult = handleCharacters(exp,pat);
				if(! charResult)
					break;
			}
		}
		
		if(pattern.length()-1 != patternIndex)
				result = false;
		
	}
	
	protected static boolean handleDollar(char[] exp,char[] pat){
		if(expressionIndex != exp.length-1)
			return false;
		return true;
	}
	
	protected static boolean handleCaps(char[] exp,char[] pat){
		if(expressionIndex != 0 || exp[1]=='*' || exp[1] == '$' || exp[1] =='^')
			return false;
		return true;	
	}
	
	protected static boolean handleCharacters(char[] exp,char[] pat){		
		if(patternIndex < pat.length && expressionIndex < exp.length){
			if(exp[expressionIndex] == pat[patternIndex]){
				result = true;
			}
			else{
				result = false;				
			}
		}
		return result;
	}
	
	protected static boolean handleDot(char[] exp,char[] pat){
		if(patternIndex < pat.length){
			patternIndex ++;
			result = true;
		}
		else{
			result = false;
		}
		return result;
	}
	
	protected static boolean handleStar(char[] exp,char[] pat){
		if(expressionIndex == 0 ){
			patternIndex ++;
			result = true;
		}		
		else if(expressionIndex == exp.length-1) {
			char ch = pat[patternIndex];
			
			while(patternIndex < pat.length-1){				
				patternIndex ++;
				if(pat[patternIndex]!=ch){
					result = false;
					break;
				}
				else
					result = true;
			}
		}
		else{		
			char ch = pat[patternIndex];
			patternIndex ++;
			while(patternIndex < pat.length){			
				if(pat[patternIndex]==ch){
					patternIndex ++;
				}
				else{
					patternIndex --;
					break;
				}
			}
		}
		return result;
	}

}
