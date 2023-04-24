package HouseRentServe;

public class HouseRentApp {  //房屋接口
    public static void main(String[] args) {
        //普通实例化对象进行创建HouseView的houseView对象
        HouseView houseView =new HouseView();
        houseView.HouseMenu();

        //使用单例模式进行----懒汉式
        //HouseView.getInstance().HouseMenu();


        //使用单例模式进行-------饿汉式
        //HouseView.getInstance().HouseMenu();
    }
}
