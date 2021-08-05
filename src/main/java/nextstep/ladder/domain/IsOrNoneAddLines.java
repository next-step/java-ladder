package nextstep.ladder.domain;

import java.util.List;

public class IsOrNoneAddLines implements AddLines{

    @Override
    public boolean draw(List<Line> lines) {
        return lines.get(lines.size() - 1).isExist();
    }
}
