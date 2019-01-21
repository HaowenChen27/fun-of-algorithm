package package01;


import java.util.ArrayList;
import java.util.List;

public class PackageAlgo {

    public static void algo(Package pa,PackageStrategies.PackageStrategy strategy){
        int idx;
        int ntc = 0;
        while ((idx=strategy.apply(pa.getObjects()))!=-1){
            if(ntc+pa.getObjects().get(idx).getWeight()<=pa.getTotalWeight()){
                ntc = ntc + pa.getObjects().get(idx).getWeight();
                pa.getObjects().get(idx).setStatus("1");
            }else{
                pa.getObjects().get(idx).setStatus("2");
            }
        }
        pa.getObjects().stream().forEach(v->{
            if(v.getStatus().equals("1")){
                System.out.println(v);
            }
        });


    }

    public static void main(String[] args) {
        TagObject object1 = new TagObject(35,10);
        TagObject object2 = new TagObject(30,40);
        TagObject object3 = new TagObject(60,30);
        TagObject object4 = new TagObject(50,50);
        TagObject object5 = new TagObject(40,35);
        TagObject object6 = new TagObject(10,40);
        TagObject object7 = new TagObject(25,30);
        List<TagObject> list = new ArrayList<>();
        list.add(object1);
        list.add(object2);
        list.add(object3);
        list.add(object4);
        list.add(object5);
        list.add(object6);
        list.add(object7);
        Package p = new Package(150,list);
        algo(p,PackageStrategies.getThreeStrategy());
    }
}
