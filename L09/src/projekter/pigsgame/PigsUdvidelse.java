package projekter.pigsgame;

import java.util.Scanner;

public class PigsUdvidelse {
    public static void main(String[] args) {

        playPig();

    }


    public static void playPig() {

        int[] playerPoints = new int[2];
        int PointsToWin = 100;

        while (true) {

            // God ide at flytte dem her ind i egen metode og lave en array med player classes som holder styr på alt.
            System.out.println("Player 1 plays");
            playerPoints[0] += playRound();
            if (hasPlayerWon(playerPoints[0], PointsToWin)) {
                System.out.println("Player 1 wins!");
                return;
            }

            System.out.println("Player 2 plays");
            playerPoints[1] += playRound();
            if (hasPlayerWon(playerPoints[1], PointsToWin)) {
                System.out.println("Player 2 wins!");
                return;
            }

            for (int i = 0; i < playerPoints.length; i++) {
                System.out.println("Player " + (i+1) + " has " + playerPoints[i] + "/" + PointsToWin + " points" );
            }

            System.out.println();

        }
    }

    public static int playRound() {

        Scanner scan = new Scanner(System.in);
        System.out.println("roll? ('no' stops) this will repeat");
        String answer = scan.nextLine();

        int points = 0;

        while (!answer.equals("no")) {

            int roll = rollDie();


            if (roll != 1)
                points += roll;
            else {
                System.out.println("You rolled 1, you lost your points :c \n");
                return 0;
            }

            System.out.println("You rolled " + roll + " Total is now " + points);


            answer = scan.nextLine();
        }
        return points;

    }

    public static boolean hasPlayerWon(int playerPoints, int PointsToWin) {
        boolean hasPlayerWon = false;
        if (playerPoints >= PointsToWin) {
            return true;
        }
        return hasPlayerWon;
    }



    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }
}
