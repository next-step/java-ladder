package refactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactor.domain.GamePerson;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamepersonTest {
    @Test
    @DisplayName("객체 생성 비교")
    public void nameEquals() {
        GamePerson name1 = new GamePerson("test");
        GamePerson name2 = new GamePerson("test");
        assertThat(name1).isEqualTo(name2);
    }

    @Test
    @DisplayName("5자 이상 실패 테스트")
    public void nameLengthOver5() {
        assertThatThrownBy(() -> {
            GamePerson name = new GamePerson("fdsfdsfs");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
