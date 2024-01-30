public class InfixToPostfix {
    private String infix;

    static int priority(char c){
        if (c == '+' || c == '-') {
            return 1;
        }
        else if (c == '*' || c == '/' || c == '%') {
            return 2;
        }
        else if (c == '^') {
            return 3;
        }

        return -1;
    }

    public String convertToPostFix() {
        StringBuilder postfix = new StringBuilder(new String("")); //string
        ArrayStack arrStack = new ArrayStack(); //stack
        infix = infix.replaceAll("\\s+","");

        for (int i = 0; i < infix.length(); ++i) {
            char character = infix.charAt(i);
            char nextCharacter = ' ';

            if (i < infix.length()-1) {
                nextCharacter = infix.charAt(i + 1);
            }

            if (Character.isLetterOrDigit(character)) {
                if (nextCharacter == '+' || nextCharacter == '-' || nextCharacter == '*' || nextCharacter == '/'  || nextCharacter == '%' || nextCharacter == '^' || nextCharacter == '(' || nextCharacter == ')'){ //If the next character is an operand
                    postfix.append(character).append(" ");
                }

                else if (i == infix.length() - 1){ //If the character is the last element of the string
                    postfix.append(character).append(" ");
                }

                else {
                    postfix.append(character);
                }
            }

            else if (character == '(') {
                arrStack.push(character);
            }

            else if (character == ')') {
                while (!arrStack.isEmpty() && !arrStack.top().equals('(')) {
                    postfix.append(arrStack.top()).append(" ");
                    arrStack.pop();
                }
                arrStack.pop();
            }

            else {
                    while(!arrStack.isEmpty() && priority(character) <= priority((Character) arrStack.top())){
                        postfix.append(arrStack.top()).append(" ");
                        arrStack.pop();
                    }
                    arrStack.push(character);
            }
        }

        while (!arrStack.isEmpty()) {
            postfix.append(arrStack.top()).append(" ");
            arrStack.pop();
        }

        System.out.println(postfix);
        return null;
    }
    public InfixToPostfix(String infix){
        this.infix = infix;
    }

    public static void main(String[] args) {
        String string = "((A + B) - C * (D / E)) + F";

        System.out.println("Infix:");
        System.out.println(string);

        InfixToPostfix obj = new InfixToPostfix(string);

        System.out.println("Postfix: ");
        obj.convertToPostFix();
    }

}
