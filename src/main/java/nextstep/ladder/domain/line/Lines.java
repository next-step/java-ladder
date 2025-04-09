package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.Users;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    public Lines(Users users, int height, LineCreateStrategy lineCreateStrategy) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }

        this.lines = Stream.generate(() -> new Line(users, lineCreateStrategy))
            .limit(height)
            .collect(Collectors.toList());
    }
}
