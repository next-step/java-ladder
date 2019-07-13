package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 생성에 사용될 가로 라인 생성 테스트")
    void createLine() {
        Line lines = Line.lineSet(5);
        List<Point> points = lines.getPoints();
        for(Point point : points){
            assertThat(
            point.getStatusOfPoint().isLeft()
                   && point.getStatusOfPoint().isRight()
                   && TRUE
            ).isFalse();
        }
    }

    @Test
    @DisplayName("사다리 게임 최소 참여자 2명 미만 일 경우 오류 테스트")
    void minUserCount(){
        Assertions.assertThatThrownBy(() -> Line.lineSet(1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("사다리 게임 참여자는 최소 2명 이상이어야 합니다.");
    }

}
