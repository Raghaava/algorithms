import MaxHeap


min_heap = []
max_heap = []

current_median = 0.0

stream = [1, 2, 3, 4, 5]

for value in stream:
    if current_median < value:
        MaxHeap.push_heap(max_heap, value)
    else:
        MaxHeap.push_heap(min_heap, value)

    if len(min_heap)-len(max_heap) > 1:
        min_value = MaxHeap.pop_heap(min_heap)
        MaxHeap.push_heap(max_heap, min_value)
        current_median = min_heap[0]
    elif len(max_heap)-len(min_heap) > 1:
        max_value = MaxHeap.pop_heap(max_heap)
        MaxHeap.push_heap(min_heap, max_value)
        current_median = max_heap[0]
    elif len(max_heap) == 1 and
    current_median = (max_heap[0]+min_heap[0])/2
    print(current_median)
