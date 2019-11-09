package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderMaterialsTest {

    @Test
    void 생성() {
        List<LadderMaterial> ladderMaterialList = Arrays.asList(
                new LadderMaterial(LadderMaterialType.VERTICAL),
                new LadderMaterial(LadderMaterialType.HORIZONTAL),
                new LadderMaterial(LadderMaterialType.VERTICAL),
                new LadderMaterial(LadderMaterialType.VERTICAL)
        );
        LadderMaterials ladderMaterials = new LadderMaterials(ladderMaterialList);
        assertThat(ladderMaterials).isEqualTo(new LadderMaterials(ladderMaterialList));
    }
}
