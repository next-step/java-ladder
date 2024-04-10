package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;

public class NamesTest {
	@Test
	@DisplayName("이름을 ,구분자로 분리")
	public void 이름_분리() {
		final String[] splitNames = {"sara", "dobi", "jen", "jk"};
		final Names names = new Names(splitNames);
		assertThat(names.getNames()).contains(new Name("sara"), new Name("dobi"));
	}
}
