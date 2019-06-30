package nextstep.ladder;

public class LineFormatter implements Formatter<Line> {
    private final String LINE_BLANK = "     ";
    private final String LINE_BRANCH = "-----";
    private final String LINE_CONNECTOR = "|";
    private final String LINE_END = "\n";

    @Override
    public String format(Line line) {
        StringBuilder builder = new StringBuilder(LINE_BLANK+LINE_CONNECTOR);

        line.getPoints().stream()
                .map(point -> pointToString(point))
                .map(string -> string+LINE_CONNECTOR)
                .forEach(builder::append);
        builder.append(LINE_END);

        return builder.toString();
    }

    private String pointToString(Boolean point) {
        if(point) {
            return LINE_BRANCH;
        }
        return LINE_BLANK;
    }
}
