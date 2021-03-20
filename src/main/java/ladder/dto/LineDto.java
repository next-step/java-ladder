package ladder.dto;

import ladder.domain.Line;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LineDto {

    private List<PointDto> pointList;

    public LineDto(Line line) {
        pointList = line.pointList().stream()
                .map(PointDto::new)
                .collect(Collectors.toList());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (PointDto point : pointList) {
            builder.append(point.toString());
            builder.append(ResultView.VERTICAL_LINE_REPRESENTATION);
        }
        return builder.toString();
    }
}
