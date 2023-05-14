package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Name 클래스 테스트")
public class NameTest {

    @Test
    @DisplayName("Name_생성_테스트")
    public void Name_생성_테스트() {
        Name name = new Name("test");
        assertThat(name.toString()).isEqualTo("test");
    }


    @ParameterizedTest(name = "[index] name = {0}")
    @NullAndEmptySource
    @DisplayName("Name_Null_Black_테스트")
    public void Name_Null_Black_테스트(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Name person = new Name(name);
                });
    }

    @Test
    @DisplayName("5글자_초과_테스트")
    public void 글자_초과_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Name person = new Name("overfive");
                });
    }
}
