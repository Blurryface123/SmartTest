package com.validator.validatorExample;

import com.google.common.primitives.Bytes;

public class ValidatorExample  implements Validator {

    /* Note: the required no-argument constructor is implicitly defined if no
     * other constructors are provided */

    /**
     * Indicate if the given message is valid.
     *
     * @param message The message to check
     * @return {@code true} if the message starts with STX, ends with ETX and the
     *         correct LRC, and has correctly-escaped data; {@code false}
     *         otherwise.
     * @todo Implement this method
     */
    public boolean isValid(byte[] message) {
        byte stx = 0x02;
        byte etx = 0x03;
        int start = Bytes.indexOf(message,stx);
        //starts counting at 0
        int end = Bytes.indexOf(message,etx)+1;
        byte[] newByte = new byte[message.length];
        //Minus 1 because it starts at 1
        if(start==0 && end==message.length-1){
            int count = 0;
            for (int i = 0; i < message.length-1; i++) {

                if (message[i]==0x10){
                    //System.out.println(message[i]);
                    i++;
                }
                newByte[count] = message[i];
                System.out.println("AFTER PROTOCOL: "+newByte[count]);
                count++;
            }

        }
        return validateLRC(message,newByte);
    }

    public static boolean validateLRC(byte[] message, byte[] newByte){
        int endArray = Bytes.indexOf(message,calculateLRC(newByte));
        boolean flag = false;
        if(endArray==message.length-1){
            flag =true;
            System.out.println(flag);
        }
        return flag;
    }

    public static byte calculateLRC(byte[] bytes) {
        byte lrc = 0;
        for (int i = 1; i < bytes.length - 1; i++) {
            lrc ^= bytes[i];

        }
        System.out.println("LRC: "+lrc);
        return lrc;
    }

}

