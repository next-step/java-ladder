package ladder.view;

import ladder.config.Config;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LadderItem {
    BLANK_HORIZONTAL(IntStream.range(0, Config.NAME_SIZE).mapToObj(x -> " ").collect(Collectors.joining())),
    HORIZONTAL(IntStream.range(0, Config.NAME_SIZE).mapToObj(x -> "-").collect(Collectors.joining())),
    VERTICAL("|");

    private final String item;

    LadderItem(String item){
        this.item = item;
    }

    public String getItem(){
        return item;
    }
}
