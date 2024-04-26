package mainPackage;

import java.util.*;

class CricketTournament {
    private List<Team> teams;
    private Map<Team, Integer> leaderboard;
    private TournamentType tournamentType;
    private MatchFormat matchFormat;
    private int maxTeams;
    private int maxPlayersPerTeam;
    private List<Team> semifinalistTeams;
    private Team winner;

    public CricketTournament(TournamentType tournamentType, MatchFormat matchFormat) {
        this.tournamentType = tournamentType;
        this.matchFormat = matchFormat;
        this.teams = new ArrayList<>();
        this.leaderboard = new HashMap<>();
        this.maxTeams = (tournamentType == TournamentType.IPL) ? 10 : 8;
        this.maxPlayersPerTeam = (tournamentType == TournamentType.IPL) ? 12 : 11;
        this.semifinalistTeams = new ArrayList<>();
    }

    // Modify the addTeam method to check the maximum team limit and player limit
    public void addTeam(Team team) {
        if (teams.size() < maxTeams) {
            if (team.getPlayers().size() <= maxPlayersPerTeam) {
                teams.add(team);
                leaderboard.put(team, 0);

            } else {
                System.out.println("Maximum players limit exceeded for team " + team.getName() + ". Cannot add the team.");
            }
        } else {
            System.out.println("Maximum teams limit reached. Cannot add more teams.");
        }
    }


    public void setSemifinalistTeams(List<Team> teams) {
        this.semifinalistTeams = teams;
    }

    public void updateLeaderboard(Team winner){
        Integer currentScore = leaderboard.get(winner);
        if (currentScore != null) {
            leaderboard.put(winner, currentScore + 2);
        } else {
            System.out.println("Team not found in leaderboard.");
        }
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public List<Team> getSemifinalistTeams() {
        return semifinalistTeams;
    }

    public Team getWinner() {
        return winner;
    }

    public Player getHighestWicketTaker() {
        Player highestWicketTaker = null;
        int maxWickets = 0;

        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                int wickets = player.getWicket();
                if (wickets > maxWickets) {
                    maxWickets = wickets;
                    highestWicketTaker = player;
                }
            }
        }

        return highestWicketTaker;
    }

    public Player getPlayerWithMost50s() {
        Player playerWithMost50s = null;
        int maxFifties = 0;

        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                int numFifties = player.get50s();
                if (numFifties > maxFifties) {
                    maxFifties = numFifties;
                    playerWithMost50s = player;
                }
            }
        }

        return playerWithMost50s;
    }

    public void printSemifinalistTeams() {
        List<Map.Entry<Team, Integer>> sortedEntries = new ArrayList<>(leaderboard.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Semifinalists:");
        int count = 0;
        for (Map.Entry<Team, Integer> entry : sortedEntries) {
            if (count >= 4) {
                break; // Stop after printing the top 4 teams
            }
            System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " points");
            count++;
        }
    }

    public void printTopRunScorers(int count) {
        List<Player> allPlayers = new ArrayList<>();
        for (Team team : teams) {
            allPlayers.addAll(team.getPlayers());
        }

        allPlayers.sort((p1, p2) -> Integer.compare(p2.getRuns(), p1.getRuns()));

        System.out.println("Top " + count + " Run Scorers:");
        for (int i = 0; i < Math.min(count, allPlayers.size()); i++) {
            Player player = allPlayers.get(i);
            System.out.println((i + 1) + ". " + player.getName() + " - " + player.getRuns() + " runs");
        }
    }

    public void printWinner() {
        List<Map.Entry<Team, Integer>> sortedEntries = new ArrayList<>(leaderboard.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("Winner Team name: "+sortedEntries.get(0).getKey().getName()+"points: "+sortedEntries.get(0).getValue());
    }

    public  Map<Team, Integer> getLeaderboard(){
        return leaderboard;
    }
}