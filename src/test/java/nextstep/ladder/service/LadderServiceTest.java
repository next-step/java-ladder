package nextstep.ladder.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Point;
import nextstep.ladder.dto.LadderResultDto;

class LadderServiceTest {
	private LadderService ladderService;

	@BeforeEach
	void beforeEach() {
		ladderService = new LadderServiceImpl();
	}

	/**
	 * a     b     c     d
	 * |     |-----|     |
	 * |-----|     |-----|
	 * |     |-----|     |
	 * |-----|     |-----|
	 * 0     1     2     3
	 */
	@Test
	void calculateResult() {
		// given
		List<Line> lines = Arrays.asList(
			Line.create(Arrays.asList(
				Point.create(false, false),
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, false)
			)),
			Line.create(Arrays.asList(
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, true),
				Point.create(true, false)
			)),
			Line.create(Arrays.asList(
				Point.create(false, false),
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, false)
			)),
			Line.create(Arrays.asList(
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, true),
				Point.create(true, false)
			))
		);
		Ladder ladder = Ladder.create(lines);

		List<String> names = Arrays.asList("a", "b", "c", "d");
		Participants participants = Participants.createWithNames(names);

		List<String> results = Arrays.asList("0", "1", "2", "3");
		ExecutionResult executionResult = ExecutionResult.create(results);

		// when
		LadderResultDto resultDto = ladderService.calculateResult(ladder, participants, executionResult);

		// then
		assertAll(
			() -> assertThat(resultDto.getResult("a")).isEqualTo(executionResult.getResult(3)),
			() -> assertThat(resultDto.getResult("b")).isEqualTo(executionResult.getResult(2)),
			() -> assertThat(resultDto.getResult("c")).isEqualTo(executionResult.getResult(1)),
			() -> assertThat(resultDto.getResult("d")).isEqualTo(executionResult.getResult(0))
		);
	}
}
