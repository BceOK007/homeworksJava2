package Java2;

public enum DayOfWeek {
    Monday(8),
    Tuesday(8),
    Wednesday(8),
    Thursday(8),
    Friday(8),
    Saturday(0),
    Sunday(0);

    private int hour;

    DayOfWeek(int hour) {
        this.hour = hour;
    }

    public int getHour(){
        return this.hour;
    }
}
