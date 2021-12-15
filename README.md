# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항

1. 참여할 사람 이름 입력받기
    * Player : 참가자를 의미하는 객체다.
    * Name : 참가자의 이름을 의미하는 객체다.
    * 빈 값이면 예외가 발생한다.
    * 이름 길이가 5를 넘으면 예외가 발생한다.
    * 2명 보다 참여할 사람 이름이 적으면 예외가 발생한다.
    * 중복된 참가자가 있으면 예외가 발생한다.

2. 최대 사다리 높이 입력받기
    * Height : 사다리 높이를 의미하는 객체다.
    * 숫자가 아니면 예외가 발생한다.
    * 0보다 작은 수면 예외가 발생한다.
 
3. 실행결과 받기 
   * 참여할 사람 이름 입력받는 것과 거의 동일, 다만 객체이름은 Result
   
4. 사다리 만들기
    * Ladder : 사다리
    * Line : 사다리의 가로 한 줄을 의미한다.
    * Point : 사다리 가로에서 선을 그릴 수 있는 각 좌표를 의미한다.
      * index : 해당 좌표
      * Direction : 해당 좌표의 왼쪽 오른쪽을 의미한다.
         * left : 왼쪽이 선이라면 true, 선이 아니라면 false
         * right : 오른쪽이 선이라면 true, 선이 아니라면 false
    * 첫번째 Point의 left는 false다. (항상 맨 왼쪽에는 선이 그려지지 않는다.)
    * Point의 right이 true면 다음 Point의 right는 반드시 false
      * 다음 Point의 left는 이전 Point의 right 값
      * 선을 그린 좌표 다음 좌표는 선을 그리지 않는다.

5. 사다리 결과 계산하기
   * resultOf > 입력하는 조회하려는 결과
   * resultOf 가 all 이면 모든 결과 계산
   * 결과를 조회하려는 참가자의 시작점 에서 left, right중 true 값을 찾는다.
   * true인 곳으로 point의 index 이동, 없다면 유지
   * 다음 라인으로 이동한다.
   * 결과를 GameResult 객체에 저장한다.
   * GameResult
      * name : 결과를 조회한 참가자 이름
      * resultIndex : 사다리 타기 결과 index (Results의 index)

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)
