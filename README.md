# 사다리 게임
## 기능 요구 사항
- 사다리게임에 필요한 객체를 아래와 같이 나누었습니다.
1. Ladder (Line을 포함하고 있음)
2. Line (Point를 포함하고 있음)
3. Point (점, 좌표값 정보를 가짐)

### Point
- 좌표값을 가지는 객체로 int를 Wrapping 합니다.
- 음수는 들어갈 수 없어야 합니다.

### Line
- 사다리의 층을 표시하는 개념으로, 참가자 수 만큼 Point를 가집니다.
- Point와 Point를 서로 이어주는 Bridge 기능이 있습니다.

### Ladder
- 사다리의 높이는 1 이상이어야 합니다.
- 개별 Line에 대해 좌표를 입력해 Bridge를 만들 수 있습니다.
- 해당 좌표는 랜덤으로 생성될 수도 있습니다.
- 만들어진 Bridge를 이용하여, 최종 Point를 확인합니다.

<br>

- 아래는 게임 플레이외 정보를 표시해주는 객체 입니다.
1. Players (Player를 포함하고 있음)
2. Player (Point를 포함하고 있음)
3. Prizes (Prize를 포함하고 있음)
4. Prize (사다리 타기 상품에 대한 정보를 가짐)
5. PrizeMapper (Player의 Point와 Prize를 서로 이어주는 역할)

### Players
- Player의 List를 갖는 일급 컬렉션
- 이름으로 Player를 찾을 수 있습니다.

### Player
- Player는 불변 객체 입니다.
- Player의 Point 위치를 확인합니다.
- Point가 바뀌면, 해당 Point를 가진 Player를 반환합니다.

### Prizes
- Prize를 List를 갖는 일급 컬렉션
- Player의 Point에 따라 적합한 Prize를 찾아 반환합니다.
- Prize의 이름을 차례대로 출력합니다.

### Prize
- 상품에 대한 객체 입니다. (상품 이름을 가진 String을 Wrapping 한 것)

### PrizeMapper
- Player의 이름을 입력하면, Prizes에서 Player의 Point에 맞는 Prize를 반환합니다.
- `all`을 입력하면, 모든 Player의 Point에 맞는 Prize를 반환합니다.

## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)