package collections.mycollections;

class Link<T>{
    public Link<T> nextElement;
    public T data;
    public Link(T data){
        this.data=data;
    }
}

public class MyLinkedList<T> {
    private Link<T> FirstElement;

    public void add(T data){
        Link<T> tmp=new Link<>(data);
        tmp.nextElement=FirstElement;
        FirstElement=tmp;
    }

    public T getLastElement(){
        return FirstElement.data;
    }

    public T getElement(int index){
        Link<T> element=new Link<>(null);
        for(int i=0;i<index;i++){
            element.data=FirstElement.data;
        }
        return element.data;
    }

}
