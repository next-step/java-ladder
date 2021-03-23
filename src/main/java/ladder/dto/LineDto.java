package ladder.dto;

import ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class LineDto {

    private List<PointDto> pointList;

    public LineDto(Line line) {
        pointList = line.pointList().stream()
                .map(PointDto::new)
                .collect(Collectors.toList());
    }

    public List<PointDto> pointList() {
        return pointList;
    }
}
