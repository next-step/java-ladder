package ladder.domain;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LaddersTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
    void 입력한_높이대로_생성_테스트(int height) {
        assertThat(new Ladders(2, height).toString().split("\n").length).isEqualTo(height);
    }
}