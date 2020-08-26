import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

    private Set set;

    @Test
    public void player1Score4_SHOULD_be_40_and_no_tiebreak(){

        set=new ScoreBuilder().withPlayer1Points(4).buildSet();

        assertThat(set.getScore(1)).isEqualTo(4);
        assertThat(set.getScore(2)).isEqualTo(0);
        assertThat(set.isTieBreak()).isFalse();
    }

    @Test
    public void player1_and_player2_Score6_SHOULD_tiebreak(){

        set=new ScoreBuilder().withPlayer1Points(6).withPlayer2Points(6).buildSet();

        assertThat(set.getScore(1)).isEqualTo(6);
        assertThat(set.getScore(2)).isEqualTo(6);
        assertThat(set.isTieBreak()).isTrue();
    }

    @Test
    public void player1_score6_player2_score3_SHOULD_be_WON(){

        set=new ScoreBuilder().withPlayer1Points(6).withPlayer2Points(3).buildSet();

        assertThat(set.isHasBeenWon()).isEqualTo(true);
    }

    @Test
    public void player1_score3_player2_score5_SHOULD_not_be_WON(){

        set=new ScoreBuilder().withPlayer1Points(3).withPlayer2Points(5).buildSet();

        assertThat(set.isHasBeenWon()).isEqualTo(false);
    }

    @Test
    public void player1_score6_player2_score5_SHOULD_not_be_WON(){

        set=new ScoreBuilder().withPlayer1Points(6).withPlayer2Points(5).buildSet();

        assertThat(set.isHasBeenWon()).isEqualTo(false);
    }

    @Test
    public void player1_score6_player2_score7_SHOULD_be_WON(){

        set=new ScoreBuilder().withPlayer1Points(6).withPlayer2Points(7).buildSet();

        assertThat(set.isHasBeenWon()).isEqualTo(true);
    }
}