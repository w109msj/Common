/*
* GenericLink
*
* A general-purpose link class built with generics
* to be used with the GenericLinkedList class
*
* Michael Jacobs
* 2/21/2014
*/

package GenericLinkedList;


class GenericLink<T> {
    
    T containedObject;
    GenericLink nextLink;
    
    protected GenericLink(T t){
        containedObject = t;
        nextLink = null;
    }
    
    protected GenericLink(T t, GenericLink next){
        containedObject = t;
        nextLink = next;
    }
    
    protected T getObject(){
        return containedObject;
    }
    
    protected GenericLink getNext(){
        return nextLink;
    }  
    
    protected void setNext(GenericLink next){
        nextLink = next;
    }
}
