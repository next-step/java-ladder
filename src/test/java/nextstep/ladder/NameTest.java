package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nextstep.fp.Car;
import nextstep.ladder.domain.Name;

public class NameTest {

	@Test
	public void 이름_짓기() {
		Name name =new Name("sara");
		assertThat(name.getName()).isEqualTo("sara");
	}

	@Test
	public void 이름_5자리_초과할_경우() {
		assertThatThrownBy(() -> new Name("unicorn")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 이름이_비어있을_경우() {
		assertThatThrownBy(() -> new Name(" ")).isInstanceOf(IllegalArgumentException.class);
	}
}
