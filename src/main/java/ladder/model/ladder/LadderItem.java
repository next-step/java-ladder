package ladder.model.ladder;

import ladder.config.Config;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LadderItem {

    BLANK_HORIZONTAL(0, IntStream.range(0, Config.NAME_SIZE).mapToObj(x -> " ").collect(Collectors.joining())),
    HORIZONTAL(1, IntStream.range(0, Config.NAME_SIZE).mapToObj(x -> "-").collect(Collectors.joining())),
    VERTICAL(2, "|");

    private final int idx;
    private final String item;

    LadderItem(int idx,String item){
        this.idx = idx;
        this.item = item;
    }

    public static LadderItem findItem(int idx){
        return Arrays.stream(LadderItem.values())
                .filter(item -> item.idx == idx)
                .findFirst()
                .orElse(BLANK_HORIZONTAL);
    }

    public String getItem(){
        return item;
    }
}
