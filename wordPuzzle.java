import java.util.*;

public class WordFindSolver {

    private static final int[][] DIRECTIONS = {
        { 0,  1}, // (East)
        { 0, -1}, // (West)
        { 1,  0}, // (South)
        {-1,  0}, // (North)
        { 1,  1}, // (South-East)
        { 1, -1}, // (South-West)
        {-1,  1}, // (North-East)
        {-1, -1}  // (North-West)
    };

    private static final String[] DIR_NAMES = {
        "Right", "Left", "Down", "Up", "Down-Right", "Down-Left", "Up-Right", "Up-Left"
    };

    public static void solveWordFind(char[][] grid, String[] words) {
        int n = grid.length;

        for (String word : words) {
            boolean found = false;

            if (word.length() > n) {
                System.out.println("Word '" + word + "' is too long (exceeds grid size without cell reuse).");
                continue;
            }

            for (int r = 0; r < n && !found; r++) {
                for (int c = 0; c < n && !found; c++) {
                    if (grid[r][c] == word.charAt(0)) {
                        
                        for (int d = 0; d < 8; d++) {
                            if (checkWord(grid, word, r, c, DIRECTIONS[d][0], DIRECTIONS[d][1], n)) {
                                System.out.printf("Found '%s' starting at (%d, %d) going %s%n", 
                                                  word, r, c, DIR_NAMES[d]);
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Word '" + word + "' not found.");
            }
        }
    }

    private static boolean checkWord(char[][] grid, String word, int startR, int startC, int dr, int dc, int n) {
        for (int k = 0; k < word.length(); k++) {
            int r = ((startR + k * dr) % n + n) % n;
            int c = ((startC + k * dc) % n + n) % n;

            if (grid[r][c] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'T', 'A', 'C', 'O'},
            {'E', 'S', 'P', 'R'},
            {'A', 'T', 'G', 'A'},
            {'M', 'O', 'O', 'N'}
        };

        String[] wordsToFind = {
            "TACO",
            "TEAM",
            "NOOM",
            "ORPS",
            "STAR",
            "TS",
            "ST"
        };

        System.out.println("--- Search Results ---");
        solveWordFind(grid, wordsToFind);
    }
}