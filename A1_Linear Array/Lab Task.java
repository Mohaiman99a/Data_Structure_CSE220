

//Task 1
import java.util.Arrays;
public class merge {
    public static void main(String[] args){
        int arr1[]={1,2,3};
        int arr2[]={2,5,6};

        int[] arr=new int[arr1.length + arr2.length];

        int index=0;
        int i1=0;
        int i2=0;

        while(i1<arr1.length && i2<arr2.length){
            if(arr1[i1]< arr2[i2]){
                arr[index]=arr1[i1];
                i1++;
                index++;
            }
            else{
                arr[index]=arr2[i2];
                i2++;
                index++;
            }
        }

        while(i1<arr1.length){       //Remaining ones
            arr[index++]=arr1[i1++];
        }
        while(i2<arr2.length){
            arr[index++]=arr2[i2++];
        }

        System.out.println(Arrays.toString(arr));
    }
}









//2

    public static void zigzagWalk(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int j = 0; j < col; j++) {
            if (j % 2 == 0) {                               //If for up to down
                for (int i = 0; i < row; i++) {
                    if ((i + j) % 2 == 0) {               //If to skip
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            } 

            
            else {
                for (int i = row - 1; i >= 0; i--) {
                    if ((i + j) % 2 == 0) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}








//3
import java.util.Arrays;
public class decryption {
    public static void main(String[] args){
        int[][] matrix={
            {1, 3, 1},
            {6, 4, 2},
            {5, 1, 7},
            {9, 3, 3},
            {8, 5, 4}
        };
        decrypt_matrix(matrix);
    }



    public static void decrypt_matrix(int[][] arr){
        int col= arr[0].length;

        int[] arrS=new int[col]; //To store sum
        int sum=0;
        int indxS=0;

        int[] arrD=new int[col-1]; //To store decrypted
        int indx=0;


        for(int j=0; j<col; j++){
            sum=0;
            for(int i=0; i<arr.length; i++){
                sum+=arr[i][j];
            }
            arrS[indxS++]=sum;
        }


        for(int k=1; k<arrS.length; k++){
            arrD[indx++]=arrS[k]-arrS[k-1];
        }


        System.out.println(Arrays.toString(arrD));
    }
    
}




