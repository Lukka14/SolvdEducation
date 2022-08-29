package collections.mycollections;

public class MyLinkedList<T> {
        Node<T> ndStart = new Node<T>();
        Node<T> ndEnd = new Node<T>();
        int size;

        public MyLinkedList() {

            ndStart=null;
            ndEnd=null;
        }

        public boolean isEmpty()
        {
            return ndStart==null;
        }

        public int getSize()
        {
            return size;
        }

        public void addLast(T data)
        {
            Node<T> newNode = new Node<T>(data,null);
            if(ndStart==null)
            {

                ndStart=newNode;
                ndEnd=newNode;
            }
            else
            {

                ndEnd.next=newNode;
                ndEnd=newNode;
            }
            size++;
        }

        public void addFirst(T data)
        {

            Node<T> newNode = new Node<T>(data,null);
            if(ndStart==null)
            {

                ndStart=newNode;
                ndEnd=newNode;
            }
            else
            {


                newNode.next=ndStart;
                ndStart=newNode;
            }
            size++;
        }

        public String toString() {
            if (ndStart==null){
                return("Empty");
            }
            Node nptr= ndStart;
            String ret;
            ret="[";

            do{
                ret=ret+nptr.data.toString() + ",";
                nptr=nptr.next;
            }
            while (nptr!=null);

            ret= ret.substring(0,ret.length()-1) + "]";

            return ret;

        }
}
