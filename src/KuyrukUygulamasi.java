import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KuyrukUygulamasi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> kuyruk = new LinkedList<>();
        int secim;

        do {
            // Menü
            System.out.println("\n--- KUYRUK MENÜ ---");
            System.out.println("1. Eleman Ekle");
            System.out.println("2. Eleman Çıkar");
            System.out.println("3. İlk Elemanı Göster");
            System.out.println("4. Kuyruğu Göster");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine(); // satır sonu karakterini temizle

            switch (secim) {
                case 1:
                    System.out.print("Eklenecek ismi girin: ");
                    String isim = scanner.nextLine();
                    kuyruk.add(isim);
                    System.out.println(isim + " kuyruğa eklendi.");
                    break;
                case 2:
                    if (!kuyruk.isEmpty()) {
                        String cikan = kuyruk.poll();
                        System.out.println(cikan + " kuyruktan çıkarıldı.");
                    } else {
                        System.out.println("Kuyruk boş, çıkarılacak eleman yok.");
                    }
                    break;
                case 3:
                    if (!kuyruk.isEmpty()) {
                        System.out.println("İlk sıradaki: " + kuyruk.peek());
                    } else {
                        System.out.println("Kuyruk boş.");
                    }
                    break;
                case 4:
                    System.out.println("Kuyruktaki elemanlar: " + kuyruk);
                    break;
                case 0:
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! 0-4 arasında bir sayı girin.");
            }

        } while (secim != 0);

        scanner.close();
    }
}
