package nextstep.domain;

import domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {

	@DisplayName("Point의 상태를 제대로 반환하는지 확인하는 테스트")
	@Test
	void test_point_status() {
		Point point = new Point(true);
		assertThat(point.status()).isEqualTo(true);
	}
}
