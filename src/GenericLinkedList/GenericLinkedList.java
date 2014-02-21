/*
* GenericLinkedList
*
* A general-purpose linked list class built using generics
*
* Michael Jacobs
* 2/21/2014
*/

package GenericLinkedList;


public class GenericLinkedList <T> {
    
    private int size = 0;
    private GenericLink<T> firstLink = null;
    
    public GenericLinkedList() {
        size = 0;
        firstLink = null;
    }
    
    public int getSize(){
        return size;
    }
    
    public T getAt(int n){
        return this.getLinkAt(n).getObject();
    }
    
    public void add(T t){
        if (size == 0) firstLink = new GenericLink<>(t);
        else this.getLastLink().setNext(new GenericLink<>(t));
        size++;
    }
    
    public void add(T t, int n){
        if ((n >= size) || (n < 0)) return;
        else if (n == 0) {
            if (firstLink == null) firstLink = new GenericLink<>(t);
            else {
                GenericLink<T> tempLink = new GenericLink<>(t, firstLink);
                firstLink = tempLink;
            }
        } else {
            GenericLink<T> prevLink = this.getLinkAt(n - 1);
            GenericLink<T> tempLink = new GenericLink<>(t, prevLink.getNext());
            prevLink.setNext(tempLink);
        }
    }
    
    public void remove(int n){
        if (n >= size || n < 0) return;
        else if (n == 0) firstLink = firstLink.getNext();
        else {
            GenericLink<T> prevLink = this.getLinkAt(n - 1);
            prevLink.setNext(prevLink.getNext().getNext());
        }
        size--;
    }
    
    private GenericLink<T> getLastLink(){
        if (size == 0) return null;
        else {
            GenericLink<T> currentLink = firstLink;
            while(currentLink.getNext() != null) 
                currentLink = currentLink.getNext();
            return currentLink;
            }
    }
    
    private GenericLink<T> getLinkAt(int n){
        if (n == 0) return firstLink;
        else if (n >= size || n < 0) return null;
        else {
            GenericLink<T> currentLink = firstLink;
            for (int i = 0; i < n; i++){
                currentLink = currentLink.getNext();
            }
            return currentLink;
        }
    }
    
}
