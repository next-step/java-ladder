package ladderapplication;

import ladderapplication.models.requests.PlayerRequest;
import ladderapplication.ui.Printer;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<PlayerRequest> playerRequests = Printer.requestPlayer();
    }

}
