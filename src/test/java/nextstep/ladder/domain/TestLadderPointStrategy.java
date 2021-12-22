package nextstep.ladder.domain;

public class TestLadderPointStrategy {
    public static LadderPointGenerateStrategy NO_LINE_STRATEGY = () -> false;

    static class ReverseLineStrategy implements LadderPointGenerateStrategy {
        private boolean flag = false;

        @Override
        public boolean generatePoint() {
            flag = !flag;
            return flag;
        }
    }

    public static LadderPointGenerateStrategy ALL_LINE_STRATEGY = () -> true;

    public static LadderPointGenerateStrategy INVALID_TRUE_IN_SUCCESSION_STRATEGY = new LadderPointGenerateStrategy() {
        int number = 0;
        @Override
        public boolean generatePoint() {
            return number++ % 3 != 2;
        }
    };
}
