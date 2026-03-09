  
private int hashFunction( Integer key ){
        int indx=(key+3)%ht.length;
        return indx;
    }


    public void remove( Integer key ){
        int indx=hashFunction(key);
        PairNode head=ht[indx];

        PairNode current=head;
        PairNode prev=null;

        while(current!=null){
            //Judi first ei key pai
            if(prev==null && current.key.equals(key)){
                ht[indx]=current.next;
                return;
            }
            else if(prev!=null && current.key.equals(key)){
                prev.next=current.next ;
                return;
            }
            prev=current;
            current=current.next;
        }

        return;
    }

}



