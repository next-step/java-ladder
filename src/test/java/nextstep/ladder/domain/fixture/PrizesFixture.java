package nextstep.ladder.domain.fixture;

import nextstep.ladder.domain.prizes.Prize;
import nextstep.ladder.domain.prizes.Prizes;

import java.util.Arrays;

public class PrizesFixture {
    public static Prizes TestPrizes = new Prizes(
            Arrays.asList(
                    new Prize("꽝"),
                    new Prize("5000"),
                    new Prize("꽝"),
                    new Prize("3000")));
}
