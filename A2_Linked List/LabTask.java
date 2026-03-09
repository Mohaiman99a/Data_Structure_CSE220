


Task 1



public static Boolean assembleCongaLine(Node head){
        
        Boolean congo=true;
        Node p=head;

        while(p.next!=null){               //p.next porjonto limit na dile IF condition e pera hobe
            if((int)p.elem>(int)p.next.elem){
                congo=false;
	    break;
            }
            p=p.next;
        }
        return congo;
    }








 Task 2



     public static Node wordDecoder( Node head ){
        
        //Counting Key
        Node current=head;
        int count=0;
        while(current!=null){
            count++;
            current=current.next;
        }
        int key= 13%count;


        //New linked list
        Node dHead= new Node(null, null);
        Node current2=dHead;

        Node current3=head;
        int count2=0;

        while(current3!=null){
            if(count2%key==0 && count2!=0){
                current2.next=new Node(current3.elem);
                current2=current2.next;
            }
            count2++;
            current3=current3.next;
        }


        //Reverse
        Node prev=null;
        Node current4=dHead.next;
        Node next=null;

        while(current4!=null){
            next= current4.next;
            current4.next=prev;
            prev=current4;
            current4=next;
        }

        return prev;              //Always head return hoy except when it’s reversed
    }


