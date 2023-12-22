package Giris;
import java.util.Scanner;
public class AsalSayiKontrol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try { System.out.print("Bir sayı girin: ");
            int sayi = scanner.nextInt();
            if (sayi < 2) {
                System.out.println("Asal değil");
            } else {
                if (asalKontrol(sayi, 2)) {
                    System.out.println("Asaldır");
                } else {
                    System.out.println("Asal değil");}}}
        catch (Exception e) {
            System.out.println("Hatalı Veri Girdiniz!");
        } finally {
            scanner.close();}}
    static boolean asalKontrol(int sayi, int bolen) {
        if (bolen > sayi / 2) {
            return true;}
        if (sayi % bolen == 0) {
            return false;}
        return asalKontrol(sayi, bolen + 1);}}
