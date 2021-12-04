package ladder.model.stringas;

import ladder.model.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringAsNamesTest {

    @Test
    @DisplayName("생성된 list 사이즈가 0일때 예외발생 테스트")
    void sizeZeroException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringAsNames(",,,,,,,").get())
                .withMessage("이름이 null 이거나 비어있습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5|5", "1,2,3|3", "1|1"}, delimiter = '|')
    @DisplayName("값에 따라 생성된 리스트 사이즈 확인")
    void sizeZeroException(String names, int size) {
        List<Name> list =  new StringAsNames(names).get();
        assertThat(list.size()).isEqualTo(size);
    }
}