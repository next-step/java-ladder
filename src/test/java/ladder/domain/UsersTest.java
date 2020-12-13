package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {

    @Test
    @DisplayName("참여자 이름이 공백일 경우 IllegalArgumentException 발생")
    void users_empty_throwIllegalArgumentException() {
        assertThatThrownBy(() -> Users.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름을 입력해야 합니다");
    }

    @Test
    @DisplayName("참여자 이름이 Null 일경우 IllegalArgumentException 발생")
    void users_null_throwIllegalArgumentException() {
        assertThatThrownBy(() -> Users.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름을 입력해야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "git,atom,slack:git,atom,slack",
            "java,c#,react:java,c#,react",
            "yoon,jin,seul:yoon,jin,seul"
    }, delimiter = ':')
    @DisplayName("콤마로 구분된 이름들을 가진 문자열로 Users 객체 생성시 동일한 객체인지 비교")
    void users_sameArrayNames_isEqualTo(String actualNames, String expectNames) {
        Users actual = Users.of(actualNames);
        Users expect = Users.of(expectNames);

        assertThat(actual).isEqualTo(expect);
    }
}
