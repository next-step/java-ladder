package ladder;

import ladder.service.LadderService;

public class LadderMain {
    public static void main(String[] args)  {
        LadderService ladderService = new LadderService();
        ladderService.createUsers();
    }
}
