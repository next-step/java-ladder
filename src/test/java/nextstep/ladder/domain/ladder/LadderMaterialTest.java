package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderMaterialTest {

    @Test
    @DisplayName("LadderMaterial 의 height는 1 이상이고 LineMaterial 은 not null")
    void exceptByCreation() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderMaterial.of(0, LineMaterial.of(3, () -> true));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderMaterial.of(1, null);
        });
    }

}
