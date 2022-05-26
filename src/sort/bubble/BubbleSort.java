package sort.bubble;

import java.util.*;

public class BubbleSort {
    
    private Integer[] data;

    public List<Integer> getResult(){
        solution();
        return Arrays.asList(data);
    }

    public BubbleSort(List<Integer> data) {
        this.data = data.toArray(new Integer[data.size()]);
    }
    
    private void solution(){
        for (int i = 0; i < data.length -1 ; i++) {
            for (int j = 0; j < data.length -i -1; j++) {
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }
}
