package nextstep.ladder.domain;

public class LegBuilder {
    private String name = "pobi";
    private String result = "꽝";
    private int height = 5;

    public LegBuilder name(String name) {
        this.name = name;
        return this;
    }

    public LegBuilder result(String result) {
        this.result = result;
        return this;
    }

    public LegBuilder height(int height) {
        this.height = height;
        return this;
    }

    public Leg build() {
        return new Leg(name, result, height);
    }
}
