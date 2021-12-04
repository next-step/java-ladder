package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class HeightTest {
    @Test
    @DisplayName("최소2 최대 10 까지 높이를 설정할수 있다.")
    public void validHeight(){
        Assertions.assertAll(
                () -> assertThat(new Height(2)).isEqualTo(new Height(2)),
                () -> assertThat(new Height(10)).isEqualTo(new Height(10))
        );
    }

    @Test
    @DisplayName("최솟값 확인")
    public void checkMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Height(1);

            fail("최솟값 에러가 발생해야한다.");
        });
    }

    @Test
    @DisplayName("최댓값 확인")
    public void checkMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Height(11);

            fail("최댓값 에러가 발생해야한다.");
        });
    }
}
