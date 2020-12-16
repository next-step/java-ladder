package ladder.domain;

public interface LevelItem {

    enum Type {
        Step, Bar, EmptyStep;
    }

    Type getType();

    default boolean isStep() {
        return getType() == Type.Step;
    }

    default boolean isBar() {
        return getType() == Type.Bar;
    }

    static LevelItem step() {
        return new LevelItem() {
            @Override
            public Type getType() {
                return Type.Step;
            }

            @Override
            public String toString() {
                return "------";
            }
        };
    }

    static LevelItem bar() {
        return new LevelItem() {
            @Override
            public Type getType() {
                return Type.Bar;
            }

            @Override
            public String toString() {
                return "|";
            }
        };
    }

    static LevelItem emptyStep() {
        return new LevelItem() {
            @Override
            public Type getType() {
                return Type.EmptyStep;
            }

            @Override
            public String toString() {
                return "      ";
            }
        };
    }

}
