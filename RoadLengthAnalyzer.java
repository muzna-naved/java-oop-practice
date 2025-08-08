public class RoadLengthAnalyzer {

    // Define grid (unordered shaped road)
    static int[][] roadLengths = {
        {0, 1, 0, 0, 0},
        {1, 1, 1, 0, 0},
        {0, 1, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 1, 1}
    };

    // Recursive function to find length of road starting from (r, c)
    static int rl(int r, int c) {
        int rMax = roadLengths.length;
        int cMax = roadLengths[0].length;

        // Base case: out of bounds or not a road cell
        if (r < 0 || r >= rMax || c < 0 || c >= cMax || roadLengths[r][c] == 0) {
            return 0;
        }

        // Mark current cell as visited
        roadLengths[r][c] = 0;

        // Explore all 8 directions
        return 1 +
            rl(r - 1, c - 1) +
            rl(r - 1, c) +
            rl(r - 1, c + 1) +
            rl(r, c - 1) +
            rl(r, c + 1) +
            rl(r + 1, c - 1) +
            rl(r + 1, c) +
            rl(r + 1, c + 1);
    }

    // Main method
    public static void main(String[] args) {
        int r = 4; // Starting row
        int c = 3; // Starting column
        int length = rl(r, c);
        System.out.println("The length of the road starting at (" + r + ", " + c + ") is: " + length);
    }
}
