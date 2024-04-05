package ladder.domain.vo;

import java.util.Objects;

public class Row {

    private final Boolean bridgeExist;

    public Row(RowCreateStrategy rowCreateStrategy,
               Boolean bridgeExist){
        this(create(rowCreateStrategy, bridgeExist));
    }

    public Row(Boolean bridgeExist) {
        this.bridgeExist = bridgeExist;
    }


    public Boolean bridgeExist(){
        return this.bridgeExist;
    }

    public static Boolean create(RowCreateStrategy rowCreateStrategy,
                                 Boolean bridgeExist) {
        if (rowCreateStrategy.isPreviousBridgeExist()) {
            return Boolean.FALSE;
        }
        return bridgeExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(bridgeExist, row.bridgeExist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridgeExist);
    }
}
