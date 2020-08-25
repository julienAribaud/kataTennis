public class GameBuilder {

    private final Game game=new Game();

    public GameBuilder withPlayer1Points(int player1Points){
        for (int i = 0; i < player1Points; i++) {
            this.game.ScorePlayer(1);
        }
        return this;
    }

    public GameBuilder withPlayer2Points(int player2Points){
        for (int i = 0; i < player2Points; i++) {
            this.game.ScorePlayer(2);
        }
        return this;
    }

    public Game build(){
        return game;
    }
}
