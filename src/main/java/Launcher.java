public class Launcher {

    String player1Name="ONE";
    String player2Name="TWO";
    Match match;

    public Launcher(){
        match=new Match();
    }

    public void setPlayer1Name(String player1Name){
        this.player1Name=player1Name;
    }

    public void setPlayer2Name(String player2Name){
        this.player2Name=player2Name;
    }

    public void gameScored(int playerId){
        match.score(playerId);
    }

    public String getReport(){
        StringBuilder report=new StringBuilder();
        report.append(ReportParsers.playerStatus(1,player1Name));
        report.append(ReportParsers.playerStatus(2,player1Name));
        report.append(ReportParsers.scoreStatus(match));
        if(match.isFinished())
            report.append(ReportParsers.gameStatus(match.getGame()));
        report.append(ReportParsers.matchStatus(match));
        return report.toString();
    }
}
