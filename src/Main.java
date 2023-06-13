import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * - 컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
     * - 사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
     * - 컴퓨터는 사용자가 입력한 세자리 숫자에 대해서, 아래의 규칙대로 스트라이크(S)와 볼(B)를 알려줍니다.
     *     - 숫자의 값과 위치가 모두 일치하면 S
     *     - 숫자의 값은 일치하지만 위치가 틀렸으면 B
     * - 기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
     * - 숫자 3개를 모두 맞춘 경우, 게임을 종료합니다.
     * -------------------------------------------
     * - Java, JS에서 랜덤하게 숫자를 만드는 함수는 여러가지 방법이 있습니다.
     *     - 참고 키워드) Java 랜덤 숫자 생성, Javascript 랜덤 숫자 생성
     * - 3자리수가 모두 달라야하기 때문에, 889, 282등의 숫자가 나오면 안되겠죠? 여러가지 방법을 생각해보세요.
     * - 구현은 아래와 같은 순서로 진행해보세요.
     *     1. 랜덤 숫자 만들기
     *     2. 한자리 숫자에 대해 볼, 스크라이크 판단 하는 부분 구현하기
     *     3. 볼, 스트라이크를 표현하는 부분 구현하기
     *     4. 게임 종료하는 부분 구현하기   **/

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        //랜덤 숫자 0~9 뽑기
        int ran1 = random.nextInt(10);
        int ran2 = random.nextInt(10);
        int ran3 = random.nextInt(10);

        // while 문은 true 일때 반복. 만약 수가 같으면 true 다르다면 false 로 빠져나오게 만듬. and or 둘다 상관 없음 어차피 false 여야 빠져나옴.
        while (ran1 == ran2 || ran1 == ran3 || ran2 == ran3){
            ran2 = random.nextInt(10);
            ran3 = random.nextInt(10);
        }


        // 랜덤숫자 확인
        // System.out.print(ran1);
        // System.out.print(ran2);
        // System.out.println(ran3);

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int attempt = 1;

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        while (true){
            int ball = 0;
            int strike = 0;
            int base = sc.nextInt();
            System.out.println(attempt+"번째 시도 : "+ base);
            //12 % 10 2
            //3자리를 몫과 나머지를 이용해 구하기
            num3 = base%10;
            base = base/10;
            num2 = base%10;
            base = base/10;
            num1 = base%10;


            //456
            //123
            //첫번째 자리 비교
            if (num1 != ran1){
                if (num1 == ran2 || num1 == ran3){
                    ball++;
                }
            } else{
                strike++;
            }
            //두번째 자리 비교
            if (num2 != ran2){
                if (num2 == ran1 || num2 == ran3){
                    ball++;
                }
            } else{
                strike++;
            }
            //세번째 자리 비교
            if (num3 != ran3){
                if (num3 == ran2 || num3 == ran1){
                    ball++;
                }
            } else{
                strike++;
            }
//------------ 출력 ---------------------------
            if (ball == 0){
                //둘다 0 일 경우 0B0S 출력
                if (strike == 0){
                    System.out.println(ball+"B"+strike+"S");
                }else{
                    // ball 만 0일 경우 S 만 출력
                    System.out.println(strike+"S");
                }
            } else if (strike == 0) {
                //둘다 0 일 경우 0B0S 출력
                if (ball == 0){
                    System.out.println(ball+"B"+strike+"S");
                }else{
                    // strike 만 0일 경우 B 만 출력
                    System.out.println(ball+"B");
                }
            }else {
                // ball 과 strike  둘다 0이 아닌 경우
                System.out.println(ball+"B"+strike+"S");
            }


            //3개 모두 같은 자리에 맞는 값 입력시 반복 종료.
            if (num1 == ran1 && num2 == ran2 && num3 == ran3){
                break;
            }

            attempt++;
        }
        System.out.println((attempt-1) + "번만에 맞히셨습니다");
        System.out.println("게임을 종료합니다.");
        System.out.println(System.currentTimeMillis());

    }
}