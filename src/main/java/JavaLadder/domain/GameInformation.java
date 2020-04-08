package JavaLadder.domain;

public class GameInformation {
    private Users users;
    private Prizes prizes;

    public GameInformation(String name, String prize) {
        this.users = new Users(name);
        this.prizes = new Prizes(prize);
        validateSize(users.size(), prizes.size());
    }

    private void validateSize(int userSize, int prizeSize) {
        if (userSize != prizeSize) {
            throw new IllegalArgumentException("사용자수[" + userSize + "]와 상품수[" + prizeSize + "]가 동일해야합니다.");
        }
    }

    public Users getUsers() {
        return users;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
