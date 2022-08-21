# Circular List

Circular list for java.

## Description

Circular list is a data structure that can be used to store a sequence of elements in a circular manner.  
Circular list has a pivot element which is the first element of the list.  
When you rotate the list, i.e. move pivot element, you change the order of list.

For example, if we have a list with elements [1, 2, 3], its pivot element is 1.  
If we move pivot element forward(i.e. rotate list), the list becomes [2, 3, 1].  
If we move pivot element backward(i.e. rotate list backward), the list becomes [3, 1, 2].

Circular list is considered immutable if the elements of the list won't change, but order might be changed.  
The list in the paragraph above is going through immutable operations.

Circular lists might have some original order that the list holds.  
To return to that original order you might use `resetOrder` function.  
Immutable list's original order is the same that was just after the creation of list.