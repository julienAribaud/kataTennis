
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameStatusTest {

    private Game game;

    @Test
    public void player1Score3_AND_Player2Score2_SHOULD_display_4030(){
        game=new GameBuilder().withPlayer1Points(3).withPlayer2Points(2).build();

        assertThat(GameStatus.GetStatus(game)).isEqualTo("Current game status: 40-30");
    }

    @Test
    public void player1Score1_AND_Player2Score1_SHOULD_display_1515(){
        game=new GameBuilder().withPlayer1Points(1).withPlayer2Points(1).build();

        assertThat(GameStatus.GetStatus(game)).isEqualTo("Current game status: 15-15");
    }

    @Test
    public void deuce_SHOULD_display_deuce(){
        game=new GameBuilder().withPlayer1Points(3).withPlayer2Points(3).build();

        assertThat(GameStatus.GetStatus(game)).isEqualTo("Current game status: deuce");
    }

    @Test
    public void advantage_SHOULD_display_advantage(){
        game=new GameBuilder().withPlayer1Points(4).withPlayer2Points(3).build();

        assertThat(GameStatus.GetStatus(game)).isEqualTo("Current game status: advantage");
    }

}