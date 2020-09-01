package laddergame.domain.result;

import laddergame.domain.Coordinate;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

	private final String[] participantsNames = new String[]{"A", "B"};
	private final String[] participantsNames2 = new String[]{"A", "B", "C"};
	private final String[] prizeNames = new String[]{"꽝", "당첨"};

	@DisplayName("객체 생성 테스트")
	@Test
	void constructionTest() {
		assertThat(new Prizes(prizeNames, participantsNames.length)).isEqualTo(new Prizes(prizeNames, participantsNames.length));
	}

	@DisplayName("객체 생성 실패 테스트 (참가자 수와 당첨의 수가 다를 때)")
	@Test
	void constructionFailTest() {
		assertThrows(LadderGameException.class, () -> new Prizes(prizeNames, participantsNames2.length));
	}

	@DisplayName("좌표를 통해서 원하는 당첨 명을 얻을수 있나 테스트")
	@Test
	void getResultByResultCoordinate() {
		Prizes prizes = new Prizes(prizeNames, participantsNames.length);
		Coordinate secondCoordinate = new Coordinate(1);
		assertThat(prizes.getResultByResultCoordinate(secondCoordinate)).isEqualTo(prizeNames[secondCoordinate.getCoordinate()]);
	}



}
