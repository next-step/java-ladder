package nextstep.study3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.Height;

class HeightTest {
	
	private Height height;
	
	@Test
	@DisplayName("사다리의 높이 검증하는 테스트 메소드")
	void 사다리의_높이는_1보다_커야된다() {
		
		int 사다리의_최소_높이 = 0;
		
		assertThatThrownBy(() -> height = new Height(사다리의_최소_높이))
		.isInstanceOf(IllegalArgumentException.class);		
	}	
	
	@Test
	@DisplayName("사다리의 높이가 같은지 검증")
	void 사다리의_높이가_같은지_검증() {
		Height height = new Height(50);
		Height height1 = new Height(50);
		
		assertThat(height).isEqualTo(height1);
		assertThat(height.getHeight()).isEqualTo(height1.getHeight());
	}
}
