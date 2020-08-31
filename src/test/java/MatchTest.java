import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    private Match match;

    @Test
    public void player1_score_perfectMatch_SHOULD_win(){

        match=new Match();
        // 4 score  = 1 game
        // 4*6 game = 1 set
        // 4*6*3    = 1 match
        for (int i = 0; i <72 ; i++)
            match.score(1);

        assertThat(match.isFinished()).isTrue();
        assertThat(match.whoWin()).isEqualTo(1);
        assertThat(match.getSetsScore()).isEqualTo("(6-0) (6-0) (6-0)");
    }

    @Test
    public void player1_score1game_SHOULD_Notwin(){

        match=new Match();
        match.score(1);

        assertThat(match.isFinished()).isFalse();
        assertThat(match.whoWin()).isEqualTo(0);
        assertThat(match.getSetsScore()).isEqualTo("(0-0)");
    }

    @Test
    public void player1_score2Set_and_player2_score1Set_SHOULD_Notwin(){

        match=new Match();
        //player 1 win 2 sets
        for (int i = 0; i <48 ; i++)
            match.score(1);

        //player 2 win 1 set
        for (int i = 0; i <24 ; i++)
            match.score(2);

        assertThat(match.isFinished()).isFalse();
        assertThat(match.whoWin()).isEqualTo(0);
        assertThat(match.getSetsScore()).isEqualTo("(6-0) (6-0) (0-6) (0-0)");
    }
}