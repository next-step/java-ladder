package ladder.helper;

import ladder.domain.ladder.LadderLineGenerator;

public class Generator {
    public static LadderLineGenerator ladderLineGenerator() {
        return new LadderLineGenerator() {
            @Override
            public boolean generate(boolean postLine) {
                return !postLine;
            }
        };
    }
}
