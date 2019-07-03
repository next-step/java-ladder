package nextstep.ladder.view;

import nextstep.ladder.model.LadderLine;

public class LineFormatter implements Formatter<LadderLine> {
    protected static final int FIRST_ONE = 1;
    protected static final String LINE_BLANK = "     ";
    protected static final String LINE_BRANCH = "-----";
    protected static final String LINE_CONNECTOR = "|";
    protected static final String LINE_END = "\n";

    @Override
    public String format(LadderLine ladderLine) {
        StringBuilder builder = new StringBuilder(LINE_BLANK + LINE_CONNECTOR);

        int last = ladderLine.getPoints().size();
        ladderLine.getPoints().stream()
                .skip(FIRST_ONE)
                .map(point -> pointToString(point.showLeft()))
                .map(string -> string + LINE_CONNECTOR)
                .forEach(builder::append);
        builder.append(LINE_END);

        return builder.toString();
    }

    private String pointToString(boolean point) {
        if (point) {
            return LINE_BRANCH;
        }
        return LINE_BLANK;
    }
}
