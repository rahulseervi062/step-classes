import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsArcade {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random random = new Random();

    // Data structure to hold history for the summary table
    static class RoundResult {
        int roundNumber;
        String playerMove;
        String computerMove;
        String result; // "Player Wins", "Computer Wins", "Draw"

        public RoundResult(int roundNumber, String playerMove, String computerMove, String result) {
            this.roundNumber = roundNumber;
            this.playerMove = playerMove;
            this.computerMove = computerMove;
            this.result = result;
        }
    }

    /**
     * Determines the winner of a single round using standard rules.
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins = switch (playerMove.toLowerCase()) {
            case "rock" -> computerMove.equalsIgnoreCase("Scissors");
            case "paper" -> computerMove.equalsIgnoreCase("Rock");
            case "scissors" -> computerMove.equalsIgnoreCase("Paper");
            default -> false;
        };

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    /**
     * Generates a random move for the computer.
     */
    public static String getRandomComputerMove() {
        return MOVES[random.nextInt(MOVES.length)];
    }

    /**
     * Capitalizes the first letter of a valid move for consistent output display.
     */
    private static String normalizeMove(String move) {
        String lower = move.trim().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<RoundResult> history = new ArrayList<>();
        
        int totalRounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=========================================");
        System.out.println(" Welcome to College Coding Arcade: RPS!  ");
        System.out.println("=========================================\n");

        for (int i = 1; i <= totalRounds; i++) {
            String playerMove = "";
            
            // Input Validation Loop
            while (true) {
                System.out.printf("Round %d — Enter move (Rock, Paper, Scissors): ", i);
                playerMove = scanner.nextLine().trim();

                if (playerMove.equalsIgnoreCase("Rock") || 
                    playerMove.equalsIgnoreCase("Paper") || 
                    playerMove.equalsIgnoreCase("Scissors")) {
                    playerMove = normalizeMove(playerMove);
                    break;
                }
                System.out.println("Invalid move! Please try again.");
            }

            String computerMove = getRandomComputerMove();
            String result = playRound(playerMove, computerMove);

            // Update score counters
            switch (result) {
                case "Player Wins" -> wins++;
                case "Computer Wins" -> losses++;
                case "Draw" -> draws++;
            }

            // Record round outcome
            history.add(new RoundResult(i, playerMove, computerMove, result));

            // Immediate feedback
            System.out.printf("Round %d — Player: %s, Computer: %s -> %s\n\n", 
                              i, playerMove, computerMove, result);
        }

        // Output Summary
        printScoreboard(history, wins, losses, draws, totalRounds);
        scanner.close();
    }

    /**
     * Formats and prints the final summary table and calculated statistics.
     */
    private static void printScoreboard(List<RoundResult> history, int wins, int losses, int draws, int totalRounds) {
        System.out.println("\n=========================================");
        System.out.println("              FINAL SUMMARY              ");
        System.out.println("=========================================");
        
        // Print Tabular Data
        System.out.printf("%-7s | %-12s | %-13s | %-13s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");
        for (RoundResult rr : history) {
            System.out.printf("%-7d | %-12s | %-13s | %-13s\n", 
                              rr.roundNumber, rr.playerMove, rr.computerMove, rr.result);
        }
        System.out.println("---------------------------------------------------------");

        // Percentage Calculation
        double winPercentage = ((double) wins / totalRounds) * 100.0;

        // Score Totals
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                          wins, losses, draws, winPercentage);
        System.out.println("=========================================");
    }
}