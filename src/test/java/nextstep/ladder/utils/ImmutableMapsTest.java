package nextstep.ladder.utils;

import nextstep.ladder.domain.IndexedName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static nextstep.ladder.domain.IndexedName.unwrap;
import static nextstep.ladder.domain.IndexedName.wrap;
import static nextstep.ladder.utils.ImmutableMaps.ordered;
import static org.assertj.core.api.Assertions.assertThat;

class ImmutableMapsTest {
    @Test
    void orderingByKeyList() {
        List<IndexedName> names = wrap(Arrays.asList("pobi", "honux", "crong", "jk"));

        Map<String, String> collect = names.stream()
                .collect(collectingAndThen(toMap(IndexedName::toString,
                                                 indexedName -> String.valueOf(indexedName.getIndex())),
                                           map -> ordered(map, unwrap(names))));

        assertThat(collect).containsExactly(new AbstractMap.SimpleEntry<>("pobi", "0"),
                                            new AbstractMap.SimpleEntry<>("honux", "1"),
                                            new AbstractMap.SimpleEntry<>("crong", "2"),
                                            new AbstractMap.SimpleEntry<>("jk", "3")
        );
    }
}
