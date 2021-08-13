package nextstep.ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import nextstep.ladder.utils.Constants;

public class Goods {
    private final List<String> goods;

    private Goods(List<String> goods) {
        this.goods = goods;
    }

    public static Goods of(String goods) {
        return new Goods(Arrays.stream(goods.split(Constants.COMMA))
                               .collect(toList()));
    }

    public List<String> getGoods() {
        return goods;
    }

    public String resultGoods(int resultIndex) {
        return goods.get(resultIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Goods goods1 = (Goods) o;
        return Objects.equals(goods, goods1.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goods);
    }
}
