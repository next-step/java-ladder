package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class HeightTest {

    @Test
    void 정상_생성(){
        Height height = new Height(2);
        assertThat(height.getHeight()).isEqualTo(2);
    }

    @Test
    void 높이_1미만_생성시_에러발생(){
        assertThatThrownBy(()-> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("높이는 1보다 작을 수 없습니다.");
    }

}