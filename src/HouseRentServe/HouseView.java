package HouseRentServe;
import java.util.Scanner;

public class HouseView {  //房屋界面

    //因为在HouseRentApp中我们只需要用到一个HouseView对象，则可以采用单例模式
    /**单列模式------懒汉式
    private static HouseView houseView;//创建静态类属性
    public static HouseView getInstance(){ //返回静态对象
        if (houseView==null){
            houseView=new HouseView();
        }
        return houseView;
    }
    private HouseView(){}  //私有化无参构造
    */

    /**单例模式----饿汉式
    private static HouseView houseView=new HouseView(); //创建静态对象

    public static HouseView getInstance(){ //返回静态对象
        return houseView;
    }
    private HouseView(){}  //私有化无参构造
     */

    HouseService houseService=new HouseService();
    boolean loop=true;
    Scanner input=new Scanner(System.in);
    public void HouseMenu(){
        do {
            System.out.println("\n======================================== 房 屋 出 租 系 统 ========================================");
            System.out.println("                           \t\t\t\t1 新 增 房 源\t");
            System.out.println("                           \t\t\t\t2 查 找 房 屋\t");
            System.out.println("                           \t\t\t\t3 删 除 房 屋\t");
            System.out.println("                           \t\t\t\t4 修 改 房 屋 信 息\t");
            System.out.println("                           \t\t\t\t5 房 屋 列 表\t");
            System.out.println("                           \t\t\t\t6 退 出\t");
            System.out.print("请输入功能选项:");
            int action=input.nextInt();
            switch (action){
                case 1:
                    this.AddHouse();
                    break;
                case 2:
                    this.FindHouse();
                    break;
                case 3:
                    this.DeleteHouse();
                    break;
                case 4:
                    this.UpdateHouse();
                    break;
                case 5:
                    this.ListHouses();
                    break;
                case 6:
                    this.QuitHouseService();
                    break;
                default:
                    System.out.println("输入错误,请输入正确选项(1-6):");
            }
        }while (loop);
        System.out.println("\n========================================== 退 出 程 序============================================");
    }

    //新增房源
    public void AddHouse(){
        System.out.println("\n------------------------------------------ 添 加 房 屋 -------------------------------------------");
        houseService.add();
        System.out.println("\n------------------------------------------ 添 加 完 成 -------------------------------------------");
    }

    //查找房屋
    public void FindHouse(){

        System.out.println("\n------------------------------------------ 查 找 房 屋 -------------------------------------------");
        System.out.print("请输入要查找房屋编号House_Id=");
        String House_id=input.next();
        if (houseService.find(House_id)>=0){
            houseService.OutPut();
        }else {
            System.out.println("系统中没有该房屋");
        }
        System.out.println("\n----------------------------------------- 查 找 完 成 --------------------------------------------");
    }

    //修改房屋
    public void UpdateHouse(){
        System.out.println("\n----------------------------------------- 修 改 房 屋 --------------------------------------------");
        System.out.print("输入修改房屋编号house_id:");
        String house_id=input.next();
        houseService.update(house_id);
        System.out.println("\n----------------------------------------- 修 改 完 成 --------------------------------------------");
    }

    //删除房屋
    public void DeleteHouse(){
        System.out.println("\n----------------------------------------- 删 除 房 屋 --------------------------------------------");
        System.out.print("输入删除房屋编号house_id:");
        String house_id=input.next();
        System.out.print("确认删除(y/n):");
        String tem="";
        while (true){
            tem=input.next();
            if ("y".equals(tem)||"n".equals(tem)){
                break;
            }
            System.out.print("请输入正确选项(y/n):");
        }
        if ("y".equals(tem)){
            houseService.delte(house_id);
        }
        System.out.println("\n----------------------------------------- 删 除 完 成 --------------------------------------------");
    }

    //输出房屋信息
    public void ListHouses(){
        System.out.println("\n----------------------------------------- 房 屋 列 表 --------------------------------------------");
        System.out.println("编号\t\t\t房主\t\t\t电话\t\t\t地址\t\t\t月租\t\t\t状态(已出租/未出租)");
        houseService.OutPut();
        System.out.println("\n----------------------------------------- 房屋列表完成 --------------------------------------------");
    }


    //退出房屋出租界面
    public void QuitHouseService(){
        System.out.print("确认退出(y/n):");
        String temp="";
        while (true){
            temp=input.next();
            if ("y".equals(temp)||"n".equals(temp)){
                break;
            }
            System.out.print("请输入正确选项(y/n):");
        }
        if ("y".equals(temp)){
            loop=false;
        }
    }
}