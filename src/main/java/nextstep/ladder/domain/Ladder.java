package nextstep.ladder.domain;

import nextstep.ladder.dto.PointDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    List<Row> ladder;

    public Ladder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(int usersCount, int height, PointGenerator generator) {
        List<Row> ladder = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            ladder.add(Row.of(generator, usersCount));
        }
        return new Ladder(ladder);
    }

    public int getResultX(int x) {
        for (int i = 0; i < ladder.size(); i++) {
            x = ladder.get(i).getNextX(x);
        }
        return x;
    }

    public List<List<PointDto>> toLadderDto() {
        return ladder.stream()
                .map(Row::toPointDtos)
                .collect(Collectors.toList());
    }
}
