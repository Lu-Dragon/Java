package HouseRentServe;

import Untility.Utility;

import java.util.Scanner;
/**
 * 完成对House对象数组的增,删,改,查,输出
 */
public class HouseService {   //房屋服务
    Scanner scanner =new Scanner(System.in);

    private House[] houses;
    House house[]=new House[10];
    static int id=-1;  //记录House对象数组的位置

    //添加House对象
    public void add(){
        house[++id]=new House();
        System.out.print("房屋编号:");
        house[id].setHouse_id(Utility.readString(3));
        System.out.print("姓名:");
        house[id].setHouseOwner(Utility.readString(4));
        System.out.print("电话:");
        house[id].setOwnerTelphone(Utility.readString(3));
        System.out.print("地址:");
        house[id].setHouseAddress(scanner.next());
        System.out.print("月租:");
        house[id].setMonthlyRent(scanner.nextDouble());
        System.out.print("状态(未出租/已出租):");
        house[id].setHouseStatus(Utility.readString(3));
    }

    //删除House对象
    public void delte(String house_id){
        int temp=0;
        while (!house_id.equals(house[temp].getHouse_id())) temp++;
        for (int i = temp; i < house.length-1; i++) {
            house[i]=house[i+1];
        }
        id-=1;
    }

    //查找House对象
    public int find(String house_id){
        int i=id;
        while (!house_id.equals(house[i].getHouse_id())){
            i-=1;
            if (i==-1) break;

        }
        return i;
    }

    //修改房屋信息
    public void update(String house_id){
        int temp_id=find(house_id);
        if (temp_id>=0){
            System.out.print("房屋编号:");
            house[temp_id].setHouse_id(scanner.next());
            System.out.print("姓名:");
            house[temp_id].setHouseOwner(scanner.next());
            System.out.print("电话:");
            house[temp_id].setOwnerTelphone(scanner.next());
            System.out.print("地址:");
            house[temp_id].setHouseAddress(scanner.next());
            System.out.print("月租:");
            house[temp_id].setMonthlyRent(scanner.nextDouble());
            System.out.print("状态(未出租/已出租):");
            house[temp_id].setHouseStatus(scanner.next());
        }else {
            System.out.println("没有该房屋信息,请检查房屋编号house_id是否输入正确");
        }
    }

    //输出House对象信息
    public void OutPut(){
        if (id<0){
            System.out.println("没有房屋信息");
        }
        for (int i = 0; i <= id; i++) {
            System.out.println(house[i].GetHouseInfo());
        }
    }
}