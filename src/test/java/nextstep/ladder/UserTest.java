package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserTest {
    private static final int DEFAULT_POSITION = 0;

    @Test
    @DisplayName("한줄 사다리에서 정상 결과 출력 테스트")
    public void findLastPosition_test() {
        User user = new User("pobi", DEFAULT_POSITION);
        Ladder ladder = new Ladder(5, 1);
        assertThat(user.findLastPosition(ladder)).isEqualTo(DEFAULT_POSITION);
    }


    @Test
    @DisplayName("5글자 넘으면 에러가 나오는 지 테스트")
    public void length_error_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new User("arnold", 0));
    }


}
