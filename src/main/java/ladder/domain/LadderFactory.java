package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFactory {

    private static final String CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE
        = "인스턴스화 불가 클래스입니다";

    private LadderFactory() {
        throw new AssertionError(CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE);
    }

    public static Ladder generate(int participantCount, int height) {
        List<Line> lines = Stream.generate(() -> LineFactory.generate(participantCount))
            .limit(height)
            .collect(Collectors.toList());
        return Ladder.from(lines);
    }
}
