package midterm_exam;

public class Q10_RecordParser {
    public static void main(String[] args) {
        String[] records = {
            "A101|Keyboard|3|850",
            "A102|Mouse|-1|500",
            "broken data",
            "A103|Monitor|2|4200",
            "A104||1|300"
        };

        for (int i = 0; i < records.length; i++) {
            System.out.println(records[i] + " -> " + calculateRecordTotal(records[i]));
        }

        System.out.println("合法筆數：" + countValidRecords(records));
        System.out.println("總金額：" + calculateGrandTotal(records));
    }

    public static boolean isValidRecord(String record) {
        if (record == null) {
            return false;
        }

        String[] tokens = record.split("\\|", -1);
        if (tokens.length != 4) {
            return false;
        }

        String code = tokens[0].trim();
        String name = tokens[1].trim();

        if (code.isEmpty() || name.isEmpty()) {
            return false;
        }

        try {
            int qty = Integer.parseInt(tokens[2].trim());
            int price = Integer.parseInt(tokens[3].trim());
            return qty > 0 && price >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int calculateRecordTotal(String record) {
        if (!isValidRecord(record)) {
            return -1;
        }

        String[] tokens = record.split("\\|", -1);
        int qty = Integer.parseInt(tokens[2].trim());
        int price = Integer.parseInt(tokens[3].trim());
        return qty * price;
    }

    public static int countValidRecords(String[] records) {
        int count = 0;
        for (int i = 0; i < records.length; i++) {
            if (isValidRecord(records[i])) {
                count++;
            }
        }
        return count;
    }

    public static int calculateGrandTotal(String[] records) {
        int grandTotal = 0;
        for (int i = 0; i < records.length; i++) {
            int rowTotal = calculateRecordTotal(records[i]);
            if (rowTotal >= 0) {
                grandTotal += rowTotal;
            }
        }
        return grandTotal;
    }
}