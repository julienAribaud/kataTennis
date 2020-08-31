public class Score {
    private final int[] scorePlayers;

    public Score(int scorePlayer1,int scorePlayer2){
        scorePlayers= new int[]{scorePlayer1, scorePlayer2};
    }

    public void scorePlayer(int playerID){
        scorePlayers[playerID-1]++;
    }

    private int getScore(int playerID) {
        return scorePlayers[playerID - 1];
    }

    public int getScorePlayer1(){
        return getScore(1);
    }

    public int getScorePlayer2(){
        return getScore(2);
    }
}