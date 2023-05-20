package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class UserNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    public void 이름_생성_테스트(String name) throws Exception {
        assertThat(UserName.of(name)).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    public void 이름_NULL_테스트(String name) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> UserName.of(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi_name", "honux_name", "crong_name", "jk_name"})
    public void 이름_최대길이_테스트(String name) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> UserName.of(name));
    }
}
