package ladder.domain.vo;

import java.util.Objects;

public class Row {

    private final boolean bridgeExist;

    public Row(RowCreateStrategy rowCreateStrategy,
               boolean bridgeExist){
        this(decideBridgeExist(rowCreateStrategy, bridgeExist));
    }

    public Row(boolean bridgeExist) {
        this.bridgeExist = bridgeExist;
    }

    public static boolean decideBridgeExist(RowCreateStrategy rowCreateStrategy,
                                            boolean bridgeExist) {
        if (rowCreateStrategy.isPreviousBridgeExist()) {
            return false;
        }

        return bridgeExist;
    }

    public boolean bridgeExist(){
        return this.bridgeExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Row row = (Row) o;
        return Objects.equals(bridgeExist, row.bridgeExist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridgeExist);
    }
}
