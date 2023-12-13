package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.Line;

import java.util.List;

public class LineResponse {
    public static final String OFFSET = "     ";
    private static final String LAST_LINE = "|";
    private static final String CONNECTED_LINE = "|-----";
    private static final String DISCONNECTED_LINE = "|     ";

    private final String line;

    private LineResponse(String line) {
        this.line = line;
    }

    public static LineResponse from(Line line) {
        List<Boolean> points = line.getPoints();

        StringBuilder sb = new StringBuilder(OFFSET);
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i)) {
                sb.append(CONNECTED_LINE);
                continue;
            }
            sb.append(DISCONNECTED_LINE);
        }
        sb.append(LAST_LINE);
        return new LineResponse(sb.toString());
    }

    public String getResponse() {
        return line;
    }
}
