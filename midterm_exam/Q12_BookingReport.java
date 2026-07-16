package midterm_exam;

public class Q12_BookingReport {
    public static void main(String[] args) {
        Q12_Booking[] bookings = {
            new Q12_Booking("B001", "Amy", 2, 750, true),
            new Q12_Booking("B002", "Ben", 4, 600, false),
            new Q12_Booking("B003", "Cara", 3, 900, true),
            new Q12_Booking("B004", "Dan", 1, 1200, true)
        };

        System.out.println("已確認筆數：" + countConfirmed(bookings));
        System.out.println("已確認收入：" + calculateConfirmedRevenue(bookings));

        Q12_Booking found = findById(bookings, "b003");
        System.out.println("搜尋結果：" + found);

        Q12_Booking largest = findLargestConfirmed(bookings);
        System.out.println("最高確認預約：" + largest);
    }

    public static int countConfirmed(Q12_Booking[] bookings) {
        int confirmedCount = 0;
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].isConfirmed()) {
                confirmedCount++;
            }
        }
        return confirmedCount;
    }

    public static double calculateConfirmedRevenue(Q12_Booking[] bookings) {
        double revenue = 0.0;
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].isConfirmed()) {
                revenue += bookings[i].getTotalPrice();
            }
        }
        return revenue;
    }

    public static Q12_Booking findById(Q12_Booking[] bookings, String id) {
        if (id == null) {
            return null;
        }

        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].getId().equalsIgnoreCase(id)) {
                return bookings[i];
            }
        }
        return null;
    }

    public static Q12_Booking findLargestConfirmed(Q12_Booking[] bookings) {
        Q12_Booking highest = null;

        for (int i = 0; i < bookings.length; i++) {
            Q12_Booking bk = bookings[i];
            if (!bk.isConfirmed()) {
                continue;
            }

            if (highest == null || bk.getTotalPrice() > highest.getTotalPrice()) {
                highest = bk;
            }
        }
        return highest;
    }
}