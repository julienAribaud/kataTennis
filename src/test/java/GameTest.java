
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    private Game game;

    @Test
    public void player1Score4_notInTieBreak_SHOULD_winTheGame(){

        game=new ScoreBuilder().withPlayer1Points(4).buildGame();

        assertThat(game.getScorePlayer1()).isEqualTo(4);
        assertThat(game.getScorePlayer2()).isEqualTo(0);
        assertThat(game.isFinished(false)).isTrue();
    }

    @Test
    public void player1_AND_player2_score3_notInTieBreak_SHOULD_be_DEUCE(){

        game=new ScoreBuilder().withPlayer1Points(3).withPlayer2Points(3).buildGame();

        assertThat(game.isDeuce()).isTrue();
    }

    @Test
    public void player1_score4_player2_score3_notInTieBreak_SHOULD_be_ADVANTAGE(){

        game=new ScoreBuilder().withPlayer1Points(4).withPlayer2Points(3).buildGame();

        assertThat(game.isAdvantage()).isTrue();
    }

    @Test
    public void player1_score4_player2_score2_notInTieBreak_SHOULD_be_GAMEWON(){

        game=new ScoreBuilder().withPlayer1Points(4).withPlayer2Points(2).buildGame();

        assertThat(game.isFinished(false)).isTrue();
    }

    @Test
    public void player1_score4_player2_score3_notInTieBreak_SHOULD_not_be_GAMEWON(){

        game=new ScoreBuilder().withPlayer1Points(4).withPlayer2Points(3).buildGame();

        assertThat(game.isFinished(false)).isFalse();
    }

    @Test
    public void player1_score5_player2_score3_notInTieBreak_SHOULD_be_GAMEWON(){

        game=new ScoreBuilder().withPlayer1Points(5).withPlayer2Points(3).buildGame();

        assertThat(game.isFinished(false)).isTrue();
    }

    @Test
    public void player1_score5_player2_score3_TIEBREAK_SHOULD_not_be_GAMEWON(){

        game=new ScoreBuilder().withPlayer1Points(5).withPlayer2Points(3).buildGame();

        assertThat(game.isFinished(true)).isFalse();
    }

    @Test
    public void player1_score7_player2_score3_TIEBREAK_SHOULD_be_GAMEWON(){

        game=new ScoreBuilder().withPlayer1Points(7).withPlayer2Points(3).buildGame();

        assertThat(game.isFinished(true)).isTrue();
    }

    @Test
    public void player1_score7_player2_score6_TIEBREAK_SHOULD_not_be_GAMEWON(){

        game=new ScoreBuilder().withPlayer1Points(7).withPlayer2Points(6).buildGame();

        assertThat(game.isFinished(true)).isFalse();
    }

    @Test
    public void player1_score7_player2_score9_TIEBREAK_SHOULD_be_GAMEWON(){

        game=new ScoreBuilder().withPlayer1Points(7).withPlayer2Points(9).buildGame();

        assertThat(game.isFinished(true)).isTrue();
    }
}