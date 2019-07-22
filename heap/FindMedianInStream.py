import MaxHeap
import MinHeap

min_heap = []
max_heap = []

current_median = 0.0

stream = [6, 1, 5, 2, 4, 3, 1, 7, 7, 8]

for value in stream:
    if current_median > value:
        MaxHeap.push_heap(max_heap, value)
    else:
        MinHeap.push_heap(min_heap, value)

    current_median = value

    if len(max_heap)-len(min_heap) > 1:
        max_value = MaxHeap.pop_heap(max_heap)
        MaxHeap.push_heap(min_heap, max_value)
    elif len(min_heap)-len(max_heap) > 1:
        min_value = MinHeap.pop_heap(min_heap)
        MinHeap.push_heap(max_heap, min_value)

    if len(max_heap) == len(min_heap):
        current_median = (max_heap[0]+min_heap[0])/2
    elif len(max_heap) > len(min_heap):
        current_median = max_heap[0]
    else:
        current_median = min_heap[0]
    print(current_median, max_heap, min_heap)
