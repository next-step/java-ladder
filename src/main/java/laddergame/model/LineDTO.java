package laddergame.model;

import java.util.List;
import java.util.stream.Collectors;

public class LineDTO {

  final List<PointDTO> pointDTOs;

  private LineDTO(List<PointDTO> pointDTOs) {
    this.pointDTOs = pointDTOs;
  }

  public static LineDTO createBy(Line line) {
    return new LineDTO(
        line.getPoints()
            .stream()
            .map(PointDTO::createBy)
            .collect(Collectors.toList()));
  }

  public String getLineWithMappedPoint() {
    StringBuilder sb = new StringBuilder();

    pointDTOs.forEach(pointDTO -> {
      sb.append(new PointMapper(pointDTO).getResult());
    });

    return sb.toString();
  }

  @Override
  public String toString() {
    return "LineDTO{" +
        "pointDTOs=" + pointDTOs +
        '}';
  }
}
