
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameStatusTest {

    @Test
    public void player1Score3_AND_Player2Score2_SHOULD_display_4030(){
        Game game=new Game();
        game.ScorePlayer(1);
        game.ScorePlayer(1);
        game.ScorePlayer(1);

        game.ScorePlayer(2);
        game.ScorePlayer(2);

        assertThat(GameStatus.GetStatus(game)).isEqualTo("Current game status: 40-30");
    }

    @Test
    public void player1Score1_AND_Player2Score1_SHOULD_display_1515(){
        Game game=new Game();
        game.ScorePlayer(1);

        game.ScorePlayer(2);

        assertThat(GameStatus.GetStatus(game)).isEqualTo("Current game status: 15-15");
    }

}