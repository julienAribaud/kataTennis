public class GameStatus {

    private static final String PREFIX="Current game status : ";

    public static String GetStatus(Game game){
        String ret=PREFIX;

        if(game.isAdvantage()) {
            ret += "advantage";

        }else if(game.isDeuce()) {
            ret+= "deuce";

        }else {
            ret += getLabelScore(game.getScore(1));
            ret += "-";
            ret += getLabelScore(game.getScore(2));
        }
        return ret;
    }

    private static String getLabelScore(int score){
        switch (score){
            case Game.POINT_15 : return "15";
            case Game.POINT_30 : return "30";
            case Game.POINT_40 : return "40";
            case 0 :
            default : return "0";
        }
    }
}