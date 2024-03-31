package ladder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameListTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "이름, 민수"})
    @DisplayName("이름이 영어가 아닌 경우 에러")
    void name_is_english(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameList(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"himyname,ischjy"})
    @DisplayName("이름 길이가 5 초과인 경우 에러")
    void check_name_length(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameList(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"judy ,judy"})
    @DisplayName("이름 중복시 에러")
    void check_dup_name(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameList(input);
        });
    }

}
