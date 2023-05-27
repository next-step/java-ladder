package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class UserNameTest {

    public static final UserName POBI = UserName.of("pobi");
    public static final UserName HONUX = UserName.of("honux");
    public static final UserName CRONG = UserName.of("crong");

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    public void 이름_생성_테스트(String name) throws Exception {
        assertThat(UserName.of(name)).isNotNull()
                .isInstanceOf(UserName.class);
    }

    @ParameterizedTest
    @NullSource
    public void 이름_생성_null_테스트(String name) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> UserName.of(name));
    }

    @ParameterizedTest
    @EmptySource
    public void 이름_생성_공백_테스트(String name) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> UserName.of(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi_name", "honux_name", "crong_name", "jk_name"})
    public void 이름_최대길이_테스트(String name) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            UserName.of(name);
        });
    }
}
