package ladder.dto;

import ladder.domain.Point;
import ladder.view.ResultView;

public class PointDto {

    private boolean isFilled;

    public PointDto(Point point) {
        this.isFilled = point.isFilled();
    }

    public boolean isFilled() {
        return isFilled;
    }
}
