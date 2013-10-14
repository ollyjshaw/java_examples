package java_examples_parent;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/*
 * A totally contrived stack just to show a generic class and some PECS methods
 */
public class TypedStack<E> {
    List<E> internalList = new LinkedList<E>();

    public E pop() {
        E removed = internalList.remove(internalList.size() - 1);
        return removed;
    }

    public void push(E elementToAdd) {
        internalList.add(elementToAdd);
    }

    public void pushAll(Collection<? extends E> collection) {
        for (E item : collection) {
            this.push(item);
        }
    }

    public void popAllToList(Collection<? super E> collection) {
        while (!this.empty()) {
            collection.add(this.pop());
        }
    }

    public boolean empty() {
        return this.internalList.size() == 0;
    }

    public int size() {
        return internalList.size();
    }
}
