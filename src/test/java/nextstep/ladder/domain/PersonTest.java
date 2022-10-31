package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    @DisplayName("참여하는 사람의 이름(최대 5자)을 설정한다.")
    void checkPersonName() {
        assertThat(new Person("서강준").name())
                .isEqualTo("서강준");
    }

    @Test
    @DisplayName("참여하는 사람의 이름이 최대 5자가 넘으면 예외가 발생한다.")
    void personNameLengthException() {
        assertThatThrownBy(() -> new Person("seokangjun"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("참여하는 사람의 이름이 null 또는 공백일 경우 예외가 발생한다.")
    @MethodSource("nullOrEmptyOfPersonName")
    void personNameNullOrEmptyException(String name) {
        assertThatThrownBy(() -> new Person(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    private static String[] nullOrEmptyOfPersonName() {
        return new String[] {null, ""};
    }
}
