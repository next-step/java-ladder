package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GamersTest {

    @Test
    @DisplayName("정적 팩토리 메소드")
    void from() {
        Gamers actual = Gamers.from(List.of("pobi", "honux", "crong", "jk"));
        Gamers expected = getGamers();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사이즈 확인")
    void size() {
        Gamers gamers = getGamers();

        assertThat(gamers.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리를 올라간다")
    void climb() {
        Gamers gamers = getGamers();
        Gamers climbed = gamers.climb(LadderTest.getLadder());

        assertThat(climbed).isEqualTo(getGamers());
    }

    @Test
    @DisplayName("모든 게이머의 결과를 매칭")
    void matchResult() {
        Gamers gamers = getGamers();
        ExecutionResult actual = gamers.matchResult(List.of("0", "1", "2", "3"));

        assertThat(actual).isEqualTo(ExecutionResultTest.getExecutionResult());
    }

    public static Gamers getGamers() {
        List<Gamer> gamers = List.of(
                Gamer.of("pobi", 0),
                Gamer.of("honux", 1),
                Gamer.of("crong", 2),
                Gamer.of("jk", 3)
        );
        return new Gamers(gamers);
    }
}