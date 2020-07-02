package ladder.utils;

import ladder.model.LadderLine;

import java.util.List;
import java.util.Objects;

public class Validation {
    public static void validateEmpty(List<LadderLine> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인은 하나 이상이어야 합니다.");
        }
    }
}
