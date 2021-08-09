//package Assignment6;

public class OrdinaryRoom extends Room {
    private int breakfastCount=0;
    public void setBreakfastCount(int breakfastCount){
        this.breakfastCount=breakfastCount;
    }
    public int getBreakfastCount() {
        return breakfastCount;
    }

    @Override
    public void checkIn(int number) {
        setCheckIn(true);
        setBreakfastCount(number);
    }

    @Override
    public void checkOut() {

    }

    @Override
    public String toString() {
        return "O " + super.toString()+" "+this.breakfastCount;
    }
}
