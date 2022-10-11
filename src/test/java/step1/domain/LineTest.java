package step1.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LineTest {

    @Test
    @DisplayName("Line의 길이와 bridges의 개수 틀리면 에러 발생")
    void validateLine() {
        List<Bridge> bridges = List.of(new Bridge(false), new Bridge(false), new Bridge(true));
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(bridges, new Height(bridges.size() - 1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(bridges, new Height(bridges.size() + 1)));
    }

    @Test
    @DisplayName("Line의 길이와 bridges의 개수 같으면 정상 생성")
    void construct() {
        List<Bridge> bridges = List.of(new Bridge(false), new Bridge(false), new Bridge(true));
        then(new Line(bridges, new Height(bridges.size()))).isEqualTo(Line.from(bridges));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("입력한 인덱스에 일치하는 패스 컨디션이 반환되는지 테스트")
    void getBridgeByIdx(int idx) {
        List<Bridge> bridges = List.of(new Bridge(false), new Bridge(false), new Bridge(true));
        then(Line.from(bridges).getBridgeByIdx(idx)).isEqualTo(bridges.get(idx));
    }

    @Test
    @DisplayName("라인 Bridge 중복 체크 테스트")
    void isDuplicatedLine() {
        Line line = Line.from(List.of(new Bridge(true), new Bridge(false)));
        then(line.isDuplicatedLine(Line.from(List.of(new Bridge(true), new Bridge(false))))).isTrue();
        then(line.isDuplicatedLine(Line.from(List.of(new Bridge(false), new Bridge(false))))).isFalse();
    }
}