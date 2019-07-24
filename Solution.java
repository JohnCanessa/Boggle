
/*
 * 
 */
public class Solution {
	
	// **** number of rows and columns (4 x 4 matrix) ****
	static final int	BOGGLE_LEN	= 4;

	/*
	 * Search for the string starting at the specified location.
	 */
	static int	search(char[][] boggle, String str, int row, int col) {
		
		int count = 0;
		
		// ???? ????
//		System.out.println("search <<< str ==>" + str + "<== row: " + row + " col: " + col);
		
		// **** end condition ****
		if (str.length() == 0) {
			return 1;
		}
		
		// **** check right ****
		if (row < BOGGLE_LEN) {
			count = search(boggle, str.substring(1, str.length()), row + 1, col);
		}
		
		// **** check down down ****
		if (col < BOGGLE_LEN) {
			count = search(boggle, str.substring(1, str.length()), row, col + 1);
		}
		
		// **** check left ****
		if (col > 0) {
			count = search(boggle, str.substring(1, str.length()), row, col - 1);
		}
		
		// **** check up ****
		if (row > 0) {
			count = search(boggle, str.substring(1, str.length()), row - 1, col);			
		}
		
		// **** ****
		return count;
	}
	
	/*
	 * 
	 */
	static int countInstances(char[][] boggle, String str) {
		
		int count	= 0;
		
		int rows = boggle.length;
		int cols = boggle[0].length;
		
		// ???? ????
//		System.out.println("countInstances <<< rows: " + rows + " cols: " + cols);
		
		// **** search starting at the specified location ****
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				
				// ???? ????
//				System.out.println("countInstances <<< r: " + r + " c: " + c);
				
				// **** ****
				if (boggle[r][c] == str.charAt(0))
					count += search(boggle, str.substring(1,  str.length()), r, c);
			}
		}
		
		// **** ****
		return count;
	}
	
	/*
	 * Test scaffolding
	 */
	public static void main(String[] args) {

		// **** matrix holding the boggle letters ****
		char boggle[][]	= 	{
							{ 'P', 'L', 'E', 'L'},
							{ 'G', 'A', 'G', 'E'},
							{ 'E', 'L', 'I', 'O'},
							{ 'M', 'C', 'F', 'J'}
							};
		
		// **** string to search for ****
		String str	= "LEGAL";
				
		// **** count number of occurrences of the specified string ****
		int count = countInstances(boggle, str);
		System.out.println("main <<< count: " + count);
	}

}
