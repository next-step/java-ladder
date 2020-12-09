package ladder.name;

import ladder.model.name.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    public void 최소_길이_오류() {
        assertThatThrownBy(() -> Name.createUserName(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Name.createRewardName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 최대_길이_오류() {
        assertThatThrownBy(() -> Name.createUserName("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("nameParams")
    public void 정상_이름(String inputName, String stringName) {
        assertThat(inputName).isEqualTo(stringName);
    }

    private static Stream<Arguments> nameParams() {
        return Stream.of(
                Arguments.of(Name.createUserName("12345").toString(), "12345"),
                Arguments.of(Name.createRewardName("1").toString(), "1")
        );
    }
}
