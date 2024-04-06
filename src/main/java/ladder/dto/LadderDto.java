package ladder.dto;

import ladder.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderDto {
  private final List<RowDto> rows;

  public LadderDto(Ladder ladder) {
    this.rows = ladder.rows().stream()
            .map(RowDto::new)
            .collect(Collectors.toList());
  }

  public List<RowDto> getRows() {
    return this.rows;
  }
}
