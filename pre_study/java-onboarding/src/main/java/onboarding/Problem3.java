package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // answer[i] 에는 i번째 숫자 까지 나온 3,6,9의 개수가 들어 간다.
        int[] answer = new int[number + 1];

        for (int i = 2; i <= number; i++) {
            int count = count369(i);
            answer[i] = answer[i - 1] + count;
        }

        return answer[number];
    }

    // 정수 n 에 들어간 3,6,9의 개수를 반환 한다.
    private static int count369(int number) {
        int count = 0;
        while (number > 0) {
            int n = number % 10;
            if (n == 3 || n == 6 || n == 9) {
                count += 1;
            }
            number /= 10;
        }
        return count;
    }
}
