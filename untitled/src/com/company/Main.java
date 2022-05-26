package com.company;
import java.math.BigInteger;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BigInteger key;
        int st =8;//сколько бит последовательность
        for(int i =0;i<10;i++)
        {
            Exp(st);
            key = RandKey(st);
            if(st==32) {// третье задание для 32-битного ключа
                func3(key);
            }
            st*=2;
            System.out.println("");
        }

    }
    public static void Exp (int exp){// задание 1
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < exp; i++)
            res = res.multiply(BigInteger.valueOf(2));
        System.out.println("Пространство ключей для "+exp+"-битного ключа: "+res);
    }
    public static BigInteger RandKey(int exp){// задание 2
        String str= new String();
        BigInteger bint = new BigInteger(exp, new Random());
        switch (exp)
        {
            case 8:
                str = String.format("%02x", bint);
                break;
            case 16:
                str = String.format("%04x", bint);
                break;
            case 32:
                str = String.format("%06x", bint);
                break;
            case 64:
                str = String.format("%08x", bint);
                break;
            case 128:
                str = String.format("%010x", bint);
                break;
            case  256:
                str = String.format("%012x", bint);
                break;
            case 512:
                str = String.format("%014x", bint);
                break;
            case 1024:
                str = String.format("%016x", bint);
                break;
            case 2048:
                str = String.format("%018x", bint);
                break;
            case 4096:
                str = String.format("%020x", bint);
                break;
        }
        System.out.println("Случайный "+exp+"-битный ключ: 0x" +str);
        return bint;
    }
    public static void func3 (BigInteger bint) {// задание 3
        BigInteger bint2= BigInteger.valueOf(0);
        long time = System.currentTimeMillis();
        if(!(bint.equals(bint2)))
        {
            do{
                bint2 = bint2.add(BigInteger.valueOf(1));
            }while(!(bint.equals(bint2)));
        }
        System.out.print("Время проверки ключа: ");
        System.out.print(System.currentTimeMillis()-time);
        System.out.println(" миллисекунд");
    }
}
