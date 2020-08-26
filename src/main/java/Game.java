public class Game extends Score{

    public static final int POINT_15=1;
    public static final int POINT_30=2;
    public static final int POINT_40=3;
    public static final int NORMAL_WIN_GAME_NEEDED=4;
    public static final int TIEBREAK_WIN_GAME_NEEDED=7;

    public Game() {
        super();
    }

    public Game(Score score) {
        pointPlayer1=score.pointPlayer1;
        pointPlayer2=score.pointPlayer2;
    }

    public boolean isDeuce(){
        return (pointPlayer1>POINT_30
                && pointPlayer2>POINT_30
                && pointPlayer1==pointPlayer2);
    }

    public boolean isAdvantage(){
        return (pointPlayer1>POINT_30
                && pointPlayer2>POINT_30
                && Math.abs(pointPlayer1-pointPlayer2)==1);
    }

    public boolean isFinished(boolean isTieBreak){
        if(isTieBreak) {
            if (pointPlayer1>TIEBREAK_WIN_GAME_NEEDED-1 && (pointPlayer1 - pointPlayer2)>1 ||
                pointPlayer2>TIEBREAK_WIN_GAME_NEEDED-1 && (pointPlayer2 - pointPlayer1)>1 )
                return true;
            return false;
        }
        else{
            if (pointPlayer1 == NORMAL_WIN_GAME_NEEDED && pointPlayer2 < POINT_40 ||
                pointPlayer2 == NORMAL_WIN_GAME_NEEDED && pointPlayer1 < POINT_40 ||
                pointPlayer1 > POINT_30 && pointPlayer2 > POINT_30 && Math.abs(pointPlayer1 - pointPlayer2) == 2 )
                return true;
            return false;
        }
    }
}