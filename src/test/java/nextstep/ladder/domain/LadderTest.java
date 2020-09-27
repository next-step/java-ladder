package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static nextstep.ladder.TestUtil.asLine;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderTest {

    private final int height = 5;
    private final int countOfPerson = 4;

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void of() {
        List<Line> lines = Arrays.asList(
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false),
                asLine(true, false, true)
        );

        assertNotNull(Ladder.of(height, countOfPerson, lines));
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생 - height")
    void of_validateHeight() {
        List<Line> lines = Arrays.asList(
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false)
        );

        assertThatIllegalArgumentException().isThrownBy(() ->
                Ladder.of(height, countOfPerson, lines)
        );
    }

    @Test
    @DisplayName("정상적으로 게임 결과가 도출되는지 검사")
    void run() {
        // given
        Players actual = new Players(providePlayers(0, 1, 2, 3));
        List<Line> lines = Arrays.asList(
                asLine(false, false, true),
                asLine(false, true, false),
                asLine(true, false, true),
                asLine(true, false, false),
                asLine(false, false, false)
        );
        Ladder ladder = Ladder.of(lines.size(), actual.size(), lines);

        // when
        ladder.run(actual);

        // then
        Players expected = new Players(providePlayers(0, 3, 2, 1));
        assertEquals(expected, actual);
    }

    private List<Player> providePlayers(int index0, int index1, int index2, int index3) {
        return Arrays.asList(
                Player.of("honux", Lane.of(index0)),
                Player.of("pobi", Lane.of(index1)),
                Player.of("crong", Lane.of(index2)),
                Player.of("jk", Lane.of(index3))
        );
    }
}
