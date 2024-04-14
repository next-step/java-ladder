package ladder.dto;

import ladder.domain.Row;

import java.util.List;
import java.util.Objects;

public class RowDto {
  private final List<Boolean> values;

  public RowDto(Row row) {
    this.values = row.values();
  }

  public List<Boolean> getValues() {
    return this.values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    RowDto rowDto = (RowDto) o;
    return values.equals(rowDto.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
