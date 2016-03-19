import java.util.Objects;
import java.util.Scanner;

/**
 * Created by chungonion on 16/2/2016.
 */
public class BitStuffing {
    private String bits;
    private String output;


    public BitStuffing() {
        bits = "";
        output = "";
    }

    public void execute() {
        System.out.print("Please enter the unstuffed bits: ");
        Scanner scanner = new Scanner(System.in);
        bits = scanner.next();
        try {
            Stuff();
            display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void Stuff() throws Exception {
        if (!bits.contains("0") || !bits.contains("1")) {
            if (!((bits.equals("0")) || (bits.equals("1")))) {
                throw new Exception("Illegal input! Programme now terminates!");
            }
        }
        String[] bitssplit = bits.split("11111", -1);
        int count = 0;
        //System.out.println(bitssplit.length);
        count = bitssplit.length;
        if (count == 1) {
            output = bitssplit[0];
        } else {
            for (int i = 0; i <= bitssplit.length - 2; i++) {
                output = output + bitssplit[i] + "111110";
            }
            if (Objects.equals(bitssplit[bitssplit.length - 1], "")) {
                output = output + "111110";
            } else {
                output = output + bitssplit[bitssplit.length - 1];
            }

        }

    }

    public void display() throws Exception {
        if (Objects.equals(output, "")) {
            throw new Exception("No output is found!");
        }
        System.out.print("Stuffed bits: ");
        System.out.println(output);
    }

}
