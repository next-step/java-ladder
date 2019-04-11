package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    private Players players;
    @Before
    public void initPlayer() {
        this.players = new Players(Arrays.asList("shin", "yeon", "jong"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_2명미만() {
        new Players(Arrays.asList());
        new Players(Arrays.asList("test"));
    }

    @Test
    public void 참여자_2명이상() {
        new Players(Arrays.asList("one", "two"));
    }

    @Test
    public void 참여자_수() {
        assertThat(this.players.countOfPerson()).isEqualTo(3);
    }

    @Test
    public void 참여자_포함() {
        assertThat(this.players.equals("shin")).isTrue();
    }

    @Test
    public void 참여자_미포함() {
        assertThat(this.players.equals("user")).isFalse();
    }

    @Test
    public void 참여자_인덱스() {
        assertThat(this.players.calcPlayerPoint("yeon")).isEqualTo(1);
    }
}