package ladderapplication.ui;

import ladderapplication.models.requests.GameSettingRequest;
import ladderapplication.models.requests.LadderRequest;
import ladderapplication.models.requests.PlayerRequest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Printer {

    public static GameSettingRequest requestGameSetting() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String players = InputScanner.stringScan();
        String[] playerArr = players.split(",");
        List<PlayerRequest> playerRequests = Stream.of(playerArr).map(PlayerRequest::of).collect(Collectors.toList());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = InputScanner.intScan();
        LadderRequest ladderRequest = LadderRequest.of(height);

        return GameSettingRequest.of(ladderRequest, playerRequests);
    }
}
