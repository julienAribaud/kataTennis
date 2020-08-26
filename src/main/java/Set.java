public class Set extends Score{

    public Set(Score score) {
        pointPlayer1=score.pointPlayer1;
        pointPlayer2=score.pointPlayer2;
    }

    public boolean isTieBreak(){
        return pointPlayer1==pointPlayer2 && pointPlayer1==6;
    }

    public boolean isHasBeenWon(){
        if( pointPlayer1 == 6 && pointPlayer2 <5 ||
            pointPlayer2 == 6 && pointPlayer1 <5 ||
            pointPlayer1 == 7 || pointPlayer2 == 7 )
            return true;
        return false;
    }
}