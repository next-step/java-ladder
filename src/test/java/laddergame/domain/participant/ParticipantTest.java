package laddergame.domain.participant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import laddergame.domain.Coordinate;
import laddergame.exception.LadderGameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

	@Test
	void constructionTest() {
		String givenName = "ted";
		Coordinate givenCoordinate = new Coordinate(0);
		assertThat(new Participant(givenName, givenCoordinate)).isEqualTo(new Participant(givenName, givenCoordinate));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void constructionFailTestByEmptyName(String given) {
		Coordinate givenCoordinate = new Coordinate(0);
		assertThrows(LadderGameException.class, () -> new Participant(given, givenCoordinate));
	}

	@Test
	void constructionFailTestByOverMaxLength() {
		String length6 = "ted123";
		Coordinate givenCoordinate = new Coordinate(0);
		assertThrows(LadderGameException.class, () -> new Participant(length6, givenCoordinate));
	}

}
