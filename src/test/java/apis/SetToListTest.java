package apis;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SetToListTest {
    @Test
    void convert_set_to_list_test() {
        String name = "pobi,honux,crong,jk";

        Set<String> set = Arrays.stream(name.split(","))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        List<String> list = new ArrayList<>(set);

        List<String> names = Arrays.stream(name.split(","))
                .collect(Collectors.toList());

        assertThat(list.equals(names)).isTrue();
    }
}
