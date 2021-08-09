//package Assignment6;


public class LuxuryRoom extends Room {
    private boolean addBed=false;
    public void setAddBed(boolean addBed) {
        this.addBed = addBed;
    }

    @Override
    public void checkIn(int number) {
        this.setCheckIn(true);
        if(number==2){
            setAddBed(false);
        }
        else setAddBed(true);
    }

    @Override
    public void checkOut() {

    }

    @Override
    public String toString() {
        return "L "+super.toString()+this.addBed;
    }
}