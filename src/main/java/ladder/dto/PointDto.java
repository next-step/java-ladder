package ladder.dto;

import ladder.domain.Point;
import ladder.view.ResultView;

public class PointDto {

    private boolean isFilled;

    public PointDto(Point point) {
        this.isFilled = point.isFilled();
    }

    public String toString() {
        if (isFilled) {
            return ResultView.FILLED_POINT_REPRESENTATION;
        }
        return ResultView.EMPTY_POINT_REPRESENTATION;
    }

}
