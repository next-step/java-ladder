package domain;

import org.junit.Test;
import util.GenerateLine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 테스트를 위해서 GenerateLine 인터페이스 구현
 */
class TestGenerateLadderLine implements GenerateLine {

    @Override
    public Point fromRandom() {
        return Point.EXIST;
    }

    @Override
    public Point fromMiddle(final Line line, final int sequence) {
        return Point.NONE;
    }

    @Override
    public Point fromLast() {
        return Point.NONE;
    }

}

@SuppressWarnings("NonAsciiCharacters")
public class LadderTest {

    @Test
    public void 첫번쨰_참가자의_보상_번호_구하기() {
        final Players players = new Players("홍길동,홍길순,나인제로,둘리");
        final Ladder ladder = new Ladder(players, 5, new TestGenerateLadderLine());
        final int reward = ladder.move(players.findByName("홍길동"));
        assertThat(reward).isEqualTo(1);
    }

    @Test
    public void 두번쨰_참가자의_보상_번호_구하기() {
        final Players players = new Players("홍길동,홍길순,나인제로,둘리");
        final Ladder ladder = new Ladder(players, 4, new TestGenerateLadderLine());
        final int reward = ladder.move(players.findByName("홍길순"));
        assertThat(reward).isEqualTo(1);
    }

    @Test
    public void 모든_참가자의_보상_번호_구하기() {

        final Players players = new Players("홍길동,홍길순,나인제로,둘리");
        final Ladder ladder = new Ladder(players, 4, new TestGenerateLadderLine());

        final int reward1 = ladder.move(players.findByName("홍길동"));
        assertThat(reward1).isEqualTo(0);

        final int reward2 = ladder.move(players.findByName("홍길순"));
        assertThat(reward2).isEqualTo(1);

        final int reward3 = ladder.move(players.findByName("나인제로"));
        assertThat(reward3).isEqualTo(2);

        final int reward4 = ladder.move(players.findByName("둘리"));
        assertThat(reward4).isEqualTo(3);
    }

}