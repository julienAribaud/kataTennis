public class ScoreBuilder {
    int player1Points;
    int player2Points;

    public ScoreBuilder withPlayer1Points(int player1Points){
        this.player1Points=player1Points;
        return this;
    }

    public ScoreBuilder withPlayer2Points(int player2Points){
        this.player2Points=player2Points;
        return this;
    }

    public Game buildGame(){
        return new Game(player1Points,player2Points);
    }

    public Set buildSet(){
        return new Set(player1Points,player2Points);
    }
}
