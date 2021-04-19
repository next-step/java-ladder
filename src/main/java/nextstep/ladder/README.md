# 사다리 기능정의

---

## 수정사항

- 사람의 이름은 5글자 제한
- 사다리의 폭이 사람의 글자수에 따라 동적으로 변해야 한다.
- 사다리의 bridge 가 존재하는 양 옆에는 다른 bridge 가 존재할 수 없다.

---

- ## enum
  - ## BridgeUi.java
    - field
      - boolean isBridge;
      - String ui;
    - constructor
      - public BridgeUi fromIsBridge(Bridge bridge);
    - method
      - public String ui();
- ## class
  - ## Ladder.java
    - field
      - List<Floor> ladder;
    - constructor
      - Ladder(List<Floor> ladder);
      - makeLadderBySize(int height, int width);
    - method
      - public String ui();
  - ## Floor.java
    - field
      - List<Bridge> floor
    - constructor
      - Floor(List<Bridge> floor);
      - public static Floor makeByWidth(int width);
    - method
      - public Bridge createBridge(Bridge lastBridge);
      - public List<Bridge> floor();
      - public String ui();
  - ## Bridge.java
    - field
      - boolean isBridge
    - constructor
      - Bridge(boolean isBridge);
      - Bridge(MakeBridge makeBridge);
    - method
      - public boolean isBridge();
  - ## Participants.java
    - field
      - List<User> participants
    - constructor
      - Participants(List<User> participants);
      - public static Participants makeByString(String str)
    - method
      - private static assureNotEmpty(String str);
      - public int numberOfParticipants();
      - public String name();
  - ## User.java
    - field
      - string name
    - constructor
      - User(String name)
    - method
      - private static assureNotEmpty(String str);
      - public String name()
