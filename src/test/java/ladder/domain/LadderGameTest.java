package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

	private Ladder ladder;
	private Names names;

	@BeforeEach
	void before() {
		this.ladder = Ladder.of(
			Line.of(Crosses.of(true, false, true)),
			Line.of(Crosses.of(false, true, false)),
			Line.of(Crosses.of(true, false, false)),
			Line.of(Crosses.of(false, true, false)),
			Line.of(Crosses.of(true, false, true))
		);
		this.names = new Names("pobi,honux,crong,jk");
	}

	@DisplayName("유효한 값으로 래더게임 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		LadderGame ladderGame = new LadderGame();
		assertThat(ladderGame).isEqualTo(new LadderGame());
	}

	@DisplayName("래더게임의 실행 결과를 만든다.")
	@Test
	void test2() {
		Results results = new Results("꽝,5000,꽝,3000", this.names);
		LadderGame ladderGame = new LadderGame();
		ladderGame.start(this.ladder, this.names);
		ResultsBoard actual = ladderGame.makeResultsBoard(this.names, results);
		ResultsBoard expected = new ResultsBoard(new LinkedHashMap<>(){{
			put(new Name("pobi"), new Result("꽝"));
			put(new Name("honux"), new Result("3000"));
			put(new Name("crong"), new Result("꽝"));
			put(new Name("jk"), new Result("5000"));
		}});

		assertThat(actual).isEqualTo(expected);
	}
}
