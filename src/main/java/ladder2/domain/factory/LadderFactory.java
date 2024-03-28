package ladder2.domain.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ladder2.domain.Ladder;
import ladder2.domain.LadderRow;

public class LadderFactory {

    private static final String CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE
        = "인스턴스화 불가 클래스입니다";

    private LadderFactory() {
        throw new AssertionError(CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE);
    }

    public static Ladder generate(int rowSize, int columnSize) {
        List<LadderRow> rows = Stream.generate(() -> LadderRowFactory.generate(columnSize))
            .limit(rowSize)
            .collect(Collectors.toList());
        return new Ladder(rows);
    }
}
