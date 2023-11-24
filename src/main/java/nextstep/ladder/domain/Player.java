package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Width;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Name;

public class Player {

    private final Name name;
    private Width widthPosition;
    private Height heightPosition;

    private Player(String name, int widthPosition, int heightPosition) {
        this.name = new Name(name);
        this.widthPosition = new Width(widthPosition);
        this.heightPosition = new Height(heightPosition);
    }

    public String name() {
        return this.name.toString();
    }

    public static class PlayerBuilder {

        private String name;
        private int widthPosition;
        private int heightPosition;

        private PlayerBuilder() {
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder widthPosition(int widthPosition) {
            this.widthPosition = widthPosition;
            return this;
        }

        public PlayerBuilder heightPosition(int heightPosition) {
            this.heightPosition = heightPosition;
            return this;
        }

        public static PlayerBuilder builder() {
            return new PlayerBuilder();
        }

        public Player build() {
            return new Player(this.name, this.widthPosition, this.heightPosition);
        }
    }
}
