public class Set {

    private int pointPlayer1 =0;
    private int pointPlayer2 =0;

    public void ScorePlayer(int playerNumber){
        if(playerNumber==1) pointPlayer1++;
        else pointPlayer2++;
    }

    public int getScore(int playerNumber){
        if(playerNumber==1) return pointPlayer1;
        else return pointPlayer2;
    }

    public boolean isTieBreak(){
        return pointPlayer1==pointPlayer2 && pointPlayer1==6;
    }
}