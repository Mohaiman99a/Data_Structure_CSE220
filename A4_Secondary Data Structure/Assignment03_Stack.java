

   private static int precedence(char a){
        if(a=='+'|| a=='-'){
            return 1;
        }

        if(a=='*'|| a=='/'){
            return 2;
        }

        if(a=='^'){
            return 3;
        }

        return -1;
    }




    public static void evalMathExpression(String expression) {
        Stack temp= new Stack();
        boolean valid=true;

        //Bracket check
        for(int i=0; i<expression.length(); i++){
            char a=expression.charAt(i);
            if(a=='(' || a=='{' || a=='['){
                temp.push(a);
            }

            else if(a==')' || a=='}' || a==']'){
                if(temp.isEmpty()){
                    valid=false;
                    break;
                }

                char top=(char)temp.pop();
                if(a==')' && top!='(' || a=='}' && top!='{' || a==']' && top!='['){
                    valid=false;
                    break;
                }
            }
        }

        if(valid==false){
            System.out.println("Invalid Expression ");
            return;
        }







        else{
            
            //Infix to postfix
            LinkedListQueue postfix=new LinkedListQueue();
            for(int i=0; i<expression.length(); i++){
                char a=expression.charAt(i);

                if(a>='0' && a<='9'){
                    postfix.enqueue(a);;
                }
                else if(a=='('){
                    temp.push(a);
                }

                else if(a==')'){
                    while(temp.isEmpty()==false && (char)temp.peek()!='(' ){
                        char p=(char)temp.pop();
                        postfix.enqueue(p);
                    }
                    temp.pop();      //Start bracket remove
                }

                else{
                    while(!temp.isEmpty() && precedence(a)<=precedence((char)temp.peek())){
                        char p=(char)temp.pop();
                        postfix.enqueue(p);
                    }
                    temp.push(a);   //Beshi or equal precedence ber kore notun ta boshano
                }
            }

            while(temp.isEmpty()==false){
                char p=(char)temp.pop();      //Extra baki thakle
                postfix.enqueue(p);
            }



            //Print
            System.out.print("Postfix: ");
            LinkedListQueue temp_postfix= new LinkedListQueue(); //underflow hobe without temp
            
            while(postfix.isEmpty()==false){
            Object value= postfix.dequeue();
            temp_postfix.enqueue(value);
            System.out.print(value+ " ");
            }

            System.out.println();




            //Infix sum
            while(temp_postfix.isEmpty()==false){
                char a=(char)temp_postfix.dequeue();

                if(a>='0' && a<='9'){
                    int num= Character.getNumericValue(a);
                    temp.push(num);
                }

                else{
                    int y=(int)temp.pop();
                    int x=(int) temp.pop();
                    int result=0;

                    if(a=='+'){
                        result=x+y;
                    }
                    else if(a=='-'){
                        result=x-y;
                    }
                    else if(a=='*'){
                        result=x*y;
                    }
                    else if(a=='/'){
                        result=x/y;
                    }
                    else if(a=='^'){
                        result=(int)Math.pow(x,y);
                    }
                    temp.push(result);
                }
            }
            System.out.println((int)temp.pop());

        }
    }








   public static Stack conditionalReverse(Stack stack) {
        Stack temp=new Stack();
        while(!stack.isEmpty()){
            int a= stack.pop();
            if(!stack.isEmpty() && a!=stack.peek()){
                temp.push(a);
            }
            else{
                temp.push(a);   //Add last element
            }
        }
        return temp; 
    }


