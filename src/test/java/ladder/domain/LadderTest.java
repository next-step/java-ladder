package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

//    사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
//    사람 이름은 쉼표(,)를 기준으로 구분한다.
//    사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
//    사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
//|-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

    @Test
    @DisplayName("사다리 생성 테스트")
    void ladderTest(){
        final List<String> playersNames = List.of("david", "J", "lee");
        final Ladder ladder = new Ladder(playersNames, 5);

        assertThat(ladder.height()).isEqualTo(5);
        assertThat(ladder.width()).isEqualTo(2);

        assertThatThrownBy(() ->
                new Ladder(List.of("david"), 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 생성에 필요한 참가자는 최소 2명 이상이어야 합니다.");

        assertThatThrownBy(() ->
                new Ladder(List.of("david", "J"), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 2 이상이어야 합니다.");

    }
}
