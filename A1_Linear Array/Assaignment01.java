//Task 1 (Row Rotate)



   public static Integer rowRotation( Integer examWeek, String[][] matrix ){
        int row=matrix.length;
        int col=matrix[0].length;

        int day= 1;
        int position= 0;

        //Move down until the examweek
        while(day<examWeek){
           String[] temp= matrix[row-1];
           for(int i=row-1;  i>0;  i--) {
              matrix[i] =  matrix[i-1];
            }
           matrix[0] =  temp;
           day++;
        }


       //print & finding AA
        for(int k=0; k<row; k++){
            for(int j=0; j<col; j++) {
                System.out.print(matrix[k][j]+ " | ");
	       if(matrix[i][j].equals("AA")){
                       position= i+1;
                  }
            }
            System.out.println();
        }


     return  position;
    }






//2



//2
   public static Integer[][] compressMatrix( Integer[][] matrix ){
        int row= matrix.length;
        int col=matrix[0].length;

        Integer[][] comp_matrix= new Integer[row/2][col/2];
        int row_indx;
        int col_indx;

        for(int i=0; i<row;i+=2){
            for(int j=0; j<col; j+=2){ 
                  row_indx=i/2;
                  col_indx=j/2;
                comp_matrix [row_indx][col_indx]=matrix[i][j]+ matrix[i+1][j] + matrix[i][j+1]+ matrix[i+1][j+1];
                }
            }

        return comp_matrix;
    }





//3



public static void playGame( Integer[][] arena ){
            int row= arena.length;
            int col=arena[0].length;
            int sum=0;

            for(int i=0; i<row; i++){
                for(int j=0; j<col;j++){
                    if(arena[i][j]%50==0 && arena[i][j]!=0){

                        //Up Check
                        if(i-1>=0){                               //For corner case
                          if(arena[i-1][j]==2){
                            sum+=2;
                            }
                          }

                        //Down CHeck
                        if(i+1<=row-1 && arena[i+1][j]==2){
                            sum+=2;
                            }


                        //Left Check
                        if(j-1>=0 && arena[i][j-1]==2){
                            sum+=2;
                            }

                        //Right Check
                        if(j+1<=col-1 && arena[i][j+1]==2){
                            sum+=2;
                            }
                            
                        }
                    }
                }  

                System.out.print("Points Gained: " + sum + ".");
                if(sum>=10){
                    System.out.println("Your team has survived the game.");
                }

                else{
                    System.out.println("Your team is out.");
                }
            }







//4 



public static void rotateSecret( Character[][] board ){
        int row=board.length;
        int col=board.length;

        int total_layer= row/2;

        for(int i=0; i<total_layer; i++){             //Duita layer r kaj korar jonno
           
            int no_rotation=0;
            while(no_rotation<total_layer-i){      //Outer layer gula extra time rotate r jonno
            rotate(board, i);
            no_rotation++;
            }
        }
    }



//Helper method
    public static void rotate(Character[][] board, int layer){
        int row=board.length;
        int col=board[0].length;

        int start_row=layer;
        int end_row= (row-1)-layer;
        int start_col=layer;
        int end_col= (col-1)-layer;

        Character temp = board[start_row][start_col];    //1st one stored


        //Left
        for(int i=start_row; i<end_row; i++){
            board[i][start_col]= board[i+1][start_col];
        }

        //Bottom
        for(int j=start_col; j<end_col; j++){
            board[end_row][j]= board[end_row][j+1];
        }
        
        //Right
        for(int i=end_row; i>start_row; i--){
            board[i][end_col]= board[i-1][end_col];
        }


        //Top
        for(int j=end_col; j>start_col+1; j--){
            board[start_row][j]= board[start_row][j-1];
        }

        board[start_row][start_col+1]=temp;
    }

