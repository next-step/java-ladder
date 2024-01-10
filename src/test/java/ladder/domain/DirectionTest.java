package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.util.ManualPointGenerator;
import ladder.util.PointGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public final class DirectionTest {
	private static final PointGenerator POINT_GENERATOR = new ManualPointGenerator();

	private Direction direction;

	@BeforeEach
	void create() {
		direction = Direction.first(POINT_GENERATOR.generate());
	}

	@Test
	@DisplayName("사다리 생성 확인")
	void 사다리_생성() {
		assertThat(direction.isRight()).isTrue();
	}

	@Test
	@DisplayName("사다리의 이전 죄표가 연결되어 있을 경우 다음 좌표는 연결하지 않음")
	void 사다리_다음_좌표_연결_확인() {
		Direction result = direction.next(POINT_GENERATOR.generate());

		assertThat(result.isRight()).isFalse();
	}

	@Test
	@DisplayName("사다리 좌표가 어디로 이동할 수 있는지 리턴")
	void 이동_위치_확인() {
		assertThat(direction.move()).isEqualTo(1);
	}
}
