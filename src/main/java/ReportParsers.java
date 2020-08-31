public class ReportParsers {

    protected static final String PLAYER="Player %d : %s";
    protected static final String SCORE="Score : %s";
    protected static final String GAME="Current game status : %s";
    protected static final String MATCH="Match Status : %s";

    public static String playerStatus(int idPlayer,String player){
        return String.format(PLAYER,idPlayer,player);
    }

    public static String scoreStatus(Match match){
        return String.format(SCORE,match.getSetsScore());
    }

    public static String gameStatus(Game game){
        String status="";

        if(game.isAdvantage())
            status= "advantage";

        else if(game.isDeuce())
            status= "deuce";

        else {
            status += getGamePointTranslation(game.getScorePlayer1());
            status += "-";
            status += getGamePointTranslation(game.getScorePlayer2());
        }
        return String.format(GAME,status);
    }

    private static String getGamePointTranslation(int score){
        switch (score){
            case Game.POINT_15 : return "15";
            case Game.POINT_30 : return "30";
            case Game.POINT_40 : return "40";
            case 0 :
            default : return "0";
        }
    }

    public static String matchStatus(Match match){
        String status="";
        if(!match.isFinished())
            status= "in progress";
        else
            status= "Player"+match.whoWin()+" wins";

        return String.format(MATCH,status);
    }
}
