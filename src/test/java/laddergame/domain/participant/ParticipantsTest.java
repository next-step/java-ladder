package laddergame.domain.participant;

import org.junit.jupiter.api.Test;
import laddergame.domain.coordinate.Coordinate;
import laddergame.exception.LadderGameException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

	@Test
	void constructionTest() {
		Participant participant1 = new Participant("ted", new Coordinate(0));
		Participant participant2 = new Participant("wil", new Coordinate(1));
		assertThat(new Participants(List.of(participant1, participant2))).isEqualTo(new Participants(List.of(participant1, participant2)));
	}

	@Test
	void constructionFailTest() {
		Participant participant1 = new Participant("ted", new Coordinate(0));
		Participant participant2 = new Participant("ted", new Coordinate(1));
		assertThrows(LadderGameException.class, () -> new Participants(List.of(participant1, participant2)));
	}

}
