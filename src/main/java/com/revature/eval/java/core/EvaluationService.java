package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String tmpPhrase = phrase;
		String acronymTLA ="";
		//Go through the string, if we find space or - we take the next word in a new variable
		
		acronymTLA += tmpPhrase.toUpperCase().charAt(0);
		
		 for(int i=1; i <= tmpPhrase.length() -1 ; i++)
		 {
			 if (tmpPhrase.charAt(i-1 ) == ' ' || tmpPhrase.charAt(i-1 ) == '-') {
				 acronymTLA += tmpPhrase.toUpperCase().charAt(i);
			}
			 
			 
		 }
		
		 System.out.println("Acronym: "+acronymTLA+" for "+tmpPhrase);
	
		
		
		return acronymTLA;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		String phrase = string;
		phrase = phrase.toUpperCase();	
		int score =0;
		
		for (int i = 0; i < phrase.length(); i++) {
			
			switch (phrase.charAt(i)) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
			score +=1;
			break;
			
			case 'D':
			case 'G':
			score +=2;
			break;
			
			case 'B':
			case 'C':
			case 'M':
			case 'P':
			score += 3;
			break;
			
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
			score += 4;
			break;
			
			case 'K':
			score += 5;
			break;
			
			case 'J':
			case 'X':
			score += 8;
			break;
			
			case 'Q':
			case 'Z':
			score +=10;
			break;
		
			default:
			break;
			}
			
		}	
		
		System.out.println("Score: "+score);
		return score;
	}
	

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		
		// \\D matches only digits 
		String newPhone = string.replaceAll("\\D+", "");
		
		
		if (newPhone.length() <= 10) {
			
			if (newPhone.length() == 10) {
				System.out.println("Valid number: "+newPhone);
			} else {
				
				System.err.println("Invalid input with no numeric" + string);
			}
			
		} else {
			System.err.println("Invalid more than 10 numbers "+newPhone);
		}
		
		return newPhone;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		//We will use a hasMap to store each word as the key and their occurrence as the value 
		//split the string by spaces
		String [] word;
		//= string.split(",\n");
		
		//if we receive ,\n we split the string
		if (string.contains(",\n")) {
			word = string.split(",\n");
		//if we receive , we split the string
		} else if (string.contains(",")){

			word = string.split(",");
			
		//otherwise we split the string when we find space
		}else {
			word = string.split(" ");
		}
		
		Map<String, Integer> wordOccurrence = new HashMap<>();
		Integer count=0;
		//Loop the array
		for (int i = 0; i < word.length; i++) {
			//get the element from the map, the first time should be null as we did not add the elements to the map yet
			count = wordOccurrence.get(word[i]);
			//Check if it already exist, I will not exist the first time
			if (wordOccurrence.get(word[i]) ==  null) {
				
				//if it does not exist, we set the count as 1
				wordOccurrence.put(word[i], 1);
					
			} else {
				//if already exist, increment the count and add it in the map with put
				count++;
				wordOccurrence.put(word[i], count);
			}			
		}
		
		
	System.out.println(wordOccurrence);
		
		
		return wordOccurrence;
	}
	

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			System.out.println("t value : "+t);
				
			//get the middle element
			int midValue= sortedList.size()/2; 
			//get the last element
			int endValue =sortedList.size()-1;
			//get the first element 
			int begValue = sortedList.indexOf(0);
			
			for (int i = 0; i < sortedList.size(); i++) {
				//conditional for each test
				 if (sortedList.get(midValue) == t) {
					 System.out.println(midValue);
						return midValue;
					}
					else if(sortedList.get(sortedList.size()-1) == t) {
						System.out.println(endValue);
						return endValue;
					}else if (sortedList.get(1) == t)
					{
						System.out.println(begValue);
						return begValue;
					}
					
					else if(sortedList.get(i).equals(t))
					{
						System.out.println(sortedList.get(i));
						
						return sortedList.indexOf(sortedList.get(i));
					}
			}
	
			
			return 0;
		}
		
		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		/* This works for 2 and 3 numbers, fail with 1 and 4
		 * 	int number = input;
		int cubeSum = 0;
		int one;
		
		
		while (number > 0) {
			
			one=number % 10;
			cubeSum = cubeSum + one*one*one;
			number = number/10;
			
		}
		
			if (input == cubeSum) {
				System.out.println("It is an Armstrong number");
				return true;
			} else {
				System.out.println("It is not an Armstrong number");
				return false;
			}
				*/
		
		
					int n = input;
			List<Integer> listOfDigits = new ArrayList<Integer>();
			
			// to find digit and putting in list
			while (input > 0) {
				 
				System.out.println("actual number "+input % 10);
			    listOfDigits.add(input % 10);
			    input = input / 10;
			}
			
			System.out.println(listOfDigits	);
			Long sum = 0L;
			for (Integer integer : listOfDigits) 
			    //sum += (Long) Math.round(Math.pow(integer, listOfDigits.size()));
				sum += (Long) Math.round(Math.pow(integer, listOfDigits.size()));
			
	
			return sum.intValue() == n ? true : false;
			
					//return false;
		
						
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		long number =l;
		List<Long> primerFactor = new ArrayList<>();
		
		if (number == 1) {
			System.out.println("1 is not prime number");
			return null;
		}
		else if(number == 2)
		{
			primerFactor.add(number);
			System.out.println(number);
			return primerFactor;
		}
		else {
			for (long i = 2; i <= number; i++) {
				while (number % i == 0) {
				System.out.println(number);
				System.out.println(i+" ");
				primerFactor.add(i);
				number = number/i;				
				}
			}
		}
		
		return primerFactor;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			String clearText = string;
			String cipherText = "";
	        for(Character c: clearText.toLowerCase().toCharArray()) {
	            if(cipherText.length() % 6 == 5)
	                cipherText += " ";
	            cipherText += cipher(c);
	        }
	        //trim() removes whitespace
	        return cipherText.trim();
			
		}

		private static String cipher(Character c) {
	        if('0' <= c && c <= '9')
	            return String.valueOf(c);
	        else if ('a' <= c && c <= 'z')
	            return String.valueOf((char) (219 - (int) c));
	        else
	            return "";
	    }
		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			String ciperText =string;
			String clearText = "";
	        for(Character c: ciperText.toLowerCase().toCharArray())
	            clearText += cipher(c);
	        return clearText;
			
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		//Split the string and use the index
		int operation=0;
		int n1,n2;
		String removing;
		String [] array = string.split(" ");
		
		if (string.contains("plus")) {
			
			removing= array[4].replace("?", "");
			//Converting from string to int
			n1 = Integer.parseInt(array[2]);
			n2 = Integer.parseInt(removing);
			
			operation=(n1)+(n2);
			System.out.println(operation);
			return operation;
		}
		else if(string.contains("minus"))
		{
			removing= array[4].replace("?", "");
			//Converting from string to int
			n1 = Integer.parseInt(array[2]);
			n2 = Integer.parseInt(removing);
			
			operation=(n1)-(n2);
			System.out.println(operation);
			return operation;
		}
		else if(string.contains("multiplied"))
		{
			removing= array[5].replace("?", "");
			//Converting from string to int
			n1 = Integer.parseInt(array[2]);
			n2 = Integer.parseInt(removing);
			
			operation=(n1)*(n2);
			System.out.println(operation);
			return operation;
		}
		else if(string.contains("divided"))
		{
			removing= array[5].replace("?", "");
			//Converting from string to int
			n1 = Integer.parseInt(array[2]);
			n2 = Integer.parseInt(removing);
			
			operation=(n1)/(n2);
			System.out.println(operation);
			return operation;
		}
		else {
			System.out.println("Operation not identified");
		}
		
		
		
		return 0;
	}

}
