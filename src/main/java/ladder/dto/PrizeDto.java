package ladder.dto;

import ladder.domain.Prize;

public class PrizeDto {
  private final String value;

  public PrizeDto(final Prize prize) {
    this.value = prize.textValue();
  }

  public String getValue() {
    return this.value;
  }
}
