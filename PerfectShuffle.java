package magicOfPerfectShuffles;

import java.util.ArrayList;
import java.util.Arrays;

public class PerfectShuffle {
	
	private int[] deck;

	public PerfectShuffle(int deckSize) {
		
		deck = new int[deckSize];
		
		for(int i = 0; i < deckSize; i++){
			deck[i] = i;
		}
	}
	
	public int[] inShuffle(int[] input){
		
 		int[] topDeck = Arrays.copyOfRange(input, 0, input.length / 2);
		int[] bottomDeck = Arrays.copyOfRange(input, input.length / 2, input.length);
		int[] singleInShuffledDeck = new int[input.length];
		
		// put the bottom numbers in the new shuffled deck
		for(int i = 2; i <= input.length; i += 2){
			
			singleInShuffledDeck[i - 2] = bottomDeck[(i-2) / 2];
			
		}
		// put the top numbers in the new shuffled deck
		for(int i = 2; i <= input.length; i += 2){
			
			singleInShuffledDeck[i - 1] = topDeck[(i-1) / 2];
			
		}
		
		return singleInShuffledDeck;
		
	}
	
	public int[] outShuffle(int[] input){
			
			int[] topDeck = Arrays.copyOfRange(input, 0, input.length / 2);
			int[] bottomDeck = Arrays.copyOfRange(input, input.length / 2, input.length);
			int[] singleOutShuffledDeck = new int[input.length];
			
			// put the top numbers in the new shuffled deck
			for(int i = 2; i <= input.length; i += 2){
				
				singleOutShuffledDeck[i - 2] = topDeck[(i-2) / 2];
				
			}
			// put the bottom numbers in the new shuffled deck
			for(int i = 2; i <= input.length; i += 2){
				
				singleOutShuffledDeck[i - 1] = bottomDeck[(i-1) / 2];
				
			}
			
			return singleOutShuffledDeck;
			
	}
	
	public int perfectInShuffle(){
		
		int numberOfShuffles = 1;
		
		int[][] shuffles = new int[][]{inShuffle(deck)};
		
		int i = 0;
		
 		while(!Arrays.equals(deck, shuffles[i])){
 			shuffles = Arrays.copyOf(shuffles, shuffles.length + 1);
 			shuffles[i+1] = inShuffle(shuffles[i]);
			i++;
			numberOfShuffles++;
		}
				
		return numberOfShuffles;
		
	}
	
	public int perfectOutShuffle(){
		
		int numberOfShuffles = 1;
		
		int[][] shuffles = new int[][]{outShuffle(deck)};
		
		int i = 0;
		
 		while(!Arrays.equals(deck, shuffles[i])){
 			shuffles = Arrays.copyOf(shuffles, shuffles.length + 1);
 			shuffles[i+1] = outShuffle(shuffles[i]);
			i++;
			numberOfShuffles++;
		}
				
		return numberOfShuffles;
		
	}
	
	public int[] moveTopCard(int pos){
		
		String binaryStr = Integer.toBinaryString(pos);
	
		String[] binaryArr = binaryStr.split("");
		
		int[] shuffledDeck = new int[1];
		
		for(int i = 0; i< binaryArr.length; i++) {
			
			int binary = Integer.parseInt(binaryArr[i]);
			
			// if it is the first shuffle
			if(i == 0){
				if(binary == 0)
					shuffledDeck = outShuffle(deck);
				else
					shuffledDeck= inShuffle(deck);
			}
			else{
				if(binary == 0)
					shuffledDeck = outShuffle(shuffledDeck);
				else
					shuffledDeck = inShuffle(shuffledDeck);
			}
							
		}		
		
		return shuffledDeck;
	}

}
