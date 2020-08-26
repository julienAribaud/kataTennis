import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Match {

    public static final int NUMBER_SETS_NEEDED_TO_WIN=3;
    private final String player1;
    private final String player2;

    Game currentGame;
    ArrayList<Set> sets;

    public Match(String player1,String player2){
        currentGame=new Game();
        sets=new ArrayList<>();
        sets.add(new Set());
        this.player1=player1;
        this.player2=player2;
    }

    public void score(int playerNumber){
        if(isFinished()) return;

        currentGame.scorePlayer(playerNumber);
        Set currentSet=sets.get(sets.size()-1);

        if(currentGame.isFinished(currentSet.isTieBreak())){

            currentGame=new Game();

            currentSet.scorePlayer(playerNumber);

            if(currentSet.isFinished() && !this.isFinished())
                sets.add(new Set());
        }
    }

    public boolean isFinished(){
        return whoWin()!=0;
    }

    // 0 nobody
    // 1 player 1
    // 2 player 2
    public int whoWin(){
        long setsWinByPlayer1 = sets.stream().map(Set::whoWin).filter(i -> i == 1).count();
        long setsWinByPlayer2 = sets.stream().map(Set::whoWin).filter(i -> i == 2).count();

        if(setsWinByPlayer1==NUMBER_SETS_NEEDED_TO_WIN)
            return 1;

        if(setsWinByPlayer2==NUMBER_SETS_NEEDED_TO_WIN)
            return 2;

        return 0;
    }

    public String getSetsScore(){
        return sets.stream().map(Set::getScore).collect(Collectors.joining(" "));
    }

    public List<String> ReportMatch(){
        ArrayList<String> report=new ArrayList<>();
        report.add(MatchStatus.GetPlayer1(player1));
        report.add(MatchStatus.GetPlayer2(player2));
        report.add(MatchStatus.GetScore(getSetsScore()));
        if(!isFinished())
            report.add(GameStatus.GetStatus(currentGame));
        report.add(MatchStatus.GetStatus(this));
        return report;
    }
}