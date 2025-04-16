package ladder.model;

import java.util.List;

public class LadderSlotsPair {
    private final LadderSlots upperSlots;
    private final LadderSlots lowerSlots;

    public LadderSlotsPair(String upperNames, String lowerNames) {
        this(new LadderSlots(upperNames), new LadderSlots(lowerNames));
    }

    public LadderSlotsPair(LadderSlots upperSlots, LadderSlots lowerSlots) {
        this.upperSlots = upperSlots;
        this.lowerSlots = lowerSlots;

        if (!upperSlots.isSize(lowerSlots.size())) {
            throw new IllegalArgumentException("양쪽의 수는 동일해야 합니다.");
        }
    }

    public List<String> getUserNames() {
        return upperSlots.getNames();
    }

    public List<String> getResultNames() {
        return lowerSlots.getNames();
    }

    public int size() {
        return upperSlots.size();
    }

    public boolean hasUserName(String name) {
        return upperSlots.hasName(name);
    }

    public int userNameIndex(String targetName) {
        return upperSlots.nameIndex(targetName);
    }

    public String indexedResult(int index) {
        return lowerSlots.indexedSlot(index);
    }
}
