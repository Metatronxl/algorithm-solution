import java.util.HashMap;


class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}


/**
 * Created by xulei2 on 2017/3/30.
 */
public class Main {

     /*

                  1
          --------|-------
          2               3
      ----|----       ----|----
      4       5       6        7

         前序遍历 1245367
         中序遍历 4251637
         后续遍历 4526731
         
        采用递归的思想，首先后续遍历的最后一个数，必然是前序排列的root节点，并且这个root节点是中序排列的中间节点，
        所以使用HashMap将中序每个数和他们的节点号记录（可以根据数字得到他们的节点号），方便进行左右递归操作。


     */



   public TreeNode getResu(int[] inorder,int[] postorder){
      if(inorder.length == 0 || postorder.length ==0){
         return null;
      }
      HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
      for(int i=0;i<inorder.length;i++){
         hm.put(inorder[i],i);
      }
      return buildTreeFunc(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
   }

   public TreeNode buildTreeFunc(int[] inorder,int is,int ie,int[] postorder,int ps,int pe,HashMap<Integer,Integer> hm)
   {
         if (ps>pe || is>ie){
            return null;
         }
         TreeNode root = new TreeNode(postorder[pe]);
         int ri = hm.get(postorder[pe]);
         TreeNode left = buildTreeFunc(inorder,is,ri-1,postorder,ps,ps+ri-is-1,hm);
         TreeNode right = buildTreeFunc(inorder,ri+1,ie,postorder,ps+ri-is, pe-1,hm);
         root.left = left;
         root.right = right;

         return root;



   }
}
