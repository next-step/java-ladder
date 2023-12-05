package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.lines.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTest {

    @Test
    @DisplayName("사람들의 이름의 길이로 사다리의 폭을 결정한다.")
    void determine_ladder_width() {
        // given
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        // when
        Ladder result = new Ladder(names, createLines());

        // then
        assertThat(result).isEqualTo(new Ladder(5, createLines()));
    }

    private Lines createLines() {
        Line line1 = Line.createLineWithPointStatus(List.of(true, false, true));
        Line line = Line.createLineWithPointStatus(List.of(false, true, false));
        Line line3 = Line.createLineWithPointStatus(List.of(false, false, true));
        return new Lines(List.of(line1, line, line3));
    }

    @ParameterizedTest
    @DisplayName("사다리 타기를 실행해 참가자가 어느 라인에 위치하는지 알려준다")
    @CsvSource(value = {"0, 3", "1, 1", "2, 0", "3, 2"})
    void start_game(int given, int expected) {
        // given
        Ladder ladder = createLadder();

        // when
        List<Participant> result = ladder.startGame(List.of(new Participant("pobi", given)));

        // then
        assertThat(result).isEqualTo(List.of(new Participant("pobi", expected)));
    }

    private Ladder createLadder() {
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        return new Ladder(names, createLines());
    }

    @ParameterizedTest
    @DisplayName("사다리 타기를 실행해 참가자가 어느 라인에 위치하는지 알려준다")
    @CsvSource(value = {"0, 3", "1, 1", "2, 0", "3, 2"})
    void start_game2(int given, int expected) {
        // given
        Ladder ladder = createLadder2();

        // when
        List<Participant> result = ladder.startGame(List.of(new Participant("pobi", given)));

        // then
        assertThat(result).isEqualTo(List.of(new Participant("pobi", expected)));
    }

    private Ladder createLadder2() {
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        return new Ladder(names, createLines2());
    }

    private Lines createLines2() {
        Line line1 = Line.createLineWithPointStatus(List.of(true, false, false, false, true));
        Line line = Line.createLineWithPointStatus(List.of(false, true, false, true, false));
        Line line3 = Line.createLineWithPointStatus(List.of(true, false, true, false, false));
        return new Lines(List.of(line1, line, line3));
    }
}
