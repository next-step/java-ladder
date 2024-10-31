package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NamesTest {

    @Test
    public void 분리된이름을_생성한다() {
        Names names = new Names("test1,test2");
        assertThat(names).isEqualTo(new Names(List.of("test1", "test2")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"testaa,test2", "", " ", "test", "test,", "test,test"})
    public void 유효하지_않은_이름입력시_예외가_발생한다(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Names(value));
    }
}
