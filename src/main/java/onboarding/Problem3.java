package onboarding;

import net.bytebuddy.matcher.FilterableList;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        return check(number);
    }

    public static int check(int number){
        List<Integer> lst = new ArrayList<>();
        for (int i =0; i<number + 1; i++){
            lst.add(i);
        }

        return threeCheck(lst);
    }
    public static int threeCheck(List<Integer> num){
        int count = 0;
        for(int i = 0; i<num.size(); i++){
            int a = num.get(i) / 10;
            int b = num.get(i) % 10;
            if(a == 3 || a == 6 || a == 9) count+=1;
            if(b == 3 || b == 6 || b == 9) count+=1;
        }
        return count;
    }
}
