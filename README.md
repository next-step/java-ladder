# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
* |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 사다리 구현 목록
* 플레이어
  - [x] 이름을 알고있다.
  - [x] 좌표를 알고있다.
* 플레이어_그룹
  - [x] 플레이어들을 관리한다.
  - [x] 최소 두 명 이상의 플레이어가 있어야한다.
  - [x] 이름 개수만큼 플레이어가 생성된다.
  - [x] 플레이어가 생성되는 순서에 따라 플레이어의 x좌표가 0부터 1씩 증가한다.
  - [x] 사다리 라인 수를 알려준다. 라인 수는 플레이어 수의 -1 이다.
* 이름
  - [x] 길이는 1~5자리이다.
  - [x] 이름은 비어있을 수 없다.
* 사다리높이
  - [x] 사다리 높이를 알고있다.
  - [x] 1이상이다.
* 좌표
  - [x] x,y 각 위치 값을 알고있다.
* 위치
  - [x] 0보다 작을 수 없다.
* 사다리
  - [ ] 라인들을 관리한다.
* 라인
  - [x] 사다리의 라인 수를 알고있다.
* 라인
  - [x] 스틱들을 알고있다.
* 스틱 
  - [x] 존재 여부를 알고있다.
  - [x] 전략에 따라 존재 유무를 결정할 수 있다.
* 스틱_존재_여부_결정_전략
  - [ ] 특정 확률로 스틱의 존재 여부를 결정한다.
* 콘솔입력
  - [x] 플레이어 이름을 입력받는다.
  - [x] 사다리 높이를 입력 받는다.
* 콘솔출력
  - [ ] 사다리를 출력한다.