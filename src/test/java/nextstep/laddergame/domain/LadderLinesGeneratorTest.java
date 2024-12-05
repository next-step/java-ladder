package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLinesGeneratorTest {
    @DisplayName("사다리 라인들이 모든 층에 세팅되지 않았는지 확인한다.")
    @CsvSource(value = {"false,true", "true,false"})
    @ParameterizedTest(name = "사다리 전체 라인 세팅 여부: {0}, 모든 층에 세팅되지 않았는가?: {1}")
    void isAllNonSet(boolean lineSettingYN, boolean expected) {
        List<Boolean> given = List.of(false, false, lineSettingYN);
        LadderLinesGenerator ladderLinesGenerator = (beforeLadder, maxHeight) -> new Lines();

        boolean actual = ladderLinesGenerator.isAllNonSet(given);

        assertThat(actual).isEqualTo(expected);
    }
}
