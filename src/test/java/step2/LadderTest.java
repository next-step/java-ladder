package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step2.domain.LadderType.LEFT;
import static step2.domain.LadderType.RIGHT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.Ladder;
import step2.domain.LadderType;
import step2.domain.LineStrategy;
import step2.domain.Prize;
import step2.domain.Prizes;
import step2.domain.Result;
import step2.domain.Users;

public class LadderTest {

    private Ladder ladder;
    private Users users;
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        this.ladder = new Ladder(1, 2, new LineStrategy() {
            @Override
            public LadderType next() {
                return RIGHT;
            }

            @Override
            public LadderType next(LadderType prev) {
                if (prev == RIGHT) {
                    return LEFT;
                }
                return next();
            }
        });
        this.users = new Users("pobi,crong");
        this.prizes = new Prizes("꽝,당첨");
    }

    @Test
    void play() {
        Result result = ladder.play(users);
        result.reformat(users, prizes);
        Prize prize = result.prize(users.find("pobi"));

        assertEquals("당첨", prize.product().value());
    }
}
