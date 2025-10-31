public class TaskSolution {
        public static void main(String[] args) {
            int numberOfPLCs = 1100;
            int numberOfEmployees = 1100;
            boolean[] plcStatus = new boolean[numberOfPLCs + 1];

            interactWithPLCs(plcStatus, numberOfEmployees, numberOfPLCs);

            int plcOnCount = countPlcsInRunMode(plcStatus);
            System.out.println("PLCs left in RUN mode are: " + plcOnCount);
        }

        // An employee i, toggles every i-th PLC
        public static void interactWithPLCs(boolean[] plcStatus, int numberOfEmployees, int numberOfPLCs) {
            for (int i = 1; i <= numberOfEmployees; i++) {
                for (int j = i; j <= numberOfPLCs; j += i) {
                    plcStatus[j] = !plcStatus[j];
                }
            }
        }

        public static int countPlcsInRunMode(boolean[] plcStatus) {
            int count = 0;
            for (int i = 1; i < plcStatus.length; i++) {
                if (plcStatus[i]) {
                    count++;
                }
            }
            return count;
        }
    }

