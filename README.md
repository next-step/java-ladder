# Step2 - 사다리 (생성)
Q. 가로줄은 조건만 맞으면 랜덤으로 생성되는건가요 ,,?


기능
[View]
1. 사용자의 이름을 입력받는다(,기준)
2. 최대 사다리의 높이를 입력받는다.

1. 생성된 사다리를 출력한다.(5자 기준이라 폭도 넓게)


[Domain]
**BaseUserLine**
1. 유저는 5자 이내이름과 최대 사다리 높이만큼의 Point를 가진다. 
: name, List<Point> Points --> 연결되었는지 아닌지.
 
| - Point 1
| - Point 2
| - Point 3 
 
** Point ** 
1. BaseUserLine 의 각 높이지점  
boolean leftConnected -> 옆의 Point와 연결되어있는지
boolean rightConnected -> 옆의 Point와 연결되어있는지 
- point 는 같아야한다. 같은 높이에 대해서만 라인을 그을 수 있다.

cf) 양 끝의 BaseUserLine은 각각 left, right 를 연결할 수 없다.

**Ladder**
```java
List<BaseUserLine> baseUserLines
```
 
1. 최대 사다리의 높이를 가지고 BaseUserLine 을 생성한다.
2. 사다리 라인을 그린다.
- 현재 그리는 라인의 전, 전전 라인이 연결되어있으면 그릴 수 없다.
게임진행을 위해 아래는 필수로 그린다.  
```java
baseUserLines.get(0).getPoints().get(0).connect;
baseUserLines.get(size-1).getPoints().get(size-1).connect;
```
| ----- |       |
|       |       |
|       | ----- |
 
- 그리고 각 BaseLine을 기준으로 오른쪽으로만 그림그리기를 시도한다. - Random
- 그림을 그리면 자신의 rightConnect를 true로 바꿀 뿐 아니라, 오른쪽 BaseLine의 leftConnect도 true로 바꿔야한다. 





# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)