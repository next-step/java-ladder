package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineGeneratorTest {

	@Test
	@DisplayName("라인 생성 예외")
	void generate_exception() throws Exception {
		//given
		int playerCount = 0;

		//when


		//then
		assertThatThrownBy(() -> LineGenerator.generate(playerCount)).isInstanceOf(LineCountException.class)
		                                                             .hasMessage("라인은 1개 이상 생성 가능합니다.");

	}


	@ParameterizedTest(name = "생성된 라인 수 {index} [{arguments}]")
	@ValueSource(ints = {1, 10})
	@DisplayName("생성된 라인 수 테스트")
	void line_size(int size) throws Exception {
		//given

		//when
		List<Boolean> actual = LineGenerator.generate(size);

		//then
		assertThat(actual).hasSize(size);
	}

}