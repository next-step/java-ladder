package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderMaterials {
    private final List<LadderMaterial> ladderMaterials;

    public LadderMaterials(final List<LadderMaterial> ladderMaterials) {
        this.ladderMaterials = ladderMaterials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderMaterials that = (LadderMaterials) o;
        return Objects.equals(ladderMaterials, that.ladderMaterials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderMaterials);
    }
}
