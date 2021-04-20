package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OnlineLadderTest {
    @Test
    @DisplayName("기본동작")
    void init() {
        OnlineLadder onlineLadder = new OnlineLadder(2, 3, new String[]{"bong", "big", "il"});
        assertThat(onlineLadder.points(0).points()).contains(false, true);
    }

    @Test
    @DisplayName("마지막줄 인덱스 이름으로 찾기")
    void lastIndex() {
        int maxVertical = 3;
        OnlineLadder onlineLadder = new OnlineLadder(maxVertical, 3, new String[]{"bong", "big", "il"});
        IntStream.range(0, maxVertical)
                .forEach(i -> System.out.println(onlineLadder.points(i)));
        assertThat(onlineLadder.filter(new Player("bong"))).isEqualTo(0);
    }

    @Test
    @DisplayName("당첨자")
    void winner() {
        int maxVertical = 3;
        OnlineLadder onlineLadder = new OnlineLadder(maxVertical, 3, new String[]{"bong", "big", "il"});
        assertThatThrownBy(() -> {
            onlineLadder.start(new Player("cong"));
        }).isInstanceOf(IllegalArgumentException.class);

        int resultIndex = onlineLadder.start(new Player("bong"));
        System.out.println("resultIndex = " + resultIndex);
    }
}
