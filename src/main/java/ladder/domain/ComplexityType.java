package ladder.domain;

import java.util.Arrays;

public enum ComplexityType {
    HIGH("상", 0.9, 20),
    MIDDLE("중", 0.6, 10),
    LOW("하", 0.3, 5);

    private final String complexity;
    private final double probabilityOfLink;
    private final int height;

    ComplexityType(String complexity, double probabilityOfLink, int height) {
        this.complexity = complexity;
        this.probabilityOfLink = probabilityOfLink;
        this.height = height;
    }

    public static ComplexityType of(String complexity) {
        return Arrays.stream(values())
                .filter(complexityType -> complexityType.complexity.equals(complexity))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("복잡도는 상중하 중에 선택해주세요."));
    }

    public double getProbabilityOfLink() {
        return probabilityOfLink;
    }

    public int getHeight() {
        return height;
    }
}
