public class Set extends Score{

    public Set(Score score) {
        pointPlayer1=score.pointPlayer1;
        pointPlayer2=score.pointPlayer2;
    }

    public boolean isTieBreak(){
        return pointPlayer1==pointPlayer2 && pointPlayer1==6;
    }

    public boolean isWinningPoint(){
        return false;
    }
}