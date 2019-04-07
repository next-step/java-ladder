package domain;

import lombok.Getter;

import java.util.List;


public class Participants {
    private List<String> names;

    @Getter
    private int number;

    public Participants(List list) {
        this.names = list;
        this.number = list.size();
    }

    @Override
    public String toString() {
        return names +
                "  ";
    }
}
