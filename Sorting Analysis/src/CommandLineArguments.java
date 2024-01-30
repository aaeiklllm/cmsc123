
public class CommandLineArguments {

    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        System.out.println("Using the enhanced for loop");
        for(String s : args) {
            System.out.println(s);
        }
    }

}
