package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.LineDirection;

import java.util.List;

import static nextstep.ladder.domain.LineDirection.RIGHT;

public class LineResponse {
    public static final String OFFSET = "     ";
    private static final String LAST_LINE = "|";
    private static final String CONNECTED_LINE = "|-----";
    private static final String DISCONNECTED_LINE = "|     ";

    private final String line;


    public static LineResponse from(Line line) {
        List<LineDirection> lineDirections = line.getLineDirections();

        StringBuilder sb = new StringBuilder(OFFSET);
        for (int i = 0; i < lineDirections.size() - 1; i++) {
            if (lineDirections.get(i).equals(RIGHT)) {
                sb.append(CONNECTED_LINE);
                continue;
            }
            sb.append(DISCONNECTED_LINE);
        }
        sb.append(LAST_LINE);
        return new LineResponse(sb.toString());
    }

    private LineResponse(String line) {
        this.line = line;
    }

    public String getResponse() {
        return line;
    }
}
