package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Width;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Name;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(widthPosition, player.widthPosition) && Objects.equals(heightPosition, player.heightPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, widthPosition, heightPosition);
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
