package SmallChangeSys.OOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP(面向对象编程)
 *
 * 写项目的思路，先完成整体框架，再完善局部细节，由大到小
 *
 * 将各个功能封装成一个方法
 *
 */
public class SmallChangeSysOOP {

    //相关属性
    static Scanner input = new Scanner(System.in);  //实例化Scanner自定义输出
    static String arry = "";  //接收收入记录与消费记录
    static double balance = 0;  //金额总账

    static boolean loop = true;  //用于menu()的switch执行语句退出判断

    static Date date = new Date();  //获取当前日期
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于格式化日期

    //显示主菜单
    public void menu() {

        do {
            System.out.println("\n============================零钱通菜单=========================");
            System.out.println("\t\t\t1. 零钱通明细");
            System.out.println("\t\t\t2. 收益入账");
            System.out.println("\t\t\t3. 消费");
            System.out.println("\t\t\t4. 退出");
            System.out.print("请输入选项(1-4):");
            int action = input.nextInt();

            //使用switch进行分支执行
            switch (action) {
                case 1:
                    this.details();
                    break;
                case 2:
                    this.RevenueRntry();
                    break;
                case 3:
                    this.consumsption();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误,请重新输入");
            }
        } while (loop);
        System.out.println("--------------------------退出了零钱通项目----------------------------");
    }

    //编写零钱通明细
    public void details() {
        System.out.println(arry);
    }

    //收益入账
    public void RevenueRntry() {
        double money = 0;
        System.out.print("收益入账金额:");
        money = input.nextDouble();
        //money值进行校验
        if (money <= 0) {
            System.out.println("请输入正确的金额(money>0)");
            return;  // 退出方法不在执行后面的代码
        }
        balance += money;
        //拼接收益入账信息到details()
        String detail = "";
        detail = "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance + "\n";
        arry += detail;

    }

    //消费
    public void consumsption() {
        double money = 0;
        System.out.print("支出金额:");
        money = input.nextDouble();
        //money值进行校验
        if (money <= 0) {
            System.out.println("请输入正确的金额(money>0)");
            return;
        }
        balance -= money;
        //拼接收益入账信息到details()
        String detail = "";
        detail = "\n支出  \t-" + money + "\t" + sdf.format(date) + "\t" + balance + "\n";
        arry += detail;
    }

    //退出主菜单
    public void exit(){
        System.out.print("确认退出(y/n):");
        String temp = "";
        while (true) {
            temp = input.next();
            if ("y".equals(temp) || "n".equals(temp)) {
                break;
            }
            System.out.print("请输入正确选项(y/n):");
        }
        if ("y".equals(temp)) {
            loop=false;
        }
    }
}
