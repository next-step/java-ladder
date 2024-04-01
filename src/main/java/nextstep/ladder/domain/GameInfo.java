package nextstep.ladder.domain;

import java.util.List;

public class GameInfo {

    private final Users users;
    private final WinProducts winProducts;

    private GameInfo(Users users, WinProducts winProducts) {
        this.users = users;
        this.winProducts = winProducts;
    }

    public static GameInfo of(Users users, WinProducts winProducts) {
        return new GameInfo(users, winProducts);
    }

    public List<String> getParticipantsList() {
        return this.users.toNameList();
    }

    public int getUserDepartPosition(String name) {
        return this.users.getUserIndex(name);
    }

    public String getWinProductsOf(int destinationPosition) {
        return this.winProducts.getWinProductOf(destinationPosition);
    }

    public boolean hasUserName(String name) {
        return this.users.hasUserName(name);
    }
}
