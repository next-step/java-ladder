package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesTest {

    @Test
    @DisplayName("빈 값을 할당하는 경우 Prizes 객체를 생성하는데 실패한다.")
    void create_with_empty_value() {
        assertThatThrownBy(() -> new Prizes("", 3)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("결과가 한 개 이하인 경우 Prizes 객체를 생성하는데 실패한다.")
    void create_with_one_prize() {
        assertThatThrownBy(() -> new Prizes("x", 3)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("두 항목 이상 필요합니다.");
    }

    @Test
    @DisplayName("결과 개수가 참여자 수와 다른 경우 Prizes 객체를 생성하는데 실패한다.")
    void create_with_different_number() {
        assertThatThrownBy(() -> new Prizes("x,5000,2000,x", 3)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("참여자 수와 동일한 수의 결과가 필요합니다.");
    }

    @Test
    @DisplayName("find 메소드는 입력한 위치에 있는 Prize 객체를 반환한다.")
    void find() {
        Prizes prizes = new Prizes("x,5000,2000", 3);
        assertThat(prizes.find(2)).isEqualTo(new Prize("2000"));
    }
}
