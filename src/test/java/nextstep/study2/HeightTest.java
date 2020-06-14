package nextstep.study2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.Height;

class HeightTest {
	
	Height height;
	Height height1;
	
	@Test
	@DisplayName("사다리의 높이 검증하는 테스트 메소드")
	void 사다리의_높이는_1보다_커야된다() {
		
		assertThatThrownBy(() -> height = new Height(0))
		.isInstanceOf(IllegalArgumentException.class);
		
	}
	
	
	@Test
	@DisplayName("사다리의 높이 테스트")
	void 테스트() {
		height = new Height(50);
		height1 = new Height(50);
		
		assertThat(height).isEqualTo(height1);
	}
}
