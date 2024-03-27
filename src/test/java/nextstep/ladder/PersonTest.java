package nextstep.ladder;

import nextstep.ladder.exception.PersonNameLengthExceedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    @DisplayName("[성공] 5글자 이하의 이름을 가지는 사람을 생성한다.")
    void 사람_생성() {
        assertThat((new Person("pobi")).getName()).hasSizeLessThan(5);
    }

    @Test
    @DisplayName("[실패] 5글자 초과의 이름을 가지는 사람을 생성하려는 경우 IllegalUserNameLengthException 예외가 발생한다.")
    void 사람_생성_예외() {
        assertThatExceptionOfType(PersonNameLengthExceedException.class)
                .isThrownBy(() -> {
                    new Person("nayeon");
                }).withMessageContaining("사람의 이름은 5글자를 초과할 수 없습니다.");
    }
}
