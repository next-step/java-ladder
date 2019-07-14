package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderLineTest {
    int ladderSize = 4;

    @Test
    @DisplayName("init 을 통해 LadderLine 을 생성할 수 있다")
    void init() {
        LadderLine ladderLine = LadderLine.init(ladderSize);
        assertThat(ladderLine.size()).isEqualTo(ladderSize);
    }

    @Test
    @DisplayName("ladderSize 가 2 미만이면 에러")
    void initError() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LadderLine.init(1));
    }

    @Test
    @DisplayName("move 를 통해 사다리가 있는 경우는 알맞은 위치로 이동")
    void move() {
        LadderLine ladderLine = LadderLine.init(ladderSize);
        /*
        이 부분을 테스트 하기 위해서는, ladderLine 이 명확하게 초기화가 되어야 할 것 같습니다.
        그러나 현 코드에서는 RandomGenerator 를 사용하고 있기 때문에 어떤 값으로 초기화 될 지 알 수 없습니다.

        제가 생각하기엔 원하는 값으로 초기화를 위해서는 LadderLine 의 RandomGenerator 를 Interface 로 추상화를 하고,
        임의로 랜덤이 아닌 값을 넣고, Point 에서의 next() 도 명시적으로 인자를 넣어서 초기화를 해야 할 것 같습니다.

        이전에는 이렇게 하는게 이상하지 않았는데, 최근에 자바지기님이 최대한 객체에 메세지를 보내서 해결을 하라는 이야기를 듣고 나서
        저 방식대로 짜려 하니 뭔가 이상한 느낌이 드는것 같습니다.
        제가 잘못 생각을 하고 있는걸까요?
        어떻게 해야 이 테스트도 쉽게 가능하고, 좋은 객체지향적인 구조가 되는지 궁금합니다.
         */
    }
}
