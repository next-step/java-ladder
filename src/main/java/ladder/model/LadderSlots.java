package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderSlots {
    private final List<LadderSlot> names;

    public LadderSlots(String names) {
        this(Arrays.stream(names.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(LadderSlot::new)
                .collect(Collectors.toList()));
    }

    public LadderSlots(List<LadderSlot> names) {
        this.names = names;
    }

    public boolean isSize(int expectSize) {
        return names.size() == expectSize;
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream().map(LadderSlot::getName).collect(Collectors.toList());
    }

    public boolean hasName(String name) {
        return names.stream().anyMatch(n -> n.isName(name));
    }

    public int nameIndex(String targetName) {
        return names.stream()
            .filter(slot -> slot.isName(targetName))
            .findFirst()
            .map(names::indexOf)
            .orElseThrow(() -> new IllegalArgumentException("없는 이름입니다."));
    }

    public String indexedSlot(int index) {
        return names.get(index).getName();
    }
}
