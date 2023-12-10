package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Position;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private final List<Reward> value;

    private Rewards(List<Reward> value){
        this.value = value;
    }

    public static Rewards fromString(String input){
        return new Rewards(Arrays.stream(input.split(",")).map(String::trim).map(Reward::new).collect(Collectors.toList()));
    }

    public String rewardString(Position position){
        return position.getFromList(this.value).toString();
    }

    @Override
    public String toString() {
        return value.stream().map(e->" ".repeat(5- e.toString().length()).concat(e.toString()).concat(" ")).collect(
                Collectors.joining()).stripTrailing();
    }

    public int size() {
        return value.size();
    }
}
