import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> kelimeDizisi = Arrays.asList("kalem", "elalem", "kelam", "kelime");

        String[] tekrarlıKelimeler = kelimeleriAnalizEt(kelimeDizisi);

        if (tekrarlıKelimeler != null) {
            String yeniMetin = yeniMetinOlustur(tekrarlıKelimeler);
            System.out.println("Tekrarlı harf içeren 2 kelime: " + tekrarlıKelimeler[0] + ", " + tekrarlıKelimeler[1]);
            System.out.println("Oluşturulan metin: " + yeniMetin);
        } else {
            System.out.println("Tekrarlı harf içeren iki kelime bulunamadı.");
        }
    }

    public static String[] kelimeleriAnalizEt(List<String> kelimeDizisi) {
        List<String> tekrarlıKelimeler = new ArrayList<>();

        for (String kelime : kelimeDizisi) {
            if (tekrarlıHarfVarMi(kelime)) {
                tekrarlıKelimeler.add(kelime);
                if (tekrarlıKelimeler.size() == 2) {
                    return new String[] { tekrarlıKelimeler.get(0), tekrarlıKelimeler.get(1) };
                }
            }
        }
        return null;
    }

    public static boolean tekrarlıHarfVarMi(String kelime) {
        Set<Character> karakterSeti = new HashSet<>();
        for (char c : kelime.toCharArray()) {
            if (karakterSeti.contains(c)) {
                return true;
            }
            karakterSeti.add(c);
        }
        return false;
    }

    public static String yeniMetinOlustur(String[] tekrarlıKelimeler) {
        String birlesikKelime = tekrarlıKelimeler[0] + tekrarlıKelimeler[1];
        List<Character> karakterListesi = new ArrayList<>();

        for (char c : birlesikKelime.toCharArray()) {
            karakterListesi.add(c);
        }

        Collections.shuffle(karakterListesi);
        StringBuilder yeniMetin = new StringBuilder();
        for (char c : karakterListesi) {
            yeniMetin.append(c);
        }

        return yeniMetin.toString();
    }
}