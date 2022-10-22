package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    @DisplayName("생성자에 참여할 사람이 없거나, null이면 예외가 발생한다.")
    void peopleNullOrEmptyException() {
        assertThatThrownBy(() -> new Ladder(null, 5))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(new ArrayList<>(), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리의 높이가 1보다 작은 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 0})
    void heightLessThanOne(int height) {
        assertThatThrownBy(() -> new Ladder(Arrays.asList(new Person("서강준"), new Person("한예슬")), height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("만들어진 사다리의 높이를 조회한다.")
    void getHorizontalLines() {
        assertThat(new Ladder(Arrays.asList(new Person("서강준"), new Person("한예슬")), 5).horizontalLines())
                .hasSize(5);
    }
}
