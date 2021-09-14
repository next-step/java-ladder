package nextstep.ladder.domain;

public class LadderGenerateFactory {

    public static LadderGenerator findGenerator() {
        return new AutoLadderGenerator();
    }
}
