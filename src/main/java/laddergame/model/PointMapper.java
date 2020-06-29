package laddergame.model;

import laddergame.model.PointDTO;

public class PointMapper {

  private static final String RUNG_EXIST = "-----|";
  private static final String RUNG_NOT_EXIST = "     |";

  private final PointDTO pointDTO;

  public PointMapper(PointDTO pointDTO) {
    this.pointDTO = pointDTO;
  }


  public String getResult() {
    if (pointDTO.hasLeft()) {
      return RUNG_EXIST;
    }

    return RUNG_NOT_EXIST;
  }
}
