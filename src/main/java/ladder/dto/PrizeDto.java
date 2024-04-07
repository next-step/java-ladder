package ladder.dto;

import ladder.domain.Prize;

import java.util.Objects;

public class PrizeDto {
  private final String value;

  public PrizeDto(final Prize prize) {
    this(prize.textValue());
  }

  public PrizeDto(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrizeDto prizeDto = (PrizeDto) o;
    return value.equals(prizeDto.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
