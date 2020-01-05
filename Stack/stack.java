import java.util.Scanner;

class Stack{
    class Node{
        public int data;
        public Node link;

        Node(){             // simple node
            data =0;
            link = null;
        }

        Node(int n){        //a node with a given value
            data = n;
            link = null;
        }

        Node(int n, Node p){   // node with given value and refernce
            data = n;
            link = p;
        }
        public void setLink(Node n){
            link = n;
        }

        public void setData(int d){
            data = d;
        }

        public Node getLink(){
            return link;
        }

        public int getData(){
            return data;
        }
    }
    public Node top = null;
    public int size;

    public void push(int value){
        Node nptr = new Node(value);
        nptr.setLink(top);
        top = nptr;
        size++;
    }

    public int pop(){
        int val = top.getData();
        top = top.getLink();
        size--;
        return val;
    }

    public int getTop(){
        // without removing top
        return top.getData();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if(size <= 0){
            return true;
        }
        return false;
    }

    public int postfix(){
        while (there are tokens in the string) {
            get next token
            if (token is an Operator) {
                int op2 = stack.pop()
                int op1 = stack.pop()
                int res = result after operation with op1 and op2;
                stack.push(res);
            }
            else{

                stack.push (token);
            }
        }
    }
}