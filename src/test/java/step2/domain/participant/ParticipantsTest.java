package step2.domain.participant;

import org.junit.jupiter.api.Test;
import step2.domain.Coordinate;
import step2.exception.LadderGameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

	@Test
	void constructionTest() {
		Participant participant1 = new Participant("ted", new Coordinate(0));
		Participant participant2 = new Participant("wil", new Coordinate(1));
		assertThat(new Participants(new Participant[]{participant1, participant2})).isEqualTo(new Participants(new Participant[]{participant1, participant2}));
	}

	@Test
	void constructionFailTest() {
		Participant participant1 = new Participant("ted", new Coordinate(0));
		Participant participant2 = new Participant("ted", new Coordinate(1));
		assertThrows(LadderGameException.class, () -> new Participants(new Participant[]{participant1, participant2}));
	}

}
