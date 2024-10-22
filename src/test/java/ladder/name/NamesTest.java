package ladder.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @DisplayName("특정 인덱스의 이름을 가져올 수 있다.")
    @Test
    void getNameOf() {
        Names names = new Names(List.of("green", "blue", "red"));

        String name = names.getNameOf(0);

        assertThat(name).isEqualTo("green");
    }
    @DisplayName("인덱스가 이름 리스트 범위 밖이면 예외로 처리한다.")
    @Test
    void getNameOfThrowingException() {
        Names names = new Names(List.of("green", "blue", "red"));

        assertThatIllegalArgumentException().isThrownBy(
                () -> names.getNameOf(3)
        );
    }
}
