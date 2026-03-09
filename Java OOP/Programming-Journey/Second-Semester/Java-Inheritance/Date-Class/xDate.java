import java.util.Date;
public class xDate extends Date {
    private int year, month, day;


public xDate(int day,int month,int year){
    super(year-1900,month-1,day);
    this.year=year;
    this.month=month;
    this.day=day;
}



public int getMonth(){
    return super.getMonth()+1;
}



public int getYear(){
    return super.getYear()+1900;
}



public xDate addDays(int days) {

    int nDay=this.day+days;
    int mon=this.month;

    while (nDay>28){
            if(mon == 2 && nDay > 28) {
            mon=3;
            nDay-=28;
        }
        
        if(mon == 4 || mon == 6 ||mon == 9 || mon == 11){
            if (nDay > 30) {
                mon++;
                nDay-=29;
            }
        }
        if(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10){
            if (nDay > 31) {
                mon++;
                nDay-=31;
            }
        }
        if(mon==12){
            if(nDay>31){
                year++;
                mon=1;
            }
        }
    }
        return new xDate(nDay, mon, year);
    }


public static xDate now() {
    return new xDate(new Date().getDate(), new Date().getMonth() + 1, new Date().getYear() + 1900);
}
public void show(){
    System.out.println(day+","+month+","+year);
}
public static void main(String[] args) {
    xDate d=new xDate(10,1 , 2010);
    System.out.println(now());
}
}
