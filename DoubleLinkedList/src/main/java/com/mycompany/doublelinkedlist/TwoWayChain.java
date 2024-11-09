package com.mycompany.doublelinkedlist;



import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class TwoWayChain<T> implements Iterable<T> {

    public T Data;
    public TwoWayChain<T> Prev;
    public TwoWayChain<T> Next;

    public TwoWayChain(T data) {
        this.Data = data;
        this.Prev = null;
        this.Next = null;
    }

    public TwoWayChain<T> Move(Function<TwoWayChain<T>, TwoWayChain<T>> func) {
        TwoWayChain<T> current = this;
        while (func.apply(current) != null) {
            current = func.apply(current);
        }
        return current;
    }

    public TwoWayChain<T> First() {
        return this.Move(current -> current.Prev);
    }

    public TwoWayChain<T> Last() {
        return this.Move(current -> current.Next);
    }

    public TwoWayChain<T> insertAfter(TwoWayChain<T> twc) {
        TwoWayChain<T> firstInTwc = twc.First();
        TwoWayChain<T> lastInTwc = twc.Last();

        lastInTwc.Next = this.Next;
        firstInTwc.Prev = this;

        if (this.Next != null) {
            this.Next.Prev = lastInTwc;
        }
        this.Next = firstInTwc;

        return twc.First();
    }

    public void add_at_front(TwoWayChain<T> twc) {
        TwoWayChain<T> first = this.First();
        TwoWayChain<T> firstInTwc = twc.First();
        TwoWayChain<T> lastInTwc = twc.Last();

        firstInTwc.Prev = null;
        lastInTwc.Next = first;
        first.Prev = lastInTwc;
    }

    public void add_at_end(TwoWayChain<T> twc) {
        TwoWayChain<T> last = this.Last();
        TwoWayChain<T> lastInTwc = twc.Last();
        TwoWayChain<T> firstInTwc = twc.First();

        lastInTwc.Next = null;
        last.Next = firstInTwc;
        firstInTwc.Prev = last;
    }

    public TwoWayChain<T> Remove() {
        if (this.Prev != null) {
            this.Prev.Next = this.Next;
        }
        if (this.Next != null) {
            this.Next.Prev = this.Prev;
        }
        return (this.Next != null) ? this.Next : this.Prev;
    }

    public TwoWayChain<T> delete_at_front() {
        TwoWayChain<T> ElementAtFront = this.First();
        return ElementAtFront.Remove();
    }

    public TwoWayChain<T> delete_at_end() {
        TwoWayChain<T> ElementAtEnd = this.Last();
        return ElementAtEnd.Remove();
    }

    public void PrintChain() {
        TwoWayChain<T> current = this.First();
        while (current != null) {
            System.out.print(current.Data + " ");
            current = current.Next;
        }
        System.out.println();
    }

    // New findAll method that accepts a lambda and returns a new TwoWayChain of matching elements
    public TwoWayChain<T> findAll(Predicate<T> predicate) {
        TwoWayChain<T> current = this.First();
        TwoWayChain<T> resultHead = null;
        TwoWayChain<T> resultTail = null;

        while (current != null) {
            if (predicate.test(current.Data)) {
                TwoWayChain<T> newNode = new TwoWayChain<>(current.Data);

                if (resultHead == null) {
                    resultHead = newNode;  // Initialize the head of the new chain
                    resultTail = newNode;  // Initialize the tail of the new chain
                } else {
                    resultTail.Next = newNode;
                    newNode.Prev = resultTail;
                    resultTail = newNode;
                }
            }
            current = current.Next;
        }

        return resultHead;
    }

    public TwoWayChain<T> searchFirstAppearance(Predicate<T> predicate) {
        TwoWayChain<T> current = this.First();

        while (current != null) {
            if (predicate.test(current.Data)) {
                return current;  // Return the first matching element
            }
            current = current.Next;
        }

        return null;  // Return null if no element matches the predicate
    }

    // Method to count how many elements match the predicate
    public int countAppearance(Predicate<T> predicate) {
        int count = 0;
        TwoWayChain<T> current = this.First();

        while (current != null) {
            if (predicate.test(current.Data)) {
                count++;  // Increment count for matching element
            }
            current = current.Next;
        }

        return count;  // Return the total count of matching elements
    }
    
    
    // Implementing Iterable interface to allow foreach iteration
    @Override
    public Iterator<T> iterator() {
        return new TwoWayChainIterator(this.First());
    }

    // Inner Iterator class for TwoWayChain
    private class TwoWayChainIterator implements Iterator<T> {
        private TwoWayChain<T> current;

        public TwoWayChainIterator(TwoWayChain<T> start) {
            this.current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.Data;
            current = current.Next;
            return data;
        }
    }
}
