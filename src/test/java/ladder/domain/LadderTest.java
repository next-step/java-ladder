package ladder.domain;

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
}
