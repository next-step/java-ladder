package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderGameTest {
    @Test
    void test_사다리_게임_플레이_테스트() {
        Users users = Users.from(new String[]{"pobi", "honux", "crong"});
        List<Line> lines = List.of(
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(false, true, false))
        );
        List<String> results = List.of("1st", "2nd", "3th");
        Ladder ladder = new Ladder(lines);
        LadderGame ladderGame = new LadderGame(users, ladder, results);

        assertThat(ladderGame.getResult("pobi")).isEqualTo(results.get(1));
        assertThat(ladderGame.getResult("honux")).isEqualTo(results.get(0));
        assertThat(ladderGame.getResult("crong")).isEqualTo(results.get(2));
        assertThatThrownBy(() -> ladderGame.getResult("none"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
