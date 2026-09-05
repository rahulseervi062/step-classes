public class SeatingGridOptimizer {
 
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }
 
    // Classifies every row (rows may be jagged) using rowAverage(...).
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
 
        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone = (average >= threshold) ? "Buzzing Zone" : "Quiet Zone";
 
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }
        return result.toString();
    }
 
    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
        // Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}
 
