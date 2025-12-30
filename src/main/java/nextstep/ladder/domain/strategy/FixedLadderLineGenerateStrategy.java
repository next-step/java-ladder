package nextstep.ladder.domain.strategy;

import java.util.List;

public class FixedLadderLineGenerateStrategy implements GenerateLadderLineStrategy{

    private final List<Boolean> pattern;

    public FixedLadderLineGenerateStrategy(Boolean... pattern) {
        this.pattern = List.of(pattern);
    }

    @Override
    public List<Boolean> generate(int size) {
        validatePattern(size);
        return pattern;
    }

    private void validatePattern(int size) {
        if (size - 1 != pattern.size()) {
            throw new IllegalArgumentException("패턴 크기와 요청 크기가 일치하지 않습니다.");
        }
    }
}
