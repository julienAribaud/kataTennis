public class ScoreBuilder {

    private final Score score=new Score();

    public ScoreBuilder withPlayer1Points(int player1Points){
        for (int i = 0; i < player1Points; i++) {
            this.score.scorePlayer(1);
        }
        return this;
    }

    public ScoreBuilder withPlayer2Points(int player2Points){
        for (int i = 0; i < player2Points; i++) {
            this.score.scorePlayer(2);
        }
        return this;
    }

    public Game buildGame(){
        return new Game(score);
    }

    public Set buildSet(){
        return new Set(score);
    }
}
