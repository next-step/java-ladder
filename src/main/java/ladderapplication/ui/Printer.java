package ladderapplication.ui;

import ladderapplication.models.requests.PlayerRequest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Printer {

    public static List<PlayerRequest> requestPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String players = InputScanner.stringScan();

        String[] playerArr = players.split(",");
        return Stream.of(playerArr).map(PlayerRequest::of).collect(Collectors.toList());
    }
}
