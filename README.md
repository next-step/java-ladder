# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)1

## step2
- Line은 가로 한줄을 의미한다.
- Line에서 하나의 connection의 존재 유무는 boolean으로 표현한다.
- Line에서 만약 전 connection이 true였다면 다음에 그려질 connection은 무조건 false다.
- Line에서 만약 전 connection이 false였다면 다음에 그려질 connection은 true 또는 false다.
- 사다리(Ladder)는 Line의 List를 갖고 있다.
- 사다리게임에 참여하는 플레이어들을 일급콜렉션으로 관리한다.
- 플레이어는 String을 원시값 포장한 Name이라는 객체를 가지고 있다.

### exception
- 참여한 사람의 이름은 5이하이다.
  - 길이가 5가 넘으면 예외처리
- 플레이어는 여러명 참가해야 게임진행이 가능하다.
  - 한명만 입력되면 예외를 던진다.
  
## step3
- 사다리게임 결과를 입력한다.
- 결과를 보고 싶은 사람을 입력한다.

### exception
- 사다리 게임 결과의 수는 플레이어의 수와 같다
  - 수가 맞지않으면 예외를 던진다.
- 결과를 보고싶은 플레이어를 입력했는데 만약 그 플레이어가 존재하지않는다면 예외를 던진다.

  
  