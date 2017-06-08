package magicOfPerfectShuffles;

import java.util.Arrays;

public class MainDriver {

	public static void main(String[] args) {
		PerfectShuffle s = new PerfectShuffle(52);
		
		System.out.println(s.perfectInShuffle());
		System.out.println(s.perfectOutShuffle());
		
		System.out.println(Arrays.toString(s.moveTopCard(14)));
		System.out.println(Arrays.toString(s.moveTopCard(4)));
		
		/*       Expected output

		52
		8
		[19, 9, 39, 29, 6, 49, 26, 16, 46, 36, 13, 3, 33, 23, 0, 43, 20, 10, 40, 30, 7, 50, 27, 17, 47, 37, 14, 4, 34, 24, 1, 44, 21, 11, 41, 31, 8, 51, 28, 18, 48, 38, 15, 5, 35, 25, 2, 45, 22, 12, 42, 32]
		[26, 6, 39, 19, 0, 33, 13, 46, 27, 7, 40, 20, 1, 34, 14, 47, 28, 8, 41, 21, 2, 35, 15, 48, 29, 9, 42, 22, 3, 36, 16, 49, 30, 10, 43, 23, 4, 37, 17, 50, 31, 11, 44, 24, 5, 38, 18, 51, 32, 12, 45, 25]

		*/

	}

}
