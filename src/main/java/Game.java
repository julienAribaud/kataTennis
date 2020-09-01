public class Game extends Score{

    public static final int POINT_15=1;
    public static final int POINT_30=2;
    public static final int POINT_40=3;
    public static final int NORMAL_WIN_GAME_NEEDED=4;
    public static final int TIEBREAK_WIN_GAME_NEEDED=7;

    public Game(){
        this(0,0);
    }
    public Game(int scorePlayer1, int scorePlayer2) {
        super(scorePlayer1, scorePlayer2);
    }

    public boolean isDeuce(){
        return (getScorePlayer1()>POINT_30
                && getScorePlayer2()>POINT_30
                && getScorePlayer1()== getScorePlayer2());
    }

    public boolean isAdvantage(){
        return (getScorePlayer1()>POINT_30
                && getScorePlayer2()>POINT_30
                && Math.abs(getScorePlayer1()- getScorePlayer2())==1);
    }

    public boolean isFinished(boolean isTieBreak){
        if(isTieBreak)
            return  getScorePlayer1() > TIEBREAK_WIN_GAME_NEEDED - 1 && (getScorePlayer1() - getScorePlayer2()) > 1 ||
                    getScorePlayer2() > TIEBREAK_WIN_GAME_NEEDED - 1 && (getScorePlayer2() - getScorePlayer1()) > 1;

        else
            return  getScorePlayer1() == NORMAL_WIN_GAME_NEEDED && getScorePlayer2() < POINT_40 ||
                    getScorePlayer2() == NORMAL_WIN_GAME_NEEDED && getScorePlayer1() < POINT_40 ||
                    getScorePlayer1() > POINT_30 && getScorePlayer2() > POINT_30 && Math.abs(getScorePlayer1() - getScorePlayer2()) == 2;
    }
}