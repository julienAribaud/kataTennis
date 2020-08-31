import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Match {

    public static final int NUMBER_SETS_NEEDED_TO_WIN=3;

    private Game currentGame;
    private final List<Set> sets;

    public Match(){
        currentGame=new Game();
        sets=new ArrayList<>();
        sets.add(new Set());
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
        if(isPlayerWin(1)) return 1;
        if(isPlayerWin(2)) return 2;
        return 0;
    }

    public boolean isPlayerWin(int playerNumber){
        return sets.stream().map(Set::whoWin).filter(i -> i == playerNumber).count()==NUMBER_SETS_NEEDED_TO_WIN;
    }

    public String getSetsScore(){
        return sets.stream().map(Set::getScore).collect(Collectors.joining(" "));
    }

    public Game getGame(){
        return currentGame;
    }
}