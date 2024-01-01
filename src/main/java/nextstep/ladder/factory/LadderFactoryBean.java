package nextstep.ladder.factory;

public class LadderFactoryBean {
    public static LadderCreator createLadderFactory() {
        LineCreator lineCreator = new LineCreator();
        return new LadderCreator(lineCreator);
    }

}
