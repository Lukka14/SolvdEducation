package collections.mycollections;

//A node is an entity to store data in the linked list along with the link to the next node
class Node<T> {
    T data;
    Node next;

    public Node(T data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Node() {
        data = null;
        next = null;
    }

    public Node getNode() {
        return (next);
    }

    public T getData() {
        return (data);
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
