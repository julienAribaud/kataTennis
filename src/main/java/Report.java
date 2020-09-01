public class Report {

    private static final String PLAYER="Player %d : %s";
    private static final String SCORE="Score : %s";
    private static final String GAME="Current game status : %s";
    private static final String MATCH="Match Status : %s";

    private static final String ADVANTAGE="advantage";
    private static final String DEUCE="deuce";
    private static final String IN_PROGRESS="in progress";

    public static String playerStatus(int idPlayer,String player){
        return String.format(PLAYER,idPlayer,player);
    }

    public static String scoreStatus(Match match){
        return String.format(SCORE,match.getSetsScore());
    }

    public static String gameStatus(Game game,boolean isTieBreak){
        String status="";

        if(isTieBreak) {
            status += game.getScorePlayer1();
            status += "-";
            status += game.getScorePlayer2();

        }else if(game.isAdvantage())
            status= ADVANTAGE;

        else if(game.isDeuce())
            status= DEUCE;

        else{
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
        String status;
        if(!match.isFinished())
            status= IN_PROGRESS;
        else
            status= "Player"+match.whoWin()+" wins";

        return String.format(MATCH,status);
    }

    public static String getReport(Match match,String player1Name,String player2Name){
        StringBuilder report=new StringBuilder();
        report.append(playerStatus(1,player1Name));
        report.append(playerStatus(2,player2Name));
        report.append(scoreStatus(match));
        if(match.isFinished())
            report.append(Report.gameStatus(match.getGame(),match.isTieBreak()));
        report.append(Report.matchStatus(match));
        return report.toString();
    }
}
