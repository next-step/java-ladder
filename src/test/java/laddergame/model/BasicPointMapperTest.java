package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasicPointMapperTest {

  @Test
  void 텍스트변환() {
    PointMapper pointMapper0 = new PointMapper(PointDTO.createBy(BasicPointDTOTest.point0_1));
    PointMapper pointMapper1_0 = new PointMapper(PointDTO.createBy(BasicPointDTOTest.point1_0));

    assertThat(pointMapper0.getResult()).isEqualTo("     |");
    assertThat(pointMapper1_0.getResult()).isEqualTo("-----|");
  }
}