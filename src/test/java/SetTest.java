import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

    private Set set;

    @Test
    public void player1Score4_SHOULD_display_40(){

        set=new SetBuilder().withPlayer1Points(4).build();

        assertThat(set.getScore(1)).isEqualTo(4);
        assertThat(set.getScore(2)).isEqualTo(0);
    }

    @Test
    public void player1_and_player2_Score6_SHOULD_display_tiebreak(){

        set=new SetBuilder().withPlayer1Points(6).withPlayer2Points(6).build();

        assertThat(set.getScore(1)).isEqualTo(6);
        assertThat(set.getScore(2)).isEqualTo(6);

        assertThat(set.isTieBreak()).isEqualTo(true);
    }
}