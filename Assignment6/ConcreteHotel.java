//package Assignment6;


import java.util.ArrayList;
import java.util.List;

public class ConcreteHotel extends Hotel {
    private Day currentDay=Day.MONDAY;
    private List<Room> rooms = new ArrayList<>();
    private ArrayList<Double> prices=new ArrayList<>();
    private double priceOfLuxuryRoom=1200;
    private double priceOfOrdinaryRoom=500;
    private double priceOfBreakfast=180;
    private double priceOfBed=250;
    private double priceOfYesterday=0;

    @Override
    public void addRoom(int type, int count){
        for (int i = 0; i < count; i++) {
            if(type==0){
                rooms.add(new LuxuryRoom());
            }
            else rooms.add(new OrdinaryRoom());
        }
    }

    @Override
    public void addRoom(Room room){
        rooms.add(room);
    }

    @Override
    public void setPrice(int type, double price){
        if(type==0){
            priceOfLuxuryRoom=price;
        }
        else priceOfOrdinaryRoom=price;
    }

    @Override
    public double getPrice(int type){
        if(type==0){
            return priceOfLuxuryRoom;
        }
        else return priceOfOrdinaryRoom;
    }

    @Override
    public double getRoomPrice(String number){
        Room room=rooms.get(Integer.parseInt(number));
        if(room.getCheckIn()){
            String[]info=room.toString().split(" ");
            if(info[0]=="L"){
                if(info[2]=="true"){
                    return priceOfLuxuryRoom*currentDay.getRate()+priceOfBed;
                }
                else return priceOfLuxuryRoom*currentDay.getRate();
            } else{
                if(info[2]=="2"){
                    return priceOfOrdinaryRoom*currentDay.getRate()+priceOfBreakfast*2;
                }else{
                    if(info[2]=="1"){
                        return priceOfOrdinaryRoom*currentDay.getRate()+priceOfBreakfast;
                    }
                    else return priceOfOrdinaryRoom*currentDay.getRate();
                }
            }
        }else return 0;
    }

    @Override
    public void displayAllRooms(){
        for(Room room:rooms){
            System.out.println(room.toString());
        }
    }

    @Override
    public List<Room> getAllCheckedRooms(){
        List<Room> checkedRoom=new ArrayList<>();
        for(Room room:rooms){
            if(room.getCheckIn()){
                checkedRoom.add(room);
            }
        }
        return checkedRoom;
    }

    @Override
    public void displayEveryDayInfo(){
        System.out.println(Day.MONDAY.toString());
        System.out.println(Day.TUESDAY.toString());
        System.out.println(Day.WEDNESDAY.toString());
        System.out.println(Day.THURSDAY.toString());
        System.out.println(Day.FRIDAY.toString());
        System.out.println(Day.SATURDAY.toString());
        System.out.println(Day.SUNDAY.toString());
    }

    @Override
    public void displayTodayInfo(){
        System.out.println(currentDay.toString());
    }

    @Override
    public void checkIn(int type, int number){
        List<Room> uncheckedRoom=new ArrayList<>();
        for(Room room:rooms){
            if(!room.getCheckIn()){
                uncheckedRoom.add(room);
            }
        }

    }

    @Override
    public void checkOut(String... roomNumber){
        double dayPrice=0;
        for(Room room:rooms){
            dayPrice+=getPrice(Integer.parseInt(room.getNumber()));
        }
        for(String n:roomNumber){
            for(Room room:rooms){
                if(room.getNumber()==n){
                    room.setCheckIn(false);
                }
            }
        }
        priceOfYesterday=dayPrice;
        prices.add(dayPrice);
        changeDay();
    }

    @Override
    public double income(){
        return priceOfYesterday;
    }

    @Override
    public double income(int recentTimes){
        double income=0;
        for (int i = 0; i < recentTimes; i++) {
            income+=prices.get(prices.size()-recentTimes+i);
        }
        return income;
    }

    public void changeDay(){
        switch (currentDay){
            case MONDAY:
                currentDay=Day.TUESDAY;
                break;
            case TUESDAY:
                currentDay=Day.WEDNESDAY;
                break;
            case WEDNESDAY:
                currentDay=Day.THURSDAY;
                break;
            case THURSDAY:
                currentDay=Day.FRIDAY;
                break;
            case FRIDAY:
                currentDay=Day.SATURDAY;
                break;
            case SATURDAY:
                currentDay=Day.SUNDAY;
                break;
            case SUNDAY:
                currentDay=Day.MONDAY;
                break;
        }
    }
}
