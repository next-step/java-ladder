package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.MoveHorizontalDirection;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineFactory {

    private static final SecureRandom random = new SecureRandom();

    public LadderLines randomLadderLines(LadderWidth ladderWidth, LadderHeight ladderHeight) {
        return new LadderLines(IntStream.range(0, ladderHeight.height())
                .mapToObj(i -> randomLadderLine(ladderWidth))
                .collect(Collectors.toList()));
    }

    public LadderLine randomLadderLine(LadderWidth ladderWidth) {
        List<MoveHorizontalDirection> moveHorizontalDirections = new ArrayList<>();

        MoveHorizontalDirection currentHorizontalDirection
                = MoveHorizontalDirection.first().get(random.nextInt(MoveHorizontalDirection.first().size()));
        moveHorizontalDirections.add(currentHorizontalDirection);

        for (int i = 1; i < ladderWidth.lastLadderIndex(); i++) {
            currentHorizontalDirection
                    = currentHorizontalDirection.next().get(random.nextInt(currentHorizontalDirection.next().size()));
            moveHorizontalDirections.add(currentHorizontalDirection);
        }

        moveHorizontalDirections.add(currentHorizontalDirection.last());

        return new LadderLine(moveHorizontalDirections);
    }
}
