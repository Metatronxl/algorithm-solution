
import java.util.*;

/**
 * Created by xulei2 on 2017/3/30.
 */
public class Main {

    
    //利用异或运算，相同为0，不同为1，遍历完一遍数组后，再与下标遍历一遍，得到的数便是没有与1相对的那个缺失的数
    //这个方法存在的局限性在于数组必须从0开始。
    int missingNumber(int[] numArray){
         int x = 0;
        for(int i=0;i<=numArray.length;i++){
            x ^=i;
        }
        for(int i=0;i<numArray.length;i++){
            x ^= numArray[i];
        }

        return x;
    }

    public static void main(String[] args){

            Main test = new Main();
            int[] array = new int[]{1,2,3,4,5,6,7,8};
            int res = test.missingNumber(array);
            System.out.println(res);



    }
}
