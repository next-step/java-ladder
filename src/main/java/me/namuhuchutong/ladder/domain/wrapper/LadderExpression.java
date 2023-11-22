package me.namuhuchutong.ladder.domain.wrapper;

public enum LadderExpression {

    EMPTY_SPACE(' ', 5) {

        @Override
        public String convertToString() {
            return EMPTY_SPACE.character.toString().repeat(EMPTY_SPACE.scaffoldSize);
        }
    },
    HYPHEN('-', 5) {

        @Override
        public String convertToString() {
            return HYPHEN.character.toString().repeat(HYPHEN.scaffoldSize);
        }
    },
    VERTICAL_BAR('|', 1) {

        @Override
        public String convertToString() {
            return VERTICAL_BAR.character.toString();
        }
    };

    private final Character character;
    private final int scaffoldSize;

    LadderExpression(Character character, int scaffoldSize) {
        this.character = character;
        this.scaffoldSize = scaffoldSize;
    }

    abstract public String convertToString();
}
