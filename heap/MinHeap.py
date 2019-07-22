# pow(2, h+1)-1 is size of the tree
# log n is the height of the tree.

# o(n log n) time and space complexity.


def heapify(arr):
    n = len(arr)

    # indices floor(n/2+1) -> n are leave nodes
    # in any complete/almost complete binary tree.
    # iterate through all parents from last parent to first.
    for index in range(n/2, -1, -1):
        shiftDown(arr, index)
    return


def shiftDown(arr, index):
    left = 2*index+1
    smallest = index
    if left < len(arr) and arr[left] < arr[index]:
        smallest = left

    if left+1 < len(arr) and arr[left+1] < arr[left]:
        smallest = left+1

    if smallest != index:
        swap(arr, smallest, index)
        shiftDown(arr, smallest)
    return


def swap(arr, frm, to):
    arr[frm], arr[to] = arr[to], arr[frm]
    return


def push_heap(arr, value):
    # insert in the last to retain complete tree property.
    arr.append(value)
    shiftUp(arr, len(arr)-1)
    return


def shiftUp(arr, index):
    parent = (index-1)/2
    if(arr[parent] > arr[index]):
        swap(arr, parent, index)
    if(parent <= 0):
        return
    shiftUp(arr, parent)

# can pop only root element
# runs in o(logn) time


def pop_heap(arr):
    last = len(arr)-1
    swap(arr, 0, last)
    max = arr.pop(last)
    shiftDown(arr, 0)
    return max


def replace_key(arr, index, newVal):
    cvalue = arr.pop(index)
    arr[index] = newVal

    if(newVal > cvalue):
        shiftUp(arr, index)
    else:
        shiftDown(arr, index)
    return


# a = [1, 2, 3, 4, 5]
# heapify(a)
# print(a)
# push_heap(a, 100)
# print(a)
# print(pop_heap(a))
# print(a)
# print(pop_heap(a))
# replace_key(a, 2, 6)
# print(a)
