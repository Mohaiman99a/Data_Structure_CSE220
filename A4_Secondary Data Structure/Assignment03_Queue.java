


  public static String removeConsecDups(String word){
    LinkedListQueue q=new LinkedListQueue();
    String st="";

    char prev= word.charAt(0);
     q.enqueue(prev);
    
        for(int i=1; i<word.length(); i++){
            char current=word.charAt(i);
            if((current==prev)==false){
                q.enqueue(current);
                prev=current;     //Only enqueue hole shift hobe
            }
        }

        while(q.isEmpty()==false){
            st+=q.dequeue();
        }


    return st;
    }





