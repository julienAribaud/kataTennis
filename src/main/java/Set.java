public class Set extends Score{

    private static final int NORMAL_WIN_SETS_NEEDED=6;
    private static final int TIEBREAK_SETS=6;
    private static final int SPECIAL_WIN_SETS_NEEDED=7;

    public Set(){
        this(0,0);
    }
    public Set(int scorePlayer1, int scorePlayer2) {
        super(scorePlayer1, scorePlayer2);
    }

    public boolean isTieBreak(){
        return getScorePlayer1()==TIEBREAK_SETS && getScorePlayer2()==TIEBREAK_SETS;
    }

    public boolean isFinished(){
        return whoWin()!=0;
    }

    // 0 nobody
    // 1 player 1
    // 2 player 2
    public int whoWin(){

        if( getScorePlayer1() == NORMAL_WIN_SETS_NEEDED && getScorePlayer2() <NORMAL_WIN_SETS_NEEDED-1 || getScorePlayer1() == SPECIAL_WIN_SETS_NEEDED )
            return 1;

        if( getScorePlayer2() == NORMAL_WIN_SETS_NEEDED && getScorePlayer1() <NORMAL_WIN_SETS_NEEDED-1 || getScorePlayer2() == SPECIAL_WIN_SETS_NEEDED )
            return 2;

        return 0;
    }

    public String getScore(){
        return "("+ getScorePlayer1()+"-"+ getScorePlayer2()+")";
    }
}