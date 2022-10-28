package ladder.domain;

import ladder.dto.InputDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-25
 */
class LadderGameTest {

	@ParameterizedTest
	@CsvSource(value = {"a,1000", "b,200", "c,꽝"})
	void 생성(String name, String result) {
		Ladder ladder = new Ladder(List.of(
			new LadderRow(3, () -> true),
			new LadderRow(3, () -> false),
			new LadderRow(3, () -> true),
			new LadderRow(3, () -> false)));

		InputDTO inputDTO = InputDTO.from("a,b,c", 4, "꽝,1000,200");
		LadderGameResults ladderGameResults = inputDTO.getLadderGameResults();

		LadderGame game = new LadderGame();
		Persons persons = game.start(ladder, inputDTO);
		LadderGameResult gameResult = ladderGameResults.get(persons.get(name));

		assertThat(gameResult).isEqualTo(LadderGameResult.of(result));
	}
}
