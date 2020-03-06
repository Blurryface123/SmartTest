import validator.Validator;
import validator.ValidatorExample;

public class RunExample {

        public static void main(String[] args) {

        Validator validator = new ValidatorExample();

        byte[] message = { 0x02, 0x10, 0x02, 0x0A, 0x10, 0x10, 0x07, 0x08, 0x03, 0x24 };
        System.out.println("Message is valid: " + validator.isValid(message));

        }
    }


