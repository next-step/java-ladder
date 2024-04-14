package ladder.dto;

import ladder.domain.Ladder;

import java.util.List;
import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LadderDto ladderDto = (LadderDto) o;
    return rows.equals(ladderDto.rows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rows);
  }
}
