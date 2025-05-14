package nextstep.ladder2.domain.ladder;

import nextstep.ladder2.domain.result.MatchingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final int peopleCount;

    public Ladder(int peopleCount, int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }

        this.peopleCount = peopleCount;
        for(int i = 0; i < height; i++) {
            lines.add(LineFactory.create(peopleCount));
        }
    }

    public int height() {
        return lines.size();
    }

    public List<Line> lines() {
        return List.copyOf(lines);
    }
    
    public int resultOf(int position) {
        validatePosition(position);
        
        for (Line line : lines) {
            position = moveWithDirection(position, line);
        }
        
        return position;
    }
    
    private int moveWithDirection(int position, Line line) {
        if (position < 0 || position >= line.size()) {
            return position;
        }
        
        Direction direction = line.move(position);
        
        if (direction == Direction.LEFT) {
            return position - 1;
        }
        
        if (direction == Direction.RIGHT) {
            return position + 1;
        }
        
        return position;
    }
    
    private void validatePosition(int position) {
        if (position < 0 || position >= peopleCount) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다: " + position);
        }
    }
    
    public MatchingResult play() {
        List<Integer> playerRewardList = IntStream.range(0, peopleCount)
                .mapToObj(this::resultOf)
                .collect(Collectors.toList());
        return new MatchingResult(playerRewardList);
    }
}
