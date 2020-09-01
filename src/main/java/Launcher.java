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
        return Report.getReport(match,player1Name,player2Name);
    }
}