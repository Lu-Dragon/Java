package SmallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 化繁为简
 * 1、先完成显示菜单，并且可以选择
 * 2、逐步完成菜单的各个子功能
 * 3、将子功能添加到菜单中去
 * 4、完善、优化各个子功能
 * 5、每完成一个子功能都进行相关测试
 */

public class SmallChangeSys {
    static Scanner input = new Scanner(System.in);
    static String arry = "";
    static double balance = 0;

    public static void main(String[] args) {
        menu();
    }

    //编写显示菜单
    public static void menu() {
        boolean loop = true;
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
                    details();
                    break;
                case 2:
                    RevenueRntry();
                    break;
                case 3:
                    consumsption();
                    break;
                case 4:
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
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("输入有误,请重新输入");
            }
        } while (loop);
        System.out.println("--------------------------退出了零钱通项目----------------------------");
    }

    //编写零钱通明细
    public static void details() {
        System.out.println(arry);
    }

    //收益入账
    public static void RevenueRntry() {
        double money = 0;
        Date date = new Date();  //获取当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于格式化日期
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
    public static void consumsption() {
        double money = 0;
        Date date = new Date();  //获取当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于格式化日期
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
}