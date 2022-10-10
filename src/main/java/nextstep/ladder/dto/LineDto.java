package nextstep.ladder.dto;

import nextstep.ladder.domain.Line;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineDto {

    private final List<PointDto> pointsDto;

    private LineDto(final List<PointDto> pointsDto) {

        this.pointsDto = pointsDto;
    }

    public static LineDto from(final Line line) {

        final List<PointDto> pointsDto = line.getPoints()
                .stream()
                //.filter(point -> point.get)
                .map(PointDto::from)
                .collect(Collectors.toList());

        return new LineDto(pointsDto);
    }

    public List<PointDto> getPointsDto() {

        return this.pointsDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineDto lineDto = (LineDto) o;
        return Objects.equals(pointsDto, lineDto.pointsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointsDto);
    }
}
