package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    private List<Line> ladder;
    private RightDirection rightDirection;
    public Ladder(int width, int height, RightDirection rightDirection) {
        this.rightDirection = rightDirection;
        initLadder(width, height);
    }

    private void initLadder(int width, int height) {
        ladder = new ArrayList<>();
        // todo refactor
        for(int i = 0; i < height; i++) {
            ladder.add(new Line(width, rightDirection));
        }
        // todo refactor
        for(int i = 0; i < width; i++ ) {
            boolean hasRightDirection =
                    vertical(i).stream().anyMatch(Point::hasRightDirection);

            // todo refactor
            if(!hasRightDirection) {
                int adjustIndex = (new Random()).nextInt(height);
                ladder.get(adjustIndex).reverse(i);
            }
        }
    }

    public int height() {
        return ladder.size();
    }

    public List<Point> vertical(int index) {
        return ladder.stream()
                .map(line -> line.getPoint(index))
                .collect(Collectors.toList());
    }
}
