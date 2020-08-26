import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    private Match match;

    @Test
    public void player1_score_perfectMatch_SHOULD_win(){

        match=new Match("","");
        // 4 score  = 1 game
        // 4*6 game = 1 set
        // 4*6*3    = 1 match
        for (int i = 0; i <72 ; i++) {
            match.score(1);
        }
        assertThat(match.isFinished()).isTrue();
    }

    @Test
    public void player1_score_perfectMatch_SHOULD_have_60_60_60_AND_win_message(){

        match=new Match("","");
        for (int i = 0; i <72 ; i++) {
            match.score(1);
        }
        assertThat(match.ReportMatch().get(2)).isEqualTo("Score : (6-0) (6-0) (6-0)");
        assertThat(match.ReportMatch().get(3)).isEqualTo("Match Status : Player1 wins");
    }
}