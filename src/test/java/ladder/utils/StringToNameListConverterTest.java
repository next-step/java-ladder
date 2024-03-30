package ladder.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringToNameListConverterTest {
    @ParameterizedTest
    @ValueSource(strings = {"jk,hong,poni", "jk, hong, poni"})
    @DisplayName("리스트로 바꿀 이름 문자열은 ','로 구분하며 빈칸 여부는 영향을 주지 않는다. ")
    void make_list(String input) {
        assertThat(StringToNameListConverter.toList(input)).isEqualTo(Arrays.asList("jk", "hong", "poni"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "이름, 민수"})
    @DisplayName("영어가 아닌 값 입력시 에러")
    void name_is_english(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringToNameListConverter.toList(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"himyname,ischjy"})
    @DisplayName("영어가 아닌 값 입력시 에러")
    void check_name_length(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringToNameListConverter.toList(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"judy ,judy"})
    @DisplayName("이름 중복시 에러")
    void check_dup_name(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringToNameListConverter.toList(input);
        });
    }

}
