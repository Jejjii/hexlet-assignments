package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    private List<Integer> list = new ArrayList<>();
    private Object lock = new Object();

    public SafetyList(ArrayList<Integer> list) {
        this.list = list;
    }

    public SafetyList(){
        this.list = new ArrayList<>();
    }
    // BEGIN
    public synchronized void add(int element) {
        list.add(element);
    }

    public int get(int index) {
        return list.get(index);
    }

    public int getSize() {
        return list.size();
    }

    // END
}
