package ua.khpi.oop.lab10.container;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class JournalContainer<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public JournalContainer() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T item) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = item;
    }

    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T removedItem = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedItem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        int newCapacity = elements.length * 2;
        T[] newElements = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некоректний індекс: " + index + " Розмір: " + size);
        }
    }

    public Iterator<T> iterator() {
        return new JournalIterator();
    }

    private class JournalIterator implements Iterator<T> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Немає елементів для обходу");
            }
            return elements[currentIndex++];
        }
    }
}