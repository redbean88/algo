package sort.insertion;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {

    private Integer[] data;

    public InsertionSort(List<Integer> data) {
        this.data = data.toArray(new Integer[data.size()]);
    }

    public List<Integer> getResult(){
        solution();
        return Arrays.asList(data);
    }

    private void solution(){
        for (int i = 1; i < data.length -1 ; i++) {
            for (int j = i+1 ; j > 1; j--) {
                if(data[j] < data[j-1]){
                    int temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                }else {
                    break;
                }
            }
        }
    }

}
