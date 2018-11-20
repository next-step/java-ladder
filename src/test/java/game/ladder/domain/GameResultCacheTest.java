package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultCacheTest {

    @Test
    public void 만들기() {
        final LinesGenerator generator = new LinesGenerator(new Height(5));
        final Participants participants = createParticipants();
        final Expects expects = createExpects();

        Ladder ladder = createLadder();

        GameResultCache gameResultCache = new GameResultCache(ladder);
    }

    @Test
    public void 동일_결과_확인() {
        final Name name = new Name("a");
        GameResultCache gameResultCache = new GameResultCache(createLadder());

        GameResults result1 = gameResultCache.getGameResults(name);
        GameResults result2 = gameResultCache.getGameResults(name);

        assertThat(result1).isSameAs(result2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 없는_이름_일때() {
        final Name name = new Name("null");
        GameResultCache gameResultCache = new GameResultCache(createLadder());

        gameResultCache.getGameResults(name);
    }

    private Ladder createLadder() {
        final LinesGenerator generator = new LinesGenerator(new Height(5));
        final Participants participants = createParticipants();
        final Expects expects = createExpects();
        final UserInputs userInputs = new UserInputs(participants, expects);

        return new Ladder(generator, userInputs);
    }

    private Participants createParticipants() {
        List<Participant> participants = Arrays.asList(
                new Participant(new Name("a"), new Position(1)),
                new Participant(new Name("b"), new Position(2)),
                new Participant(new Name("c"), new Position(3))
        );

        return new Participants(new TreeSet<>(participants));
    }

    private Expects createExpects() {
        List<Expect> expects = Arrays.asList(
                new Expect("win"),
                new Expect("lose"),
                new Expect("win")
        );

        return new Expects(expects);
    }

}