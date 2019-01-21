package package01;

/**
 * 01背包问题
 * 定义物品类
 */
public class TagObject {

    //重量
    private int weight;
    //价值
    private int price;
    //状态 0-可选 1-已选 2-不可选
    private String status;

    public TagObject(int weight,int price){
        this.weight = weight;
        this.price = price;
        this.status = "0";
    }

    public int getWeight() {
        return weight;
    }


    public int getPrice() {
        return price;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TagObject{" +
                "weight=" + weight +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}