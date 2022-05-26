package dataStructure.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap_array;

    public Heap(Integer root) {
        heap_array = new ArrayList<Integer>();
        heap_array.add(null);
        heap_array.add(root);
    }

    public boolean insert(Integer num) {
        if (heap_array.size() == 0) {
            heap_array.add(null);
            heap_array.add(num);
            return true;
        }

        heap_array.add(num);

        int insert_idx = heap_array.size() - 1;

        while (moveUp(insert_idx)) {
            int parent_idx = insert_idx / 2;
            swap(parent_idx, insert_idx);
            insert_idx = parent_idx;
        }
        return true;
    }

    public Integer pop(){
        if(heap_array.size() < 1){
            return null;
        }

        Integer result = heap_array.get(1);
        Integer lastData = heap_array.get(heap_array.size() - 1);
        heap_array.set(1, lastData);
        heap_array.remove(heap_array.size() -1 );

        int idx = 1;
        while (moveDown(idx)){
            int left_child_idx = idx * 2;
            int right_child_idx = idx * 2 + 1;

                // 2. 왼쪽 자식 노드만 있을 경우
            if(heap_array.size() <= right_child_idx){
                if(heap_array.get(idx) < heap_array.get(left_child_idx)){
                    swap(idx,left_child_idx);
                    idx = left_child_idx;
                }
            }
            // 3. 자식 노드가 모두 존재 할 경우
            else{
                if(heap_array.get(left_child_idx) > heap_array.get(right_child_idx)){
                    if(heap_array.get(idx) < heap_array.get(left_child_idx)){
                        swap(idx, left_child_idx);
                        idx = left_child_idx;
                    }
                }else{
                    if(heap_array.get(idx) < heap_array.get(right_child_idx)){
                        swap(idx,right_child_idx);
                        idx = right_child_idx;
                    }
                }
            }
        }
        return result;
    }

    private boolean moveDown(int idx){

        int left_child_idx = idx * 2;
        int right_child_idx = (idx * 2 )+ 1;

        // 1. 왼쪽 자식 노드가 없을 경우
        if(left_child_idx >= heap_array.size()){
            return false;
        // 2. 왼쪽 자식 노드만 있을 경우
        }else if(heap_array.size() <= right_child_idx){
            if(heap_array.get(idx) > heap_array.get(left_child_idx)){
                return false;
            }else{
                return true;
            }
        }
        // 3. 자식 노드가 모두 존재 할 경우
        else{
            if(heap_array.get(left_child_idx) > heap_array.get(right_child_idx)){
                if(heap_array.get(idx)> heap_array.get(left_child_idx)){
                    return false;
                }else{
                    return true;
                }
            }else{
                if(heap_array.get(idx)> heap_array.get(right_child_idx)){
                    return false;
                }else{
                    return true;
                }
            }
        }
    }

    private void swap(int parent_idx, int insert_idx) {
        Integer parentValue = heap_array.get(parent_idx);
        Integer insertValue = heap_array.get(insert_idx);
        heap_array.set(parent_idx, insertValue);
        heap_array.set(insert_idx, parentValue);
    }

    private boolean moveUp(int insert_idx) {
        if (insert_idx <= 1) {
            return false;
        }

        Integer insertValue = heap_array.get(insert_idx);
        Integer parentValue = heap_array.get(insert_idx / 2);

        if (insertValue > parentValue) {
            return true;
        }
        return false;
    }

    public void printData(){
        for (Integer value  : heap_array) {
            System.out.println("value = " + value);
        }
    }
}
