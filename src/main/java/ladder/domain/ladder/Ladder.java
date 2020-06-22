package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> ladder;

    private Ladder(int ladderHeight, int countOfPerson) {
        checkLadderHeight(ladderHeight);
        this.ladder = Stream.generate(() -> LadderLine.init(countOfPerson))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public static Ladder valueOf(int ladderHeight, int countOfPerson) {
        return new Ladder(ladderHeight, countOfPerson);
    }

    public int run(int personIndex) {
        int position = personIndex;
        for (LadderLine line : ladder) {
            position = line.move(position);
        }
        return position;
    }

    public List<LadderLine> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("사다리 길이가 0 이하 입니다.");
        }
    }


}
