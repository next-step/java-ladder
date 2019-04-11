package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MatchTest {
    private Match match;
    private Players players = new Players(Arrays.asList("shin", "yeon", "jong"));

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_미포함() {
        new Match(this.players, "test");
    }

    @Test
    public void 참여자_포함() {
        new Match(this.players, "shin");
    }

    @Test
    public void 참여자_인덱스() {
        this.match = new Match(this.players, "yeon");
        assertThat(match.calcPlayerPoint()).isEqualTo(1);
    }

    @Test
    public void 모든참여자() {
        this.match = new Match(this.players, "all");
    }
}

