package HouseRentServe;

public class House {   //房屋类
    private String House_id;  //房屋编号
    private String HouseOwner;  //房主
    private String OwnerTelphone; //电话
    private String HouseAddress;  //房屋地址
    private double MonthlyRent;   //月租
    private String HouseStatus;   //状态(未出租/已出租)

    public House(){  //house无参构造
    }

    public House(String house_id, String houseOwner, String ownerTelphone, String houseAddress, double monthlyRent, String houseStatus) {
        House_id = house_id;
        HouseOwner = houseOwner;
        OwnerTelphone = ownerTelphone;
        HouseAddress = houseAddress;
        MonthlyRent = monthlyRent;
        HouseStatus = houseStatus;
    }

    public String getHouse_id() {
        return House_id;
    }

    public void setHouse_id(String house_id) {
        House_id = house_id;
    }

    public String getHouseOwner() {
        return HouseOwner;
    }

    public void setHouseOwner(String houseOwner) {
        HouseOwner = houseOwner;
    }

    public String getOwnerTelphone() {
        return OwnerTelphone;
    }

    public void setOwnerTelphone(String ownerTelphone) {
        OwnerTelphone = ownerTelphone;
    }

    public String getHouseAddress() {
        return HouseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        HouseAddress = houseAddress;
    }

    public double getMonthlyRent() {
        return MonthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        MonthlyRent = monthlyRent;
    }

    public String getHouseStatus() {
        return HouseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        HouseStatus = houseStatus;
    }
    public String GetHouseInfo(){
        return this.House_id+
                "\t\t\t"+this.HouseOwner+
                "\t\t"+this.OwnerTelphone+
                "\t\t\t"+this.HouseAddress+
                "\t\t"+ this.MonthlyRent +
                "\t\t"+this.HouseStatus;
    }
}