package package01;

import java.util.ArrayList;
import java.util.List;

/**
 * 01背包
 * 背包类
 */
public class Package {

    private List<TagObject> objects = new ArrayList<TagObject>();

    private int totalWeight;

    public Package(int totalWeight,List<TagObject> objects){
        this.totalWeight = totalWeight;
        this.objects = objects;
    }

    public List<TagObject> getObjects() {
        return objects;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
