

  //1
   public static String checkSimilar( Node building1, Node building2 ){

        Node current1=building1;
        Node current2=building2;

        boolean similar=false;
        String type="";

        //Checking
        while(current1!=null && current2!=null){
            String a=(String)current1.elem;
            String b=(String)current2.elem;

            if(a.equals(b)){
                similar=true;
            }
            else if(!a.equals(b)){
                similar=false;
                break;
           }
            current1=current1.next;
            current2=current2.next;
        }


        //Last e jawar por baki thakle
        if(current1!=null && current2==null){            
            similar=false;
        }

        else if(current1==null && current2!=null){            
            similar=false;
        }


        if(similar==true){       //Don't use "=" it means assign kora
            type="Similar";
        }
        else if(similar==false){
            type="Not Similar";
        }

        return type;
    }










//2

public static Node organizeBooks(Node head, Integer[] popularity) {

    for(int i=0; i<popularity.length-1; i++){
        Node current=head;  //Every time loop e current ke front e back korano lagbe

      .  for(int j=0; j<popularity.length-1-i; j++){
            if(popularity[j]<popularity[j+1] && current.next!=null){
                                                                    
            Object temp1=current.elem;            //Elements exchange, not the nodes
            current.elem=current.next.elem;
            current.next.elem=temp1;

            int temp2=popularity[j];
            popularity[j]=popularity[j+1];
            popularity[j+1]=temp2;
            }

            current=current.next;
       . }
    }
        

  return head; 
}









//3

   public static Node alternateMerge( Node head1, Node head2 ){
        Node current1=head1;
        Node current2=head2;

        while(current1!=null && current2!=null){   //Ulta right angle triangle r moto traverse korbe
            Node next1=current1.next;
            Node next2=current2.next;

            current1.next=current2;
            current2.next=next1;
            
            current1=next1;
            current2=next2;

        }


        return head1;
    }









//4

   public static Node idGenerator(Node head1, Node head2, Node head3) {
        
        //Reversing first LL
        Node prev= null;
        Node n1=head1;
        Node next=null;

        while(n1!=null){          //n1.next dile last e reverse hobe na
            next=n1.next;
            n1.next=prev;
            prev= n1;
            n1=next;
        }


        //n1 ke last e back korano cuz n1 NULL e chole gese
        n1=prev;
        while(n1.next!=null){
            n1=n1.next;
        }



        //Making a new LL by adding both
        Node n2=head2;
        Node n3=head3;

        while(n2!=null && n3!=null){
            Node add=new Node(null, null);

            int sum=(int)n2.elem + (int)n3.elem;
            if(sum>=10){
                sum=sum%10;
            }
            
            add.elem=sum;
            n1.next=add;
            n1=n1.next;

            n2=n2.next;
            n3=n3.next;
        }

        return prev;
    
    }
