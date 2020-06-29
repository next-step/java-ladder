package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointMapperTest {
  @Test
  void 텍스트변환() {
    PointMapper pointMapper0 = new PointMapper(PointDTOTest.point0);
    PointMapper pointMapper1_0 = new PointMapper(PointDTOTest.point1_0);

    assertThat(pointMapper0.getResult()).isEqualTo("     |");
    assertThat(pointMapper1_0.getResult()).isEqualTo("-----|");
  }
}