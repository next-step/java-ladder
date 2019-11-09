package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderMaterialTest {

    @Test
    void 생성() {
        LadderMaterial ladderMaterial = new LadderMaterial(LadderMaterialType.HORIZONTAL);
        assertThat(ladderMaterial).isEqualTo(new LadderMaterial(LadderMaterialType.HORIZONTAL));
    }
}
