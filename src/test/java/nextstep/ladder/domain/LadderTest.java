package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class LadderTest {
    private CrossingPointsCreator crossingPointsCreator;
    private List<CrossingPoints> crossingPointsForLines;
    private Lines lines;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        crossingPointsCreator = new CrossingPointsCreator(new RandomDirectionStrategy());
        crossingPointsForLines = crossingPointsCreator.create(4, 5);
        lines = Lines.from(crossingPointsForLines);
        ladder = new Ladder(lines);
    }

    @Test
    @DisplayName("라인 목록을 인자로 받아 사다리를 생성한다.")
    public void create() throws Exception {
        assertThat(ladder.height().value()).isEqualTo(5);
    }

    @Test
    @DisplayName("플레이어의 이름 목록과 결과 목록을 인자로 받아 매핑시킨 객체를 반환한다.")
    public void map() throws Exception {
        //given
        Players players = new Players("pobi", "kobi", "dobi", "ddubi");
        Prizes prizes = new Prizes(4, "꽝", "5000", "꽝", "3000");

        //when
        MatchedResult matchedResult = ladder.map(players.names(), prizes.names());

        then(matchedResult.size()).isEqualTo(4);
    }
}