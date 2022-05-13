package nextstep.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 카운트갯수만큼_리스트가_생성되는지_확인(int count) {
        assertThat(LadderLineGenerator.generate(count).size()).isEqualTo(count);
    }
}