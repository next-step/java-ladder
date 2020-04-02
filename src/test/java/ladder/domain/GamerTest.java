package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamerTest {
	@ParameterizedTest
	@DisplayName("빈 이름이거나, 6자 이상 이름, null 예외처리")
	@ValueSource(strings = "Longer")
	@EmptySource
	@NullSource
	void expectException(String name){
		assertThatThrownBy(()->Gamer.of(name))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void getNameTest() {
		String name = "tj";
		assertThat(Gamer.of(name).getName())
				.isEqualTo(name);
	}
}
