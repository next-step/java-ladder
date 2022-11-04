package ladder.domain.ladder;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.size.LadderHeight;
import ladder.domain.ladder.size.LadderWidth;

public class LadderLineFactory {

    private static final SecureRandom random = new SecureRandom();

    public LadderLines randomLadderLines(LadderWidth ladderWidth, LadderHeight ladderHeight) {
        return new LadderLines(IntStream.range(0, ladderHeight.height())
                .mapToObj(i -> randomLadderLine(ladderWidth))
                .collect(Collectors.toList()));
    }

    public LadderLine randomLadderLine(LadderWidth ladderWidth) {
        List<HorizontalLineDirection> horizontalLineDirections = new ArrayList<>();

        HorizontalLineDirection currentHorizontalDirection
                = HorizontalLineDirection.first().get(random.nextInt(HorizontalLineDirection.first().size()));
        horizontalLineDirections.add(currentHorizontalDirection);

        for (int i = 1; i < ladderWidth.lastLadderIndex(); i++) {
            currentHorizontalDirection
                    = currentHorizontalDirection.next().get(random.nextInt(currentHorizontalDirection.next().size()));
            horizontalLineDirections.add(currentHorizontalDirection);
        }

        horizontalLineDirections.add(currentHorizontalDirection.last());

        return new LadderLine(horizontalLineDirections);
    }
}
