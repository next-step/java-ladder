package nextstep.ladder;

public class Ladder {
    public final Natural height;
    public final Users users;
    public final Legs legs;

    public Ladder(Users users, Natural levels, GenerationStrategy strategy) {
        this.height = levels;
        this.users = users;
        legs = new Legs(height, users.size(), strategy);
    }
}
