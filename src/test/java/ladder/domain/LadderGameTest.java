package ladder.domain;

import ladder.dto.GameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private Users users;
    private Ladder ladder;
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        Line line1 = Line.create(List.of(Point.create(Direction.create(false, false), 0), Point.create(Direction.create(false, false), 1)));
        Line line2 = Line.create(List.of(Point.create(Direction.create(false, true), 0), Point.create(Direction.create(true, false), 1)));

        users = Users.create(List.of(User.create("user1"), User.create("user2")));
        ladder = Ladder.create(List.of(line1, line2));
        gameResult = GameResult.create(List.of("1000", "2000"));
    }


    @Test
    void execute() {
        LadderGame ladderGame = new LadderGame(users, ladder, gameResult);
        List<GameResultDto> gameResultDtoList = ladderGame.execute();

        assertThat(gameResultDtoList).contains(new GameResultDto("user1", "2000"));


    }
}
