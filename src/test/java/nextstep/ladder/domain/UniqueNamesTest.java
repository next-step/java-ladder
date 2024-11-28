package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nextstep.ladder.dto.UniqueNames;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UniqueNamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"testaa,test2", "", " ", "test", "test,", "test,test"})
    public void 유효하지_않은_이름입력시_예외가_발생한다(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UniqueNames(value));
    }
}
