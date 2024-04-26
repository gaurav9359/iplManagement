package mainPackage;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create players
        Player player1 = new Player("Virat Kohli", 32, "Batsman");
        Player player2 = new Player("Jasprit Bumrah", 28, "Bowler");
        Player player3 = new Player("MS Dhoni", 39, "Wicketkeeper");

        // Create teams
        Team team1 = new Team("Team1", "Stadium1");
        team1.addPlayer(player1);
        team1.addPlayer(player2);

        Team team2 = new Team("Team2", "Stadium2");
        team2.addPlayer(player3);

        // Create a cricket tournament
        CricketTournament tournament = new CricketTournament(TournamentType.IPL, MatchFormat.T20);

        // Add teams to the tournament
        tournament.addTeam(team1);
        tournament.addTeam(team2);

        // Create a match
        Match match = new Match(team1, team2,team1,tournament);

        // Record dismissal
        match.recordDismissal(player1, 50, 0, DismissalType.CAUGHT);
        match.recordDismissal(player2, 0, 2, DismissalType.BOWLED);


        // Create and start threads for each query
        Thread highestWicketTakerThread = new Thread(() -> {
            Player highestWicketTaker = tournament.getHighestWicketTaker();
            System.out.println("Highest Wicket Taker: " + highestWicketTaker.getName());
        });

        Thread most50sPlayerThread = new Thread(() -> {
            Player playerWithMost50s = tournament.getPlayerWithMost50s();
            System.out.println("Player with Most 50s: " + playerWithMost50s.getName());
        });

        Thread semifinalistTeamsThread = new Thread(() -> {
            tournament.printSemifinalistTeams();
        });

        Thread topRunScorersThread = new Thread(() -> {
            tournament.printTopRunScorers(5);
        });

        Thread winnerThread = new Thread(() -> {
            tournament.printWinner();
        });


        highestWicketTakerThread.start();
        most50sPlayerThread.start();
        semifinalistTeamsThread.start();
        try {
            semifinalistTeamsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        topRunScorersThread.start();
        try {
            most50sPlayerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        winnerThread.start();


    }
}