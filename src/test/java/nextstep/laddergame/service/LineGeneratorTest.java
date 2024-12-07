package nextstep.laddergame.service;

import nextstep.laddergame.domain.Line;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {
    @DisplayName("사다리 라인들이 모든 층에 세팅되지 않았는지 확인한다.")
    @CsvSource(value = {"false,true", "true,false"})
    @ParameterizedTest(name = "사다리 전체 라인 세팅 여부: {0}, 모든 층에 세팅되지 않았는가?: {1}")
    void isAllNonSet(boolean lineSettingYN, boolean expected) {
        List<Boolean> given = List.of(false, false, lineSettingYN);
        LineGenerator lineGenerator = lineCount -> new Line(given);

        boolean actual = lineGenerator.isAllNonSet(given);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("LineGenerator 구현체는 인자로 전달받은 갯수만큼 Cross 객체를 생성하고 Line 객체를 반환한다.")
    @Test
    void generate() {
        LineGenerator lineGenerator = new RandomLineGenerator();
        Line actual = lineGenerator.generate(3);

        assertThat(actual).extracting("crosses", as(InstanceOfAssertFactories.LIST))
                .hasSize(3)
                .extracting("position")
                .contains(0, 1, 2);
    }
}
