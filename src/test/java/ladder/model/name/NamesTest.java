package ladder.model.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    @DisplayName("생성된 list 사이즈가 0일때 예외발생 테스트")
    void sizeZeroException() {
        namesExceptionThrown(",,,,,,,", "이름이 null 이거나 비어있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4", "1,2,2,3,4", "2,4,2,5,2,6"})
    @DisplayName("중복된 이름이 있을 때 예외발생 테스트")
    void nameDuplicateException(String names) {
        namesExceptionThrown(names, "중복된 이름이 있습니다.");
    }

    private void namesExceptionThrown(String names, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(names).get())
                .withMessage(message);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5|5", "1,2,3|3", "1|1"}, delimiter = '|')
    @DisplayName("값에 따라 생성된 리스트 사이즈 확인")
    void createdListSizeTest(String names, int size) {
        List<Name> list =  new Names(names).get();
        assertThat(list.size()).isEqualTo(size);
    }
}
