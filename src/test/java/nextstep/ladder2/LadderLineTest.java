package nextstep.ladder2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 요구사항
 *
 * * 넓이(플레이어 수)를 입력받는다.
 * * 플레이어 수 만큼 Point 들을 생성한다
 * * Point 간 이동을 대리하는 move 메시지를 제공한다.
 */
public class LadderLineTest {
    @Test
    void create() {
        assertThat(LadderLine.of(3).sizeOfPoints()).isEqualTo(3);
    }
}
