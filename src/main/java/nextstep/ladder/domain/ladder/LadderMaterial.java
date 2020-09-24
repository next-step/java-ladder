package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class LadderMaterial {
    private final int height;
    private final LineMaterial lineMaterial;

    public static LadderMaterial of(final int height, final LineMaterial lineMaterial) {
        return new LadderMaterial(height, lineMaterial);
    }

    public LadderMaterial(final int height, final LineMaterial lineMaterial) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }

        if (Objects.isNull(lineMaterial)) {
            throw new IllegalArgumentException("사다리 라인 요소가 없습니다.");
        }
        this.height = height;
        this.lineMaterial = lineMaterial;
    }

    public int getHeight() {
        return height;
    }

    public LineMaterial getLineMaterial() {
        return lineMaterial;
    }
}
