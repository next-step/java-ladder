package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

	@DisplayName("사다리 게임 결과 값들을 포장하는 일급 콜렉션 Prizes 객체를 생성한다.")
	@Test
	void create() {
		Prizes prizes = Prizes.from("꽝,1000,5000,10000");
		assertThat(prizes).isEqualTo(Prizes.from("꽝,1000,5000,10000"));
	}

	@DisplayName("최종 사다리 지점에 해당하는 Prize를 가져온다.")
	@Test
	void of() {
		Prizes prizes = Prizes.from("꽝,1000,5000,10000");
		assertThat(prizes.of(0)).isEqualTo(new Prize("꽝"));
		assertThat(prizes.of(1)).isEqualTo(new Prize("1000"));
		assertThat(prizes.of(2)).isEqualTo(new Prize("5000"));
		assertThat(prizes.of(3)).isEqualTo(new Prize("10000"));
	}

}
