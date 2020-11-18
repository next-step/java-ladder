package step2.strategy;

public class LadderPrintStrategy implements PrintLadderStrategy {
    private final String existsString;
    private final String notExistsString;

    public LadderPrintStrategy(String existsString, String notExistsString) {
        this.existsString = existsString;
        this.notExistsString = notExistsString;
    }

    @Override
    public String get(Boolean exists) {
        return exists
                ? existsString
                : notExistsString;
    }
}
