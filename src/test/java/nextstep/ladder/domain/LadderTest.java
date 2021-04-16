package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class LadderTest {

    @Test
    @DisplayName("플레이어 수, 사다리 높이, 방향 생성 전략을 인자로 받아 사다리를 생성한다.")
    public void create() throws Exception {
        Ladder ladder = new Ladder(4, 5, new RandomDirectionStrategy());
        assertThat(ladder.height().value()).isEqualTo(5);
    }

    @Test
    @DisplayName("플레이어의 이름 목록과 결과 목록을 인자로 받아 매핑시킨 객체를 반환한다.")
    public void map() throws Exception {
        //given
        Ladder ladder = new Ladder(4, 5, new RandomDirectionStrategy());
        Players players = new Players("pobi", "kobi", "dobi", "ddubi");
        Prizes prizes = new Prizes(4, "꽝", "5000", "꽝", "3000");

        //when
        MatchedResult matchedResult = ladder.map(players.names(), prizes.names());

        then(matchedResult.size()).isEqualTo(4);
    }
}