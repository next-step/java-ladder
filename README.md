# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# 사다리 (리펙토링)
## 구현 기능 
*  Direction 객체 
1. 각 Point의 좌/우 방향 정보를 가진다. 
2. 현재 Point에서 다음 Point를 생성하는 역활  
3. 초기화 함수: 포인트(left,right) 값을 세팅/ 단, left,right 값은 동시에 TRUE가 될 수가 없다.
4. first 함수: 첫 번째 Point의 left 값을 FALSE로 설정
5. last 함수: 마지막 point의 right 값을 FALSE로 설정
6. next 함수: 마지막 right값에 따라서 TRUE -> FALSE/ FALSE -> RANDOM값 생성 
