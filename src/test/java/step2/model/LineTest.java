package step2.model;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.ganerator.LadderGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

/*
- 사다리 한줄 생성할 시 첫번째 계단은 무조건 false 이고 각 라인은 겹치지않는다.
- 인원수대로 라인을 생성한다.
- 좌우로 살피고 true인 라인으로 옮긴다.
*/
public class LineTest {

    @DisplayName("사다리 한줄 생성할 시 첫번째 계단은 무조건 false 이고 이고 각 라인은 겹치지않는다.")
    @Test
    void createLineTest() {
        Line line = Line.createLine(Person.createPerson("pobi,honux,crong,jk"), () -> true);

        assertThat(line.getPoints())
                .extracting("left", "right")
                .containsExactly(
                        tuple(false, true),
                        tuple(true, false),
                        tuple(false, true),
                        tuple(true, false)
                );
    }

    @DisplayName("인원수대로 라인을 생성한다.")
    @Test
    void createLinePersonTest() {
        Line line = Line.createLine(Person.createPerson("pobi,honux,crong,jk"), new LadderGenerator());
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @DisplayName("좌우로 살피고 true인 라인으로 옮긴다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0"}, delimiter = ':')
    void getLineForwardTest(int currentIndex, int endIndex) {
        Line line = Line.createLine(Person.createPerson("pobi,honux,crong,jk"), () -> true);
        assertThat(line.getLineForward(currentIndex)).isEqualTo(endIndex);
    }
}
