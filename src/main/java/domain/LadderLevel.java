package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LadderLevel {
    HIGH("상", 20, 0.8),
    MEDIUM("중", 10, 0.5),
    LOW("하", 5, 0.3);

    private String name;
    private int height;
    private double percentage;
    private List<Boolean> randoms;

    LadderLevel(String name, int height, double percentage) {
        this.name = name;
        this.height = height;
        this.percentage = percentage;
        createRandomList();
    }

    public static LadderLevel of(String name) {
        return Arrays.stream(values())
                .filter(v -> v.name.equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void createRandomList() {
        randoms = new ArrayList<>();
        for (int i = 0; i < this.height * this.percentage; i++) {
            randoms.add(Boolean.TRUE);
        }

        for (int i = 0; i < height - (height * percentage); i++) {
            randoms.add(Boolean.FALSE);
        }
    }

    public int getHeight() {
        return height;
    }

    public Boolean random() {
        Collections.shuffle(randoms);
        return randoms.get(0);
    }
}
