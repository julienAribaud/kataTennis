import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    private Match match;

    @Test
    public void player1_score_perfectMatch__SHOULD_be_win(){

        match=new Match();
        // 4 score  = 1 game
        // 4*6 game = 1 set
        // 4*6*3    = 1 match
        for (int i = 0; i <72 ; i++) {
            match.score(1);
        }
        assertThat(match.isFinished()).isTrue();
    }
}