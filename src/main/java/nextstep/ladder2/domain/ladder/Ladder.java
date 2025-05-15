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

    public Position resultOf(Position position) {
        for (Line line : lines) {
            position.moveBy(line.move(position.value()));
        }

        return position;
    }

    public MatchingResult play() {
        List<Position> positions = Position.range(0, peopleCount, peopleCount);
        List<Position> playerRewardList = positions.stream()
                .map(this::resultOf)
                .collect(Collectors.toList());
        return new MatchingResult(playerRewardList);
    }
}
