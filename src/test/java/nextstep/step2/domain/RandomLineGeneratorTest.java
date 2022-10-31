package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomLineGeneratorTest {

    @DisplayName("마지막 위치의 Point 연결은 무조건 false 반환")
    @ParameterizedTest()
    @ValueSource(ints = {3, 5, 9, 13})
    void test(int position){
        RandomLineGenerator randomLineGenerator = RandomLineGenerator.from(position);
        boolean randomBoolean = randomLineGenerator.createRandomBoolean(position);
        Assertions.assertThat(randomBoolean).isFalse();
    }
}
