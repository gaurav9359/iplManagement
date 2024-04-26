package mainPackage;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String name;
    private String homeGround;
    private List<Player> players;
    private int points;
    private int rank;

    public Team(String name, String homeGround) {
        this.name = name;
        this.homeGround = homeGround;
        this.players = new ArrayList<>();
        this.points = 0;
        this.rank = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getName(){
        return this.name;
    }

    public List<Player> getPlayers(){
        return players;
    }

}
