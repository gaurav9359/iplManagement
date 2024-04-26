package mainPackage;

import java.util.HashMap;
import java.util.Map;


class Match {
    private Team team1;
    private Team team2;
    private Team winner;
    private Map<Player, DismissalType> playerDismissals;
    private Map<Team, Integer> teamScores;

    public Match(Team team1, Team team2,Team winner,CricketTournament tournament) {
        this.team1 = team1;
        this.team2 = team2;
        tournament.updateLeaderboard(winner);
        this.winner=winner;
        this.playerDismissals = new HashMap<>();
        this.teamScores = new HashMap<>();
    }

    public void recordDismissal(Player player, Integer runs, Integer wickets, DismissalType dismissalType) {
        playerDismissals.put(player, dismissalType);
        player.scoredRuns(runs);
        player.playedMatch();
        player.tookWickets(wickets);
    }

    public void recordTeamScore(Team team, int score) {
        teamScores.put(team, score);
    }


}