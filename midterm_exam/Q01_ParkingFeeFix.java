package midterm_exam;

public class Q01_ParkingFeeFix {
    public static void main(String[] args) {
        int[] testMinutes = {-20, 30, 31, 60, 61, 120, 121, 420};

        for (int i = 0; i < testMinutes.length; i++) {
            int mins = testMinutes[i];
            int fee = calculateFee(mins);
            System.out.println("停車 " + mins + " 分鐘，費用：" + fee + " 元");
        }
    }

    public static int calculateFee(int minutes) {
        if (minutes < 0) {
            return -1;
        }
        if (minutes <= 30) {
            return 0;
        }

        int finalFee = 0;
        if (minutes <= 120) {
            int rem = minutes - 30;
            int units = (rem + 29) / 30;
            finalFee = units * 20;
        } else {
            int rem = minutes - 120;
            int units = (rem + 59) / 60;
            finalFee = 60 + (units * 30);
        }

        return finalFee > 180 ? 180 : finalFee;
    }
}
