import java.util.Scanner;

public class Baslangic {
    public static void main(String[] args) {
        // Kullanıcıdan boy ve kilo bilgilerini alma
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen boyunuzu (metre cinsinden) girin: ");
        double boy = scanner.nextDouble();

        System.out.print("Lütfen kilonuzu girin: ");
        double kilo = scanner.nextDouble();

        // Vücut Kitle İndeksi (BMI) hesaplama
        double bmi = kilo / (boy * boy);

        // Sonucu ekrana yazdırma
        System.out.println("Vücut Kitle İndeksiniz (BMI): " + bmi);
    }
}