package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

	@Test
	@DisplayName("라인이 겹칠 때 생성 불가 테스트")
	void lineOverLabTest() {
		assertThatThrownBy(() -> Line.from(List.of(true, true)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("중복");
	}

	@Test
	@DisplayName("라인 생성 테스트")
	void lineConstructTest() {
		Line line = Line.from(List.of(false, true));
		assertThat(line.pointToBoolean()).containsExactly(false, true);
	}

    @Test
    @DisplayName("라인 오른쪽으로 갈 수 있는지 테스트")
    void lineRightMovableTest() {
		Line line = Line.from(List.of(false, true));
        assertThat(line.rightIsMovable(new Position(1))).isTrue();
    }

    @Test
    @DisplayName("라인 왼쪽으로 갈 수 있는지 테스트")
    void lineleftMovableTest() {
		Line line = Line.from(List.of(false, true));
        assertThat(line.leftIsMovable(new Position(1))).isFalse();
    }

}
