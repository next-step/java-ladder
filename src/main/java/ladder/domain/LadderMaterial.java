package ladder.domain;

import java.util.Objects;

public class LadderMaterial {
    private final LadderMaterialType ladderMaterialType;

    public LadderMaterial(LadderMaterialType ladderMaterialType) {
        this.ladderMaterialType = ladderMaterialType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderMaterial that = (LadderMaterial) o;
        return ladderMaterialType == that.ladderMaterialType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderMaterialType);
    }
}
