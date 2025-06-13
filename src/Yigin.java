import java.util.Scanner;

public class Yigin {
    int top = 0;

    // Eleman ekleme (push)
    public void push(int x, int[] a) {
        a[top] = x;
        top++;
    }

    // Eleman çıkarma (pop)
    public int pop(int[] a) {
        top--;
        return a[top];
    }

    public static void main(String[] args) {
        Scanner oku = new Scanner(System.in);
        Yigin metot = new Yigin();
        int[] stk = new int[120];

        System.out.println("Postfix ifadeyi giriniz (örnek: 532-/47*+):");
        String str = oku.nextLine();

        int a = 0, b = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int x = ch - '0';  // Karakteri sayıya çeviriyoruz
                metot.push(x, stk);
            } else if (ch == '+') {
                b = metot.pop(stk);
                a = metot.pop(stk);
                metot.push(a + b, stk);
                System.out.println("a + b = " + (a + b));
            } else if (ch == '-') {
                b = metot.pop(stk);
                a = metot.pop(stk);
                metot.push(a - b, stk);
                System.out.println("a - b = " + (a - b));
            } else if (ch == '*') {
                b = metot.pop(stk);
                a = metot.pop(stk);
                metot.push(a * b, stk);
                System.out.println("a * b = " + (a * b));
            } else if (ch == '/') {
                b = metot.pop(stk);
                a = metot.pop(stk);
                if (b == 0) {
                    System.out.println("Hata: 0'a bölme");
                    return;
                }
                metot.push(a / b, stk);
                System.out.println("a / b = " + (a / b));
            }
        }

        int sonuc = metot.pop(stk);
        System.out.println("Postfix ifadesinin işlem sonucu = " + sonuc);
    }
}
