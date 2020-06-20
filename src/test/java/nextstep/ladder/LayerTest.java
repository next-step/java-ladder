package nextstep.ladder;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ladder.domain.Layer;
import ladder.domain.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LayerTest {

    @ParameterizedTest
    @DisplayName("사람수에 따른 라인(|)수 정상 리턴하는지 테스트")
    @ValueSource(ints = {3,6,7,10})
    void makeLineTest(int countOfPerson){
        Layer layer = Layer.of(countOfPerson);
        assertThat(layer.getPoints().size()).isEqualTo(countOfPerson);
    }

    @Test
    @DisplayName("사다리 한개 높이 예외처리 테스트 - 포인트 1개뿐이면 layer 형성 예외처리")
    void validateLayerTest(){
        Point first = Point.of(0,false,true);
        List<Point> points = Lists.list(first);
        assertThatThrownBy(() -> Layer.of(points))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Layer.MINIMUN_POINTS_EXCEPTION);
    }

    @Test
    @DisplayName("사다리 한개 높이 예외처리 테스트2 - 가로라인 겹치면 예외처리")
    void validateLayerTest2(){
        Point first = Point.of(0,false,true);
        Point next = Point.of(1,true,true);
        Point last = Point.of(2,true,false);
        List<Point> points = Lists.list(first, next, last);
        assertThatThrownBy(() -> Layer.of(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Layer.CONNECTED_LINE_EXCEPTION);
    }
}
