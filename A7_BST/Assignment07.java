

    public static Integer rangeSum( BSTNode root, Integer low, Integer high ){
        //Storing everything in an array
        Integer[] arr=new Integer[10];
        int n=1;

        fillArray(root, arr,n);

        //Finding sum after filling the array
        int sum=0;
        for(int i=1; i<arr.length; i++){
        if(arr[i]!=null && arr[i]>=low && arr[i]<=high){
                sum= sum+arr[i];
            }
        }

        return sum;
    }





    private static void fillArray(BSTNode root, Integer[] arr, int n){
        if(root==null){
            return;
        }

        arr[n]=root.elem;
        fillArray(root.left, arr,2*n);
        fillArray(root.right, arr, 2*n+1);

        return;
    }











 public static Integer mirrorSum( BSTNode root ){
        if(root==null){
            return null;
        }

        int sum= addMirror(root.left, root.right); //Add main with mirror

        return sum;
    }


    private static int addMirror(BSTNode L, BSTNode R){
        if(R==null || L==null){
            return 0;
        }

        return L.elem + R.elem + addMirror(L.left, R.right)+ addMirror(L.right, R.left);
    }







   public static Boolean isBST(BSTNode root ){
        if(root==null)   return true;

        //For a specific node
        boolean leftAllSmaller= leftCheck(root.left, root);
        boolean rightAllBigger= rightCheck(root.right, root);

        if(leftAllSmaller==false || rightAllBigger==false){
            return false;
        }

        //Baki child node r jonno
        if(isBST(root.left)==false || isBST(root.right)==false){
            return false;
        }
        return true;
    }




    private static Boolean leftCheck(BSTNode root, BSTNode a){
        if(root==null)  return true;

        int val=a.elem;
        if(root.elem>=val){
            return false;
        }

        if(leftCheck(root.left,a)==false || leftCheck(root.right,a)==false){
            return false;
        }
        return true;
    }



    private static Boolean rightCheck(BSTNode root, BSTNode a){
        if(root==null)    return true;


        int val=a.elem;
        if(root.elem<=val){
            return false;
        }

        return rightCheck(root.left,a) && rightCheck(root.right,a);
    }
 

