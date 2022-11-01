package ladderapplication;

import ladderapplication.models.Ladder;
import ladderapplication.models.requests.GameSettingRequest;
import ladderapplication.ui.Printer;

public class LadderApplication {

    public static void main(String[] args) {
        GameSettingRequest gameSettingRequest = Printer.requestGameSetting();

        Ladder ladder = Ladder.from(gameSettingRequest);
        ladder.print();
    }

}
