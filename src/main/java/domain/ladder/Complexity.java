package domain.ladder;

public enum Complexity {
    HARD("상", 15, 9),
    NORMAL("중", 10, 6),
    EASY("하", 5, 3);

    private String complexity;
    private int height;
    private int bridgeLevel;

    Complexity(String complexity, int height, int bridgeLevel) {
        this.complexity = complexity;
        this.height = height;
        this.bridgeLevel = bridgeLevel;
    }

    public static int determineHeight(String level) {
        return findOne(level).height;
    }

    public static int determineBridgeComplexity(String level) {
        return findOne(level).bridgeLevel;
    }

    private static Complexity findOne(String level) {
        Complexity[] complexities = Complexity.values();
        for (Complexity complexity : complexities) {
            if (complexity.complexity.equals(level)) {
                return complexity;
            }
        }
        throw new IllegalArgumentException("난이도를 잘못 입력하셨습니다.");
    }
}