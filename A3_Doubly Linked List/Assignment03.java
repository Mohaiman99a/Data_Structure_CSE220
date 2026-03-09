

//5
   public static void sumOddAppend(Node dh) {
        if(dh.next==dh){
            return;
        }

        else{
            Node current= dh.next;
            Node prev=dh;
            int sum=0;

            while(current!=dh){
                int a=(int)current.elem;

                if((int)current.elem%2==0){
                    prev=current;
                    current=current.next;
                }

                else if(a%2!=0){
                    sum+=a;
                    prev.next=current.next;    //prev isn't moving in this case
                    current=current.next;
                }
            }
	
            Node newNode=new Node(sum);
            newNode.next=dh;
            prev.next= newNode;

            return;
        }
    }









//6
   public static void pairJoin(DNode dh1, DNode dh2) {
        DNode current1=dh1.next;
        DNode current2=dh2.next;

        while(current1.next!=null){
            
            DNode temp1=current1.next;
            DNode temp2=current2.next;

            current1.next=current2;
            current2.prev=current1;

            current2.next=temp1;
            temp1.prev=current2;

            current1=temp1;
            current2=temp2;
        }

        if(current2.next==null){
        current1.next=current2;
        current2.prev=current1;
        current2.next=dh1;
        dh1.prev=current2;
        }

        else{                                     //If 2nd linked list is longer
            current1.next=current2;
            current2.prev=current1;
            while(current2.next!=null){
                current2=current2.next;
            }
            current2.next=dh1;
            dh1.prev=current2;
        }
    }







//7

      public static void rangeMove(DNode dh, int start, int end) {
        DNode prev=dh;
        DNode current=dh.next;
        DNode ogTail=dh.prev;    //To find where to stop checking

        while(current!=ogTail){
        int a=(int)current.elem;

        if(a>=start && a<=end){     // else if hole ||
            DNode tail= dh.prev;      //Locating the CURRENT TAIL
            DNode store=current;
            
            prev.next=current.next;
            current=current.next;
            current.prev=prev;

            tail.next=store;
            store.prev=tail;

            store.next=dh;
            dh.prev=store;
            tail=store;
         }

         else{
            current=current.next;
            prev=prev.next;
         }
        }
    }
