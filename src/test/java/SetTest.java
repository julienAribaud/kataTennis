import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

    private Set set;

    @Test
    public void player1Score4_SHOULD_display_40(){

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
}