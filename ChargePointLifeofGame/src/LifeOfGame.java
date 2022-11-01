
public class LifeOfGame {

	public static void main(String[] args) {

		int[][] input = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("After the next Generation");
		lifeOfGame(input);
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void lifeOfGame(int[][] inputBoard) {
		int[][] neighbour = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int length = inputBoard.length;
		int breadth = inputBoard[0].length;

		int[][] nextBoard = new int[length][breadth];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < breadth; j++) {
				int count = 0;
				for (int[] neigh : neighbour) {
					int a = neigh[0] + i;
					int b = neigh[1] + j;
					if (a >= 0 && a < length && b >= 0 && b < breadth && inputBoard[a][b] == 1) {
						count++;
					}
				}

				if (inputBoard[i][j] == 1) {
					if (count == 2 || count == 3) {
						nextBoard[i][j] = 1;
					}
				} else {
					if (count == 3) {
						nextBoard[i][j] = 1;
					}
				}

			}

		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < breadth; j++) {
				inputBoard[i][j] = nextBoard[i][j];
			}
		}

	}

}
