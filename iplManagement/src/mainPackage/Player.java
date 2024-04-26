package mainPackage;

class Player {
    private String name;
    private int age;
    private String role;
    private int matchesPlayed;
    private int runsScored;
    private int wicketsTaken;
    private int fiftiesScored;
    private int centuriesScored;


    public Player(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.matchesPlayed = 0;
        this.runsScored = 0;
        this.wicketsTaken = 0;
        this.fiftiesScored = 0;
        this.centuriesScored = 0;
    }

    public void scoredRuns(int runs) {
        this.runsScored += runs;
        if (runs >= 50 && runs < 100) {
            this.fiftiesScored++;
        } else if (runs >= 100) {
            this.centuriesScored++;
        }
    }

    public void tookWickets(int wickets) {
        this.wicketsTaken += wickets;
    }

    public void playedMatch() {
        this.matchesPlayed++;
    }

    public int getRuns(){
        return this.runsScored;
    }

    public Integer info(){
        return this.wicketsTaken;
    }

    public int getWicket(){
        return wicketsTaken;
    }

    public String getName(){
        return this.name;
    }

    public int get50s(){
        return this.fiftiesScored;
    }
}