package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    private final DrawStrategy testStrategy = (index, indexConsumer) -> indexConsumer.accept(index);

    @Test
    @DisplayName("사람 수 만큼 정상 생성")
    void testCreateLadderLine() {
        // given
        final int countOfPerson = 10;
        // when
        LadderLine ladderLine = LadderLine.of(countOfPerson, testStrategy);
        // then
        assertThat(ladderLine.countOfPerson()).isEqualTo(countOfPerson);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,|", "2,|-----|", "3,|-----|-----|"
    })
    @DisplayName("print 결과")
    void testLadderLinePrint(int countOfPerson, String printedString) {
        LadderLine ladderLine = LadderLine.of(countOfPerson, testStrategy);
        assertThat(ladderLine.print()).isEqualTo(printedString);
    }
}
