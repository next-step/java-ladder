package nextstep.ladder.codeleesh.dto;

import nextstep.ladder.codeleesh.domain.Line;
import nextstep.ladder.codeleesh.domain.Point;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineDto {

    private final List<PointDto> pointsDto;

    private LineDto(final List<PointDto> pointsDto) {

        this.pointsDto = pointsDto;
    }

    public static List<LineDto> from(final List<Line> lines) {

        return lines.stream()
                .map(LineDto::from)
                .collect(Collectors.toList());
    }

    private static LineDto from(final Line line) {

        final List<PointDto> collect = IntStream.range(0, line.getPoints().size() - 1)
                .mapToObj(i -> {
                    final Point point = line.getPoints().get(i);
                    return PointDto.from(point);
                })
                .collect(Collectors.toList());

        return new LineDto(collect);
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
