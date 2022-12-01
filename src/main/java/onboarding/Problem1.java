package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!(isValidCheck(pobi) && isValidCheck(crong))){
            return -1;
        }

        answer = calcPage(pobi, crong);

        return answer;
    }

    private static int calcPage(List<Integer> pobi, List<Integer> crong) {


        int isPobiPlus = isPlusPage(pobi); // plus max 값 곱
        int isCrongPlus = isPlusPage(crong); // plus max 값 곱
        int isPobiMulti = isMultiPage(pobi);
        int isCrongMulti = isMultiPage(crong);
        int answer = whoIsWin(isPobiPlus,isCrongPlus,isPobiMulti,isCrongMulti);
        return answer;
    }

    private static int whoIsWin(int isPobiPlus, int isCrongPlus, int isPobiMulti, int isCrongMulti) {
        int isPobiMax = Math.max(isPobiPlus,isPobiMulti);
        int isCrongMax = Math.max(isCrongPlus,isCrongMulti);
        if (isPobiMax > isCrongMax)
            return 1;
        if (isPobiMax < isCrongMax)
            return 2;

        return 0;
    }

    private static int isMultiPage(List<Integer> page) {
        int multi = 1;
        int multi_max = 0;

        for(int i = 0; i<page.size(); i++){
            String str = Integer.toString(page.get(i));
            char[] c = str.toCharArray();
            for(int j = 0; j<c.length; j++){
                multi *= c[j] - '0';
            }
            if (multi > multi_max){
                multi_max = multi;
            }
            multi = 1;
        }

        return multi_max;
    }

    private static int isPlusPage(List<Integer> page) {
        int sum = 0;
        int plus_max = 0;

        //합
        for (int i = 0; i<page.size(); i++){ //97 98
            String str = Integer.toString(page.get(i)); //"97"
            char[] c = str.toCharArray(); //char[] c = '9','7'
            for(int j = 0; j<c.length; j++){
                sum += c[j] -'0';
            }
            if(sum > plus_max){
                plus_max = sum;
            }
            sum = 0;
        }
        return plus_max;
    }

    public static boolean isValidCheck(List<Integer> page){
        //1번째 짝수
        //1번쨰 + 1 == 2번쨰
        // 1 ~ 400
        boolean isEven = isFirstPageEven(page.get(0));
        boolean isNext = isSecondPageRange(page);
        boolean isRange = isPageRange(page);
        return isEven && isNext && isRange;
    }

    private static boolean isPageRange(List<Integer> page) {
        return page.get(0) > 1 && page.get(1) < 400;
    }

    private static boolean isSecondPageRange(List<Integer> page) {
        return  (page.get(0) + 1) == page.get(1);
    }

    public static boolean isFirstPageEven(int num){
        return !(num % 2 == 0);
    }

}