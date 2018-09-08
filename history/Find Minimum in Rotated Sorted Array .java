import java.util.*;

/**
 * Created by xulei2 on 2017/3/30.
 */
public class Main {

    int returnMinNum(int[] array){

        int len = array.length;
        if (len == 0){
            return -1;
        }else if(len ==1){
            return array[0];
        }else if(len ==2){
            return Math.min(array[0],array[1]);
        }else{
            int first = 0;
            int last = len-1;
            int mid = (last-first)/2;
            //使用Arrays.copyOfRange来获取子数组
            //函数注意点：Arrays.copyOfRange(array,from,to)的to的节点不会获得那个节点的数
            //所以to的节点必须+1
            if(array[mid]>array[first] && array[first]<array[last]){
                int newArray[] = Arrays.copyOfRange(array,first,mid+1);
                return returnMinNum(newArray);
            }else if (array[mid]>array[first] && array[first]>array[last]){
                int newArray[] = Arrays.copyOfRange(array,mid,last+1);
                return returnMinNum(newArray);
            }else if(array[mid]<array[first]){
                int newArray[] = Arrays.copyOfRange(array,first,mid+1);
                return returnMinNum(newArray);
            }else {
                System.out.println("ERROR");
                return -2;
            }
        }


    }


    public static void main(String[] args){

            Main test = new Main();

            int[] array_a = new int[]{0,1,2,4,5,6,7,9};

             int num = test.returnMinNum(array_a);
            System.out.println(num);


    }
}
