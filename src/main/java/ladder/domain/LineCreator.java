package ladder.domain;

public final class LineCreator {

    private static final class LineCreatorHolder {
        private static final LineCreator instance = new LineCreator();
    }

    private LineCreator() {
    }

    public static final LineCreator getInstance() {
        return LineCreatorHolder.instance;
    }
}
