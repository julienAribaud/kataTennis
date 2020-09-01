import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    private Match match;

    @Test
    public void player1_score_perfectMatch_SHOULD_win(){

        match=MatchBuilder.getPerfectMatch();

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
    public void tieBreak_SHOULD_Notwin(){
        match=MatchBuilder.getTieBreak();
        assertThat(match.isTieBreak()).isTrue();
        assertThat(match.isFinished()).isFalse();
        assertThat(match.whoWin()).isEqualTo(0);
        assertThat(match.getSetsScore()).isEqualTo("(6-6)");
    }
}