package dataStructure.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private List<Object> data = new ArrayList<>();

    public Object deQueue() {
        if (data.size() == 0) {
            return null;
        } else {
            Object result = data.get(0);
            data.remove(0);
            return result;
        }
    }

    public boolean inQueue(Object o){
        return data.add(o);
    }
}
