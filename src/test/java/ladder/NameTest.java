package ladder;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {

    @Test
    @DisplayName("이름이 빌 경우 에러 발생한다")
    public void name_blank_error() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Name("");
            }).withMessageMatching("사람 이름은 빈값일 수 없습니다");
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 에러 발생한다")
    public void name_exceed_error() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Name("이름이름이름");
            }).withMessageMatching("사람 이름은 5자를 초과할 수 없습니다");
    }

}
