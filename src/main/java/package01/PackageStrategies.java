package package01;

import java.math.BigDecimal;
import java.util.List;

public class PackageStrategies {

    public interface PackageStrategy {
        int apply(List<TagObject> objects);
    }

    /**
     * 价值高的优先
     * @return
     */
    public static PackageStrategy getOneStrategy(){
        return (objects)->{
            int index = -1;
            int maxPrice = 0;
            for(int i=0;i<objects.size();i++){
                if(objects.get(i).getStatus().equals("0")&&objects.get(i).getPrice()>maxPrice){
                    maxPrice = objects.get(i).getPrice();
                    index = i;
                }
            }
            return index;
        };
    }

    /**
     * 重量轻的优先
     * @return
     */
    public static PackageStrategy getTwoStrategy(){
        return (objects)->{
          int index = -1;
          int minWeight = 100;
          for(int i= 0;i<objects.size();i++){
              if(objects.get(i).getStatus().equals("0")&&objects.get(i).getWeight()<minWeight){
                    minWeight = objects.get(i).getWeight();
                    index = i;
              }
          }
          return index;
        };
    }

    /**
     * 价值密度优先
     * @return
     */
    public static PackageStrategy getThreeStrategy(){
        return objects -> {
            int index = -1;
            BigDecimal p = new BigDecimal(0);
            for(int i= 0;i<objects.size();i++){
                if(objects.get(i).getStatus().equals("0")){
                    BigDecimal pp = new BigDecimal(objects.get(i).getPrice()).divide(new BigDecimal(objects.get(i).getWeight()),4,BigDecimal.ROUND_HALF_EVEN);
                    System.out.println(objects.get(i).getWeight()+"----"+pp);
                    if(pp.compareTo(p)>0){
                        p = pp;
                        index = i;
                    }
                }
            }
            return index;
        };
    }
}
