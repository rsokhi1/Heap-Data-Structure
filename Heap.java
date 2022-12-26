// Arr[(i-1)/2] Returns the parent node.
// Arr[(2*i)+1] Returns the left child node.
// Arr[(2*i)+2] Returns the right child node.
public class Heap {
    private int[] heap;
    private int size;
    private int maxSize;

    public Heap(int maxSize){
        this.maxSize = (int) Math.pow(2,maxSize);
        this.size = 0;
        heap = new int[this.maxSize];
    }

    private int parent(int pos){
        return (pos - 1) / 2;
    }

    private int leftChild(int pos){
        return (2 * pos) + 1;
    }

    private int rightChild(int pos){
        return (2 * pos) + 2;
    }

    private void swap(int left,int right){
        int temp;
        temp = heap[right];
        heap[right] = heap[left];
        heap[left] = temp;
    }

    private boolean isLeaf(int pos){
        Boolean flag = false;
        if(pos > (size /2) && pos <= size){
            flag = true;
        }
        return flag;
    }

    private void maxHeapify(int pos){
        if(isLeaf(pos)) {
            return;
        }
        if(heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]){
            if(heap[rightChild(pos)] < heap[leftChild(pos)]){
                swap(pos,leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else{
                swap(pos,rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }



    }

    public void print(){
        for(int i = 0;i <size/2;i++){
            System.out.println("Parent Node: " + heap[i]);
            if(leftChild(i) < size){
                System.out.print("Left Node: " + heap[leftChild(i)]);
            }
            if(rightChild(i) < size){
                System.out.print(" Right Node: " + heap[rightChild(i)]);
            }
            System.out.println();
        }
    }

    public void insert(int val){
        heap[size] = val;

        int current = size;
        while(heap[current] > heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
        size++;
    }

    public int pop_max(){
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }
}
