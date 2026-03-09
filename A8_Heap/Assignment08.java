

  
 private static Integer[] machineTask(Integer[]tasks,int m){
        MinHeap mH= new MinHeap(tasks.length);

        //Inserting and then taking out the minimum
        for(int i=0; i<tasks.length; i++){
            mH.insert(tasks[i]);
        }
        Integer min= mH.delete();


         //Creating another Heap array with all zeros
        MinHeap newHeap=new MinHeap(tasks.length);
        for(int i=0; i<m; i++){
            newHeap.insert(0);
        }

        //Inputing all the ones till length
        int change= tasks.length-m;
        for(int i=0; i<change; i++){
            newHeap.delete();
            newHeap.insert(tasks[i]);
        }

        //Adding the extra one
        for(int i=0; i<tasks.length-change; i++){
            Integer store= newHeap.delete();
            Integer newAdd= store + tasks[change+i];
            newHeap.insert(newAdd);
        }

        //Converting to integer
        Integer[] arr2=new Integer[m];
        for(int i=0; i<m; i++){
            arr2[i]= newHeap.delete();
        }
        return arr2;
    } 







Largest Elements in Descending Order





   public static Integer[] largestDesArray(Integer[] nums, int k){
      
        //Filling up max heap
        MaxHeap H= new MaxHeap(nums.length);
         for(int i=0; i<nums.length; i++){
           H.insert(nums[i]);
        }

        
        //Filling up new array
        Integer[] arr2= new Integer[k +1];
        for(int i=0; i<arr2.length; i++){
            arr2[i]= H.deleteMax();
        }

        return arr2; 
    }









//Here a  special HeapMax is taken that will take both int and String
//swim will happen based on priority(int)
//swap will happen based on priority(int). CusHEapMax is being swapped
// Delete will return String

    public static String[] priorityArr(String[] taskName, int[] priorities){
        MaxHeap H= new MaxHeap(taskName.length);
        
        for(int i=0; i<taskName.length; i++){
            H.insert(taskName[i], priorities[i]);
        }


        String[] arr2= new String[taskName.length];
        for(int i=0; i<taskName.length; i++){
            arr2[i]= H.deleteMax();
        }

        return arr2;
    }

