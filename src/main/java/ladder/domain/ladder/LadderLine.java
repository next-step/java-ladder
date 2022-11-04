package ladder.domain.ladder;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {

    private final List<HorizontalLineDirection> horizontalLineDirections;

    public LadderLine(HorizontalLineDirection... horizontalLineDirections) {
        this(Arrays.stream(horizontalLineDirections).collect(Collectors.toList()));
    }

    public LadderLine(List<HorizontalLineDirection> horizontalLineDirections) {
        this.horizontalLineDirections = horizontalLineDirections;
    }

    public List<HorizontalLineDirection> horizontalLineDirections() {
        return Collections.unmodifiableList(horizontalLineDirections);
    }

    public int width() {
        return this.horizontalLineDirections.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderLine that = (LadderLine) o;
        AbstractCollection<HorizontalLineDirection> horizontalLineDirections
                = (AbstractCollection<HorizontalLineDirection>) this.horizontalLineDirections;

        return horizontalLineDirections.equals(that.horizontalLineDirections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontalLineDirections);
    }
}
