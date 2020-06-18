package nextstep.step2;

import nextstep.step2.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Names 클래스 테스트")
public class NamesTest {

    @Test
    @DisplayName("이름이 5자가 넘으면 에러가 나는 테스트")
    void validateNameLengthTest() {
        String names = "pobi12,honux1,crong1,jk1234";
        assertThatIllegalArgumentException().isThrownBy(() -> new Names(names));
    }
}
