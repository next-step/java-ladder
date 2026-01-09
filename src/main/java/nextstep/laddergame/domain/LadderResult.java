package nextstep.laddergame.domain;

public record LadderResult(String name, String goal) {

    @Override
    public String toString() {
        return "LadderResult{" +
            "name='" + name + '\'' +
            ", goal='" + goal + '\'' +
            '}';
    }
}