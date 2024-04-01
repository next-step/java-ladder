package ladder.dto;

import ladder.domain.Ladders;

import java.util.List;
import java.util.stream.Collectors;

public class LaddersDto {
  private final List<RowDto> rows;

  public LaddersDto(Ladders ladders) {
    this.rows = ladders.rows().stream()
            .map(RowDto::new)
            .collect(Collectors.toList());
  }

  public List<RowDto> getRows() {
    return this.rows;
  }
}
