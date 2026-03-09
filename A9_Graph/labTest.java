

//Uses concepts from Graph + Heap
int difference_Sum(Edge[] adjList, int N) {

    MaxHeap maxH = new MaxHeap(N);
    MinHeap minH = new MinHeap(N);

    for (int i = 0; i < adjList.length; i++) {
        Edge curr = adjList[i];
        while (curr != null) {
            maxH.insert(curr.weight);
            minH.insert(curr.weight);
            curr = curr.next;
        }
    }

    int sumLargest = 0;
    int sumSmallest = 0;

    for (int i = 0; i < N; i++) {
        sumLargest += maxH.extract();
        sumSmallest += minH.extract();
    }


    return sumLargest - sumSmallest;
}








