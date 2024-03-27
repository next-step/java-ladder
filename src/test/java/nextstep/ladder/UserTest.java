package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("[성공] 5글자 이하의 이름을 가지는 사람을 생성한다.")
    void 사람_생성() {
        assertThat((new User("pobi")).getName()).hasSizeLessThan(5);
    }
}
