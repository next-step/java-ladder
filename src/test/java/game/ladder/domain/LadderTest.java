package game.ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/14.
 */
class LadderTest {

    static List<String> players;
    static List<String> rewards;
    static Ladder ladder;

    @BeforeAll
    static void setUp() {

        // given
        players = Arrays.asList("A", "B", "C");
        rewards = Arrays.asList("@", "@", "!");
        ladder = new Ladder(players, 5, rewards, () -> false);
    }

    @DisplayName("사다리 마지막 위치")
    @Test
    void getLastPosition() {

        // when
        int position = ladder.getLastPosition(players.indexOf("C"));

        // then
        assertThat(position).isEqualTo(rewards.indexOf("!"));
    }

    @DisplayName("보상 위치")
    @Test
    void getResult() {

        // when
        String result = ladder.getResult("C");

        // then
        assertThat(result).isEqualTo("!");
    }
}