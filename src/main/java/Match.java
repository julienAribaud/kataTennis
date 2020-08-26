import java.util.ArrayList;

public class Match {

    Game currentGame;
    ArrayList<Set> sets;

    public Match(){
        currentGame=new Game();
        sets=new ArrayList<>();
        sets.add(new Set());
    }

    public void score(int playerNumber){

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
        long setsWinByPlayer1 = sets.stream().map(Set::whoWin).filter(i -> i == 1).count();
        long setsWinByPlayer2 = sets.stream().map(Set::whoWin).filter(i -> i == 2).count();

        return setsWinByPlayer1 ==3 || setsWinByPlayer2 ==3;
    }
}