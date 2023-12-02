package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int size(){
        return this.bridge.size();
    }

    public String get(int index){
        return this.bridge.get(index);
    }
}
