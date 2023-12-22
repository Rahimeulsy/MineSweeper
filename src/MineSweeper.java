import java.util.Random;
import java.util.Scanner;
public class MineSweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Satır sayısını girin: ");
        int satirSayisi = scanner.nextInt();
        System.out.print("Sütun sayısını girin: ");
        int sutunSayisi = scanner.nextInt();
        int elemanSayisi = satirSayisi * sutunSayisi;
        int mayinSayisi = elemanSayisi / 4;
        char[][] oyunTahtasi = new char[satirSayisi][sutunSayisi];
        boolean[][] mayinKonumlari = new boolean[satirSayisi][sutunSayisi];
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                oyunTahtasi[i][j] = '-';}}
        for (int k = 0; k < mayinSayisi; k++) {
            int randomSatir = random.nextInt(satirSayisi);
            int randomSutun = random.nextInt(sutunSayisi);
            while (mayinKonumlari[randomSatir][randomSutun]) {
                randomSatir = random.nextInt(satirSayisi);
                randomSutun = random.nextInt(sutunSayisi);}
            mayinKonumlari[randomSatir][randomSutun] = true;}
        System.out.println("Mayın Tarlası Oyunu Başlıyor!");
        boolean oyunDevamEdiyor = true;
        while (oyunDevamEdiyor) {
            tahtaYazdir(oyunTahtasi);
            int secilenSatir, secilenSutun;
            do {
                System.out.print("Satır seçin (0 - " + (satirSayisi - 1) + "): ");
                secilenSatir = scanner.nextInt();
                System.out.print("Sütun seçin (0 - " + (sutunSayisi - 1) + "): ");
                secilenSutun = scanner.nextInt();
            } while (!gecerliNokta(secilenSatir, secilenSutun, satirSayisi, sutunSayisi));
            if (mayinKonumlari[secilenSatir][secilenSutun]) {
                oyunDevamEdiyor = false;
                System.out.println("Mayına bastınız! Oyunu kaybettiniz.");
            } else {
                int etrafindakiMayinlar = etrafindakiMayinSayisi(mayinKonumlari, secilenSatir, secilenSutun);
                oyunTahtasi[secilenSatir][secilenSutun] = (char) (etrafindakiMayinlar + '0');}
            if (tumNoktalariSecildiMi(oyunTahtasi, mayinKonumlari)) {
                oyunDevamEdiyor = false;
                tahtaYazdir(oyunTahtasi);
                System.out.println("Tebrikler! Oyunu kazandınız.");}}
        scanner.close();}
    static void tahtaYazdir(char[][] tahta) {
        System.out.println("Oyun Tahtası:");
        for (char[] satir : tahta) {
            for (char eleman : satir) {
                System.out.print(eleman + " ");}
            System.out.println();}
        System.out.println();}
    static boolean gecerliNokta(int satir, int sutun, int satirSayisi, int sutunSayisi) {
        return (satir >= 0 && satir < satirSayisi && sutun >= 0 && sutun < sutunSayisi);}
    static int etrafindakiMayinSayisi(boolean[][] mayinKonumlari, int satir, int sutun) {
        int sayac = 0;
        for (int i = satir - 1; i <= satir + 1; i++) {
            for (int j = sutun - 1; j <= sutun + 1; j++) {
                if (gecerliNokta(i, j, mayinKonumlari.length, mayinKonumlari[0].length) && mayinKonumlari[i][j]) {
                    sayac++;}}}
        return sayac;}
    static boolean tumNoktalariSecildiMi(char[][] oyunTahtasi, boolean[][] mayinKonumlari) {
        for (int i = 0; i < oyunTahtasi.length; i++) {
            for (int j = 0; j < oyunTahtasi[0].length; j++) {
                if (oyunTahtasi[i][j] == '-' && !mayinKonumlari[i][j]) {
                    return false;}}}
        return true;
    }
}

