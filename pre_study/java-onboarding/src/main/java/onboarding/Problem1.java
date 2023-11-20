package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (validatePages(pobi) || validatePages(crong)) {
            return -1;
        }

        int pobi_max = getMax(pobi);
        int crong_max = getMax(crong);
        System.out.printf("포비는 %d이고 크롱은 %d 입니다.", pobi_max, crong_max);


        if (pobi_max > crong_max) {
            answer = 1;
        } else if (pobi_max < crong_max) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    private static int getMax(List<Integer> name) {
        int left_max = Math.max(getSum(name.get(0)), getTimes(name.get(0)));
        int right_max = Math.max(getSum(name.get(1)), getTimes(name.get(1)));
        return Math.max(left_max, right_max);
    }

    private static int getSum(int num) {
        int ans = 0;
        while (num >= 1) {
            int x = num % 10;
            num /= 10;
            ans += x;
        }
        return ans;
    }

    private static int getTimes(int num) {
        int ans = 1;
        while (num >= 1) {
            int x = num % 10;
            num /= 10;
            ans *= x;
        }
        return ans;
    }

    private static boolean validatePages(List<Integer> name) {
        if (name.get(0) + 1 != name.get(1)) return true;
        if (name.get(0) < 0) return true;
        return false;
    }
}