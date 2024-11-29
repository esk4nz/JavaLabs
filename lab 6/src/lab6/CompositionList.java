package lab6;
import java.util.*;


/**
 * Class CompositionList implements the List interface and functions as a singly linked list
 * for storing Composition objects.
 */
public class CompositionList implements List<Composition> {

    /**
     * Inner class representing a node in the singly linked list.
     */
    private static class Node {
        Composition data;
        Node next;

        /**
         * Constructs a Node containing a {@link Composition}.
         *
         * @param data The {@link Composition} stored in this node.
         */
        Node(Composition data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    /**
     * Constructs an empty {@code CompositionList}.
     */
    public CompositionList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructs a {@code CompositionList} initialized with a single {@link Composition}.
     *
     * @param composition The {@link Composition} to initialize the list with.
     */
    public CompositionList(Composition composition) {
        this(); // Calls the empty constructor
        if (composition != null) {
            add(composition); // Adds the provided object to the list
        }
    }

    /**
     * Constructs a {@code CompositionList} initialized with the given collection of compositions.
     *
     * @param compositions A {@link Collection} of {@link Composition} objects to populate the list.
     */
    public CompositionList(Collection<? extends Composition> compositions) {
        this(); // Calls the empty constructor
        if (compositions != null) {
            addAll(compositions); // Adds each object from the collection
        }
    }

    /**
     * Adds a {@link Composition} to the end of the list.
     *
     * @param composition The {@link Composition} to be added.
     * @return {@code true} if the composition was added successfully.
     * @throws IllegalArgumentException if the composition is {@code null}.
     */
    @Override
    public boolean add(Composition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Composition cannot be null.");
        }
        Node newNode = new Node(composition);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes the specified object from the list.
     *
     * @param o The object to remove.
     * @return {@code true} if the object was successfully removed; {@code false} otherwise.
     */
    @Override
    public boolean remove(Object o) {
        if (head == null) return false;

        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Checks if the list contains all elements in the specified collection.
     *
     * @param c The collection to check for containment.
     * @return {@code true} if the list contains all elements; {@code false} otherwise.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retrieves the {@link Composition} at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The {@link Composition} at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public Composition get(int index) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    /**
     * Replaces the {@link Composition} at the specified index with a new element.
     *
     * @param index   The index of the element to replace.
     * @param element The new {@link Composition} to set.
     * @return The old {@link Composition} that was at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public Composition set(int index, Composition element) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Composition oldValue = current.data;
        current.data = element;
        return oldValue;
    }

    /**
     * Adds a {@link Composition} at the specified index.
     * <p>
     * This method is not supported in {@code CompositionList}.
     *
     * @param index   The index where the element would be added.
     * @param element The {@link Composition} to add.
     * @throws UnsupportedOperationException Always, because this operation is not implemented.
     */
    @Override
    public void add(int index, Composition element) {
        throw new UnsupportedOperationException("Add at index is not supported.");
    }

    /**
     * Removes the {@link Composition} at the specified index.
     *
     * @param index The index of the element to remove.
     * @return The removed {@link Composition}.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public Composition remove(int index) {
        checkIndex(index);

        if (index == 0) {
            Composition data = head.data;
            head = head.next;
            size--;
            return data;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Composition data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    /**
     * Returns the size of the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return {@code true} if the list is empty; {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the list contains the specified object.
     *
     * @param o The object to check.
     * @return {@code true} if the object exists in the list; {@code false} otherwise.
     */
    @Override
    public boolean contains(Object o) {
        for (Composition composition : this) {
            if (Objects.equals(composition, o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this list.
     *
     * @return An {@link Iterator} for the list.
     */
    @Override
    public Iterator<Composition> iterator() {
        return new Iterator<>() {
            private Node current = head;

            /**
             * Checks if there are more elements in the list.
             *
             * @return {@code true} if there are more elements; {@code false} otherwise.
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Returns the next {@link Composition} in the list.
             *
             * @return The next {@link Composition}.
             * @throws NoSuchElementException if there are no more elements in the list.
             */
            @Override
            public Composition next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Composition data = current.data;
                current = current.next;
                return data;
            }
        };
    }


    /**
     * Converts the list into an array of {@link Object}.
     *
     * @return An array containing all the elements in this list in proper sequence.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Composition composition : this) {
            array[index++] = composition;
        }
        return array;
    }

    /**
     * Converts the list into an array of the specified runtime type.
     * <p>
     * This method is not supported in {@code CompositionList}.
     *
     * @param a The array into which the elements would be stored.
     * @param <T> The runtime type of the array to contain the elements.
     * @throws UnsupportedOperationException Always, because this operation is not implemented.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("toArray(T[] a) is not supported.");
    }

    /**
     * Adds all the elements of the specified collection to this list.
     *
     * @param c The collection containing elements to be added to this list.
     * @return {@code true} if this list changed as a result of the call.
     */
    @Override
    public boolean addAll(Collection<? extends Composition> c) {
        for (Composition composition : c) {
            add(composition);
        }
        return !c.isEmpty();
    }

    /**
     * Adds all the elements of the specified collection at the specified index.
     * <p>
     * This method is not supported in {@code CompositionList}.
     *
     * @param index The index at which to insert the first element.
     * @param c     The collection containing elements to be added to this list.
     * @throws UnsupportedOperationException Always, because this operation is not implemented.
     */
    @Override
    public boolean addAll(int index, Collection<? extends Composition> c) {
        throw new UnsupportedOperationException("AddAll at index is not supported.");
    }

    /**
     * Removes all the elements in this list that are also contained in the specified collection.
     *
     * @param c The collection containing elements to be removed from this list.
     * @return {@code true} if this list changed as a result of the call.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            while (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param c The collection containing elements to be retained in this list.
     * @return {@code true} if this list changed as a result of the call.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<Composition> iterator = iterator();
        while (iterator.hasNext()) {
            Composition composition = iterator.next();
            if (!c.contains(composition)) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements from this list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list.
     *
     * @param o The element to search for.
     * @return The index of the first occurrence of the element in the list,
     *         or {@code -1} if the list does not contain the element.
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Composition composition : this) {
            if (Objects.equals(composition, o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list.
     * <p>
     * This method is not supported in {@code CompositionList}.
     *
     * @param o The element to search for.
     * @return The index of the last occurrence of the element in the list, or {@code -1}.
     * @throws UnsupportedOperationException Always, because this operation is not implemented.
     */
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("lastIndexOf is not supported.");
    }

    /**
     * Returns a list iterator over the elements in this list.
     * <p>
     * This method is not supported in {@code CompositionList}.
     *
     * @throws UnsupportedOperationException Always, because this operation is not implemented.
     */
    @Override
    public ListIterator<Composition> listIterator() {
        throw new UnsupportedOperationException("listIterator is not supported.");
    }

    /**
     * Returns a list iterator over the elements in this list, starting at the specified position.
     * <p>
     * This method is not supported in {@code CompositionList}.
     *
     * @param index The index of the first element to be returned from the list iterator.
     * @throws UnsupportedOperationException Always, because this operation is not implemented.
     */
    @Override
    public ListIterator<Composition> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator at index is not supported.");
    }

    /**
     * Returns a view of the portion of this list between the specified indices.
     * <p>
     * This method is not supported in {@code CompositionList}.
     *
     * @param fromIndex The starting index (inclusive).
     * @param toIndex   The ending index (exclusive).
     * @throws UnsupportedOperationException Always, because this operation is not implemented.
     */
    @Override
    public List<Composition> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList is not supported.");
    }

    /**
     * Validates that the index is within bounds.
     *
     * @param index The index to validate.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
