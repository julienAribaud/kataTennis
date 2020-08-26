public class Set extends Score{

    public static final int NORMAL_WIN_SETS_NEEDED=6;
    public static final int SPECIAL_WIN_SETS_NEEDED=7;

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

        if( pointPlayer1 == NORMAL_WIN_SETS_NEEDED && pointPlayer2 <NORMAL_WIN_SETS_NEEDED-1 || pointPlayer1 == SPECIAL_WIN_SETS_NEEDED )
            return 1;

        if( pointPlayer2 == NORMAL_WIN_SETS_NEEDED && pointPlayer1 <NORMAL_WIN_SETS_NEEDED-1 || pointPlayer2 == SPECIAL_WIN_SETS_NEEDED )
            return 2;

        return 0;
    }

    public String getScore(){
        return "("+pointPlayer1+"-"+pointPlayer2+")";
    }
}