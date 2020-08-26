public class SetBuilder {

    private final Set set=new Set();

    public SetBuilder withPlayer1Points(int player1Points){
        for (int i = 0; i < player1Points; i++) {
            this.set.ScorePlayer(1);
        }
        return this;
    }

    public SetBuilder withPlayer2Points(int player2Points){
        for (int i = 0; i < player2Points; i++) {
            this.set.ScorePlayer(2);
        }
        return this;
    }

    public Set build(){
        return set;
    }
}
