public class MatchStatus {

    private static final String PREFIX="Match Status : ";
    private static final String PREFIX_SCORE="Score : ";
    private static final String PREFIX_PLAYER="Player";

    public static String GetStatus(Match match){
        String ret=PREFIX;

        if(!match.isFinished()) {
            ret += "in progress";

        }else {
            ret+= "Player"+match.whoWin()+" wins";
        }
        return ret;
    }

    public static String GetScore(String score){
        return PREFIX_SCORE+score;
    }

    public static String GetPlayer1(String player1){
        return PREFIX_PLAYER+" 1 : "+player1;
    }

    public static String GetPlayer2(String player2){
        return PREFIX_PLAYER+" 2 : "+player2;
    }
}
