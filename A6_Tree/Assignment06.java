

 public static void swapChild( BTNode root, int lvl, int M ){
        helper(root, lvl, M);
    }

    private static BTNode helper(BTNode root, int lvl, int M){
        if (root==null){
            return null;
        }

        BTNode left= helper(root.left, lvl+1, M-1);
        BTNode right= helper(root.right, lvl+1, M-1);

        if(M >0){
            root.left=right;
            root.right=left;      
        }

        else{
            root.left=left;
            root.right=right;
        }

        return root;
    }












  public static Integer subtractSummation( BTNode root ){
        Integer left= (Integer) root.left.elem + sum(root.left);
        Integer right= (Integer) root.right.elem + sum(root.right);
        return left-right; 
    }

    private static Integer sum(BTNode root){
        if(root==null){
            return 0;
        }
        Integer currLeft=0,currRight=0;

        if(root.left!=null){
            currLeft= (Integer)root.left.elem;
        }

        if(root.right!=null){
            currRight= (Integer)root.right.elem;
        }

        return  currLeft + currRight + sum(root.left)+ sum(root.right);
    }









public static Integer levelSum( BTNode root ){
        Integer sum= helper(root, 0);
        return sum;
    }

    private static Integer helper(BTNode root, int level){
        if(root==null){
            return 0;
        }

        Integer value=0; 
        if(level%2==0){
            value= ((-1)*(Integer) root.elem);      //return hobe na ei line e
        }

        if(level%2!=0){
            value= (Integer) root.elem;
        }

        return value + helper(root.left, level+1) + helper(root.right, level+1);
    }

