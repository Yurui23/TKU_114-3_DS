public class ArrayTraversal {

    public static void main(String[] args) {
        int[][] grades = {
            {85, 90, 78, 88},
            {72, 68, 80, 75},
            {95, 92, 89, 94}
        };

        System.out.println("=== 學生各科成績 ===");
        printGrades(grades);

        double[] studentAverages = calculateStudentAverages(grades);
        double[] subjectAverages = calculateSubjectAverages(grades);

        printSummary(studentAverages, subjectAverages);
    }

    public static void printGrades(int[][] grades) {
        for (int i = 0; i < grades.length; i++) {
            System.out.print("學生 " + (i + 1) + ": ");
            for (int j = 0; j < grades[i].length; j++) {
                System.out.print("科目 " + (j + 1) + ": " + grades[i][j]);
                if (j < grades[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public static double[] calculateStudentAverages(int[][] grades) {
        double[] averages = new double[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int sum = 0;
            for (int j = 0; j < grades[i].length; j++) {
                sum += grades[i][j];
            }
            averages[i] = (double) sum / grades[i].length;
        }
        return averages;
    }

    public static double[] calculateSubjectAverages(int[][] grades) {
        int numStudents = grades.length;
        int numSubjects = grades[0].length;
        double[] averages = new double[numSubjects];
        for (int j = 0; j < numSubjects; j++) {
            int sum = 0;
            for (int i = 0; i < numStudents; i++) {
                sum += grades[i][j];
            }
            averages[j] = (double) sum / numStudents;
        }
        return averages;
    }

    public static void printSummary(double[] studentAverages, double[] subjectAverages) {
        System.out.println("\n=== 成績統計摘要 ===");
        
        System.out.println("[ 個人平均成績 ]");
        for (int i = 0; i < studentAverages.length; i++) {
            System.out.printf("  學生 %d 平均分數: %.2f 分\n", (i + 1), studentAverages[i]);
        }

        System.out.println();

        System.out.println("[ 各科平均成績 ]");
        for (int j = 0; j < subjectAverages.length; j++) {
            System.out.printf("  科目 %d 平均分數: %.2f 分\n", (j + 1), subjectAverages[j]);
        }
    }
}