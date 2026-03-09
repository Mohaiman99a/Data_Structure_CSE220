

System.out.println(); -> System r out variable e println() function ase


public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }



    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient p= new Patient(id, name, age, bloodgroup, null, null);

        p.next=dh;
        p.prev=dh.prev;
        dh.prev.next=p;
        dh.prev=p;
    }



    public void servePatient() {
        if(dh.next!=dh){
            Patient first= dh.next;
            System.out.println("Serving "+ first.name+ " having id"+ first.id);
            dh.next=first.next;
            dh.next.prev=dh;
        }
    }



    public void showAllPatient() {
        if(dh.next==dh){
            System.out.println("No patient in the line");
        }

      else{
       Patient current=dh.next;
       System.out.println("The patient list is: ");

            while(current!=dh){
              System.out.println(current.name + " has the id "+ current.id);
             current=current.next;
             }
      }
    }



    public Boolean canDoctorGoHome() {
        if(dh.next==dh){
            System.out.println("The doctor can go home now");
            return true;
        }
        return false;
    }



    public void cancelAll() {
        dh.next=dh;
        dh.prev=dh;
        System.out.println("All appointments are cancelled");
    }


//Doubly reverse
    public void reverseTheLine() {
        Patient current=dh.next;
        Patient temp=null;

        while(current!=dh){
            temp=current.next;
            current.next=current.prev;
            current.prev=temp;

            current=temp;
        }

            temp = dh.next;
            dh.next = dh.prev;
            dh.prev = temp;

    }


}
}

