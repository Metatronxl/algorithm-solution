import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by xulei2 on 2017/3/30.
 */
public class Main {

    //将Array转成set去除重复元素
    //HaseSet<>中的参数只支持Integer，所以要将int转用Integer实现
    //
    int arrayToSet(Integer[] array){
        Set<Integer> setArray = new HashSet<Integer>(Arrays.asList(array)) ;
        Integer[] resArray = new Integer[setArray.size()];
        setArray.toArray(resArray);
        int res = returnMinNum(resArray);

        return res;

    }
    int returnMinNum(Integer[] array){

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
                Integer[] newArray = Arrays.copyOfRange(array,first,mid+1);
                return returnMinNum(newArray);
            }else if (array[mid]>array[first] && array[first]>array[last]){
                Integer[] newArray= Arrays.copyOfRange(array,mid,last+1);
                return returnMinNum(newArray);
            }else if(array[mid]<array[first]){
                Integer[] newArray= Arrays.copyOfRange(array,first,mid+1);
                return returnMinNum(newArray);
            }else {
                System.out.println("ERROR");
                return -2;
            }
        }


    }


    public static void main(String[] args){

            Main test = new Main();

            Integer[] array_a = new Integer[]{2,4,4,4,4,5,6,7,7,7,7,7,9,0,1,1,1,1,1,2,2,2,2};

             int num = test.arrayToSet(array_a);
            System.out.println(num);


    }
}
