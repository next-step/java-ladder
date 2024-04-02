package ladder.model.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringToListConverterTest {
    @ParameterizedTest
    @ValueSource(strings = {"jk,hong,poni", "jk, hong, poni"})
    @DisplayName("리스트로 바꿀 이름 문자열은 ','로 구분하며 빈칸 여부는 영향을 주지 않는다. ")
    void make_list(String input) {
        assertThat(StringToListConverter.toList(input)).isEqualTo(Arrays.asList("jk", "hong", "poni"));
    }

}
