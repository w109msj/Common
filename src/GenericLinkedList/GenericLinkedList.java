/*
* GenericLinkedList
*
* A general-purpose linked list class built using generics
*
* Version 1.0
* 2/21/2014
*
* Michael Jacobs
*/

package GenericLinkedList;


public class GenericLinkedList <T> {
    
    private int size = 0;
    private GenericLink<T> start = null;
    
    public GenericLinkedList() {
        size = 0;
        start = null;
    }
    
    public int getSize(){
        return size;
    }
    
    public T getAt(int n){
        return this.getLinkAt(n).getObject();
    }
    
    public void add(T t){
        if (size == 0) start = new GenericLink<>(t);
        else this.getLastLink().setNext(new GenericLink<>(t));
        size++;
    }
    
    public void add(T t, int n){
        if ((n >= size) || (n < 0)) return;
        else if (n == 0) {
            if (start == null) start = new GenericLink<>(t);
            else {
                GenericLink<T> tempLink = new GenericLink<>(t, start);
                start = tempLink;
            }
        } else {
            GenericLink<T> prevLink = this.getLinkAt(n - 1);
            GenericLink<T> tempLink = new GenericLink<>(t, prevLink.getNext());
            prevLink.setNext(tempLink);
        }
    }
    
    public void remove(int n){
        if (n >= size || n < 0) return;
        else if (n == 0) start = start.getNext();
        else {
            GenericLink<T> prevLink = this.getLinkAt(n - 1);
            prevLink.setNext(prevLink.getNext().getNext());
        }
        size--;
    }
    
    private GenericLink<T> getLastLink(){
        if (size == 0) return null;
        else {
            GenericLink<T> currentLink = start;
            while(currentLink.getNext() != null) 
                currentLink = currentLink.getNext();
            return currentLink;
            }
    }
    
    private GenericLink<T> getLinkAt(int n){
        if (n == 0) return start;
        else if (n >= size || n < 0) return null;
        else {
            GenericLink<T> currentLink = start;
            for (int i = 0; i < n; i++){
                currentLink = currentLink.getNext();
            }
            return currentLink;
        }
    }
    
}
