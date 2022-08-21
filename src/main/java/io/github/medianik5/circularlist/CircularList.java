package io.github.medianik5.circularlist;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A circular list interface.<p>
 *
 * <h2><a id="motivation">Motivation</a></h2>
 * List has a pivot element, which is the first element in the list,
 * in other words the element that is returned by {@code get(0)}.<br>
 *
 * The order of the elements in the list is defined by the pivot element.<br>
 * The pivot element is always first in the list, in other words, the pivot element is
 * the one that is returned by {@code get(0)}.<br>
 * You can move the pivot element, the move does not change elements in the list, but
 * change the order of this list.<p>
 *
 * Moving pivot element <i>forward</i> can be divided into two stages: before moving and after.<br>
 * If the elements before moving were in the following order: {@code 1, 2, 3, 4, ... n} (i. e. get(0), get(1), ..., get(n - 1)),
 * then after moving forward by one element the elements will be in the following order:
 * {@code 2, 3, 4, 5, ... n, 1}.<p>
 * Moving pivot element <i>backward</i> is the similar to <i>forward</i>.
 * For example:
 * <pre>
 *     CircularList list = getNewCircularList();
 *     list.add(1);
 *     list.add(2);
 *     list.add(3);
 *     System.out.println(list); // prints [1, 2, 3]
 *     list.rotate();
 *     System.out.println(list); // prints [2, 3, 1]
 *     list.rotate();
 *     System.out.println(list); // prints [3, 1, 2]
 *     list.rotateBackward();
 *     System.out.println(list); // prints [2, 3, 1]
 * </pre>
 *
 * <pre>
 *     CircularList list = getNewCircularList();
 *     list.add(1);
 *     list.add(2);
 *     list.add(3);
 *     System.out.println(list); // prints [1, 2, 3]
 * </pre>
 *
 * <h2><a id="immutability">Immutability</a></h2>
 * The point of immutability not to change its state for circular
 * list is senseless, because {@code CircularList} would become simple {@link List},
 * taking that into mind the immutable {@code CircularList} is one that does not
 * change the <i>element circle</i> of this list.<br>
 * The <i>element circle</i> of this list is all the elements of this list,
 * lined up in a circle.<br>
 * Then equality of two element circles is defined as equality of the elements in sequential order
 * of first circle to the elements in sequential order from some element of second circle.<p>
 * For example: [1 2 3] and [3 1 2] are equal circles(but not arrays),
 * but [1 2 3] and [1 3 2] are not equal circles.
 *
 * Two circular lists are considered equal the same way {@link List#equals(Object)} works<p>
 * The circular lists are considered circularly equal if their element circles are equal.<p>
 *
 * Inserting and retrieving elements is the same as in the {@link java.util.List}.
 * @param <E> the type of elements in this list
 */
public interface CircularList<E> extends List<E>{
    /**
     * Returns the first element in this list, in other words the pivot element,
     * the one that was pivot element just before calling this function.<br>
     * Rotates this list forward by one element, making the next element
     * (returned by {@code get(1)} before call of this function) the pivot element.<p>
     *
     * If the list is one element long, this function does not rotate the list.<p>
     *
     * @throws NoSuchElementException If the list is empty.
     * @return the first element in the list
     */
    E getAndRotate() throws NoSuchElementException;

    /**
     * Returns the first element in this list after this function returns, in other words the pivot element,
     * the one that will be pivot element just after this function returns.<br>
     * Rotates this list forward by one element, making the next element
     * (returned by {@code get(1)} before call of this function) the pivot element.<p>
     *
     * If the list is one element long, this function does not rotate the list.<p>
     *
     * @throws NoSuchElementException If the list is empty.
     * @return the first element in the list
     */
    E rotateAndGet() throws NoSuchElementException;


    /**
     * Rotates the list forward by one element, making the second element
     * (returned by {@code get(1)} before call of this function) the pivot element.<p>
     *
     * If the list is one or zero elements long, this function does not rotate the list.<p>
     */
    void rotate();


    /**
     * Returns the first element in this list, in other words the pivot element,
     * the one that was pivot element just before calling this function.<br>
     * Rotates this list backward by one element, making the previous element
     * (returned by {@code get(size()-1)} before call of this function) the pivot element.<p>
     *
     * If the list is one element long, this function does not rotate the list.<p>
     *
     * @throws NoSuchElementException If the list is empty.
     * @return the first element in the list
     */
    E getAndRotateBackward() throws NoSuchElementException;

    /**
     * Returns the first element in this list after this function returns,
     * in other words the pivot element, the one that will be
     * pivot element just after this function returns.<br>
     * Rotates this list backward by one element, making the previous element
     * (returned by {@code get(size()-1)} before call of this function) the pivot element.<p>
     *
     * If the list is one element long, this function does not rotate the list.<p>
     *
     * @throws NoSuchElementException If the list is empty.
     * @return the first element in the list
     */
    E rotateBackwardAndGet() throws NoSuchElementException;


    /**
     * Rotates the list backward by one element, making the last element
     * (returned by {@code get(size()-1)} before call of this function) the pivot element.<p>
     *
     * If the list is one or zero elements long, this function does not rotate the list.<p>
     */
    void rotateBackward();

    /**
     * Resets the order of this list to some original order, that this list holds.<br>
     * If this list is immutable, the pivot element after this function returns is the
     * same as one that was just after creating this list.<p>
     *
     * If this list is mutable, this function might not set the pivot element
     * to the same value it was after creating this list.<p>
     *
     * Repeated calls of this function have no effect.
     */
    void resetOrder();

    /**
     * Compares the specified object with this list for circular equality.
     * Returns {@code true} if the specified object is circular list
     * and its element circle is equal to this list's element circle.
     *
     * Warning: this function in some cases might take a lot of time to execute.
     * @return true if the specified object is circularly equal to this list.
     */
    boolean circularlyEquals(Object object);
}
