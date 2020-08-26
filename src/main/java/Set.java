public class Set extends Score{

    public Set() {
        super();
    }

    public Set(Score score) {
        pointPlayer1=score.pointPlayer1;
        pointPlayer2=score.pointPlayer2;
    }

    public boolean isTieBreak(){
        return pointPlayer1==pointPlayer2 && pointPlayer1==6;
    }

    public boolean isFinished(){
        return whoWin()!=0;
    }

    // 0 nobody
    // 1 player 1
    // 2 player 2
    public int whoWin(){

        if( pointPlayer1 == 6 && pointPlayer2 <5 || pointPlayer1 == 7 )
            return 1;

        if( pointPlayer2 == 6 && pointPlayer1 <5 || pointPlayer2 == 7 )
            return 2;

        return 0;
    }
}