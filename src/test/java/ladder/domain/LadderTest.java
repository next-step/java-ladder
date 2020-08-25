package ladder.domain;

import ladder.domain.element.Persons;
import ladder.domain.line.DrawStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private final DrawStrategy testStrategy = (index, indexConsumer) -> indexConsumer.accept(index);
    private final Persons persons = Persons.fromText("pobi,honux,crong,jk");

    @Test
    @DisplayName("주어진 높이로 정상 생성")
    void testLadderLines() {
        // given
        final int height = 10;
        // when
        Ladder lines = new Ladder(persons, height, testStrategy);
        // then
        assertThat(lines.height()).isEqualTo(height);
    }

    @Test
    @DisplayName("print 테스트")
    void testPrintLadderLines() {
        // given
        final String[] lines = {"|-----|-----|-----|", "|-----|-----|-----|"};
        // when
        Ladder ladder = new Ladder(persons, 2, testStrategy);
        // then
        assertThat(ladder.print()).isEqualTo(
                String.join(System.lineSeparator(), lines)
        );
    }

    /**
     * 사다리 결과 테스트
     * |-----|
     * |-----|
     */
    @Test
    @DisplayName("결과 테스트")
    void testLineDown() {
        // given
        Persons persons = Persons.fromText("pobi,honux");
        // when
        Ladder ladder = new Ladder(persons, 2, testStrategy);
        // then
        assertThat(ladder.lineDown(persons.get("pobi"))).isEqualTo(0);
        assertThat(ladder.lineDown(persons.get("honux"))).isEqualTo(1);
    }
}
