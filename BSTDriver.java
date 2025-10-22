package cs2720.p3;

public class BSTDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        String type = "";
        char command = input.next().charAt(0);
        DoublyLinkedList list = null;
        try (Scanner s = new Scanner(new File(args[0]))) {
            switch (command) {
            case 'i': {
                list = new DoublyLinkedList<Integer>();
                type = "number";
                while (s.hasNext()) {
                    list.insertItem(Integer.valueOf(s.next()));
                }
                break;
            }
            case 'd': {
                list = new DoublyLinkedList<Double>();
                type = "double";
                while (s.hasNext()) {
                    list.insertItem(Double.valueOf(s.next()));
                }
                break;
            }
            case 's': {
                list = new DoublyLinkedList<String>();
                type = "string";
                while (s.hasNext()) {
                    list.insertItem(s.next());
                }
                break;
            }
            default:
                System.out.println("Invalid type entered!");
                break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        if (list == null) {
            System.out.println("No list available. Exiting.");
            input.close();
            return;
        }
        while (command != 'q') {
            if (!promptAlreadyPrinted) {
                System.out.print("Enter a command: ");
            }
            promptAlreadyPrinted = false; // reset the flag for this iteration
            command = input.next().charAt(0);
            while (command != 'q' && command != 'i' && command != 'd' && command != 'p'
                    && command != 'l' && command != 't' && command != 'r'
                    && command != 's' && command != 'b') {
                System.out.print("Invalid command try again: ");
                command = input.next().charAt(0);
            }
            commands(command, input, list, type);
        }
        input.close();
    }

    /**
     * Execute the command specified by 'command' on the given list, using input as
     * needed.
     * 
     * @param command
     * @param input
     * @param list
     * @param type
     */
    public static void commands(char command, Scanner input, DoublyLinkedList list, String type) {
        switch (command) {
        case 'q':
            System.out.println("Exiting the program...");
            break;
        case 'i':
            iCalled(input, list, type);
            break;
        case 'd':
            dCalled(input, list, type);
            break;
        case 'p':
            pCalled(input, list, type);
            break;
        case 'l':
            lCalled(input, list, type);
            break;
        case 't':
            tCalled(input, list, type);
            break;
        case 'r':
            rCalled(input, list, type);
            break;
        case 'b':
            bCalled(input, list, type);
            break;
        case 's':
            sCalled(input, list, type);
            break;
        default:
            break;
        }
    }
    }
}