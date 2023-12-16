package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.List;

public class LadderResponse {
    private final String ladder;


    public LadderResponse(String ladder) {
        this.ladder = ladder;
    }

    public static LadderResponse from(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < ladder.getHeight(); i++) {
            sb.append(LineResponse.from(lines.get(i)).getResponse());
            sb.append("\n");
        }
        return new LadderResponse(sb.toString());
    }

    public String getResponse() {
        return ladder;
    }
}
