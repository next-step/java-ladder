package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Line;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {


    @DisplayName("사람의 수만큼 Horizontal Line을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void generateLineTest(int countOfPerson) {
        assertThat(new Line(countOfPerson).getPoints()).hasSize(countOfPerson - 1);
    }

    @DisplayName("라인 생성 전략(라인을 만들지 않음)에 따라 적절한 return을 한다.")
    @Test
    void shouldNotGenerateHorizontal() {
        final int countOfPerson = 5;
        Line emptyLine = new Line(countOfPerson, count -> List.of(false, false, false, false));
        assertThat(emptyLine.getPoints()).containsExactlyElementsOf(List.of(false, false, false, false));

        Line fullLine = new Line(countOfPerson, count -> List.of(true, true, true, true));
        assertThat(fullLine.getPoints()).containsExactlyElementsOf(List.of(true, true, true, true));
    }
}
