public class Score {
    protected int pointPlayer1=0;
    protected int pointPlayer2=0;

    public void scorePlayer(int playerNumber){
        if(playerNumber==1) pointPlayer1++;
        else pointPlayer2++;
    }

    public int getScore(int playerNumber){
        if(playerNumber==1) return pointPlayer1;
        else return pointPlayer2;
    }
}