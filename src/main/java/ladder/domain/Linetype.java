package ladder.domain;

public enum LineType {

    VERTICAL("|"),
    BLANK(" "),
    HORIZONTAL("-");

    private static final int CHUNKER_VALUE = 2;
    private String line;

    LineType(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public static LineType makeType(LineTypeDTO lineTypeDTO) {
        if (lineTypeDTO.getPoint() % CHUNKER_VALUE == 0) {
            return LineType.VERTICAL;
        }
        return getRandomType(lineTypeDTO.getPossibilityStrategy(), lineTypeDTO.isCheckPrePoint());
    }

    private static LineType getRandomType(PossibilityStrategy possibilityStrategy, boolean checkPrePoint) {
        if (checkPrePoint) {
            return LineType.BLANK;
        }
        return getHorizontalType(possibilityStrategy);
    }

    private static LineType getHorizontalType(PossibilityStrategy possibilityStrategy) {
        if (possibilityStrategy.check()) {
            return LineType.HORIZONTAL;
        }
        return LineType.BLANK;
    }
}
