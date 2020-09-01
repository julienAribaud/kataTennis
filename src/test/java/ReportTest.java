import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReportTest {

    /////
    // GAME STATUS
    /////
    private Game game;
    @Test
    public void gameStatus_player1Score3_AND_Player2Score2_NOTinTIEBREAK_SHOULD_display_4030(){
        game=new ScoreBuilder().withPlayer1Points(3).withPlayer2Points(2).buildGame();

        assertThat(Report.gameStatus(game,false)).isEqualTo("Current game status : 40-30");
    }

    @Test
    public void gameStatus_player1Score1_AND_Player2Score1_NOTinTIEBREAK_SHOULD_display_1515(){
        game=new ScoreBuilder().withPlayer1Points(1).withPlayer2Points(1).buildGame();

        assertThat(Report.gameStatus(game,false)).isEqualTo("Current game status : 15-15");
    }

    @Test
    public void gameStatus_deuce_NOTinTIEBREAK_SHOULD_display_deuce(){
        game=new ScoreBuilder().withPlayer1Points(3).withPlayer2Points(3).buildGame();

        assertThat(Report.gameStatus(game,false)).isEqualTo("Current game status : deuce");
    }

    @Test
    public void gameStatus_advantage_NOTinTIEBREAK_SHOULD_display_advantage(){
        game=new ScoreBuilder().withPlayer1Points(4).withPlayer2Points(3).buildGame();

        assertThat(Report.gameStatus(game,false)).isEqualTo("Current game status : advantage");
    }

    /////
    // tie break specification report
    /////
    @Test
    public void tiebreakSet_SHOULD_not_display_deuce(){
        game=new ScoreBuilder().withPlayer1Points(3).withPlayer2Points(3).buildGame();
        assertThat(Report.gameStatus(game,true)).isEqualTo("Current game status : 3-3");
    }

    @Test
    public void tiebreakSet_SHOULD_not_display_advantage(){
        game=new ScoreBuilder().withPlayer1Points(4).withPlayer2Points(3).buildGame();
        assertThat(Report.gameStatus(game,true)).isEqualTo("Current game status : 4-3");
    }
}