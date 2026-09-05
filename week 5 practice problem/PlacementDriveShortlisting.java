import java.util.Arrays;

public class PlacementDriveShortlisting {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;
        double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            this.compositeScore = cgpa * 10 + codingScore * 0.5;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
        }

        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = Arrays.stream(candidates)
            .filter(c -> Candidate.isEligible(c.cgpa, c.codingScore))
            .toArray(Candidate[]::new);

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(shortlisted[i].name)
                  .append(" (").append(shortlisted[i].compositeScore).append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
        // 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}