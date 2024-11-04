import java.util.Scanner;

public class ATM {
    private String username = "kullaniciAdi"; // Kullanıcı adı
    private String password = "sifre123"; // Şifre
    private double balance = 1000.0; // Bakiyeniz

    public static void main(String[] args) {
        ATM atm = new ATM(); // ATM nesnesi oluştur
        atm.login(); // Giriş fonksiyonunu çağır
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kullanıcı Adınızı Girin: ");
        String inputName = scanner.nextLine();

        System.out.print("Şifrenizi Girin: ");
        String inputPassword = scanner.nextLine();

        if (inputName.equals(username) && inputPassword.equals(password)) {
            System.out.println("Giriş başarılı!");
            showMenu(scanner); // Menü göster
        } else {
            System.out.println("Kullanıcı adı veya şifre hatalı.");
        }

        scanner.close(); // Scanner'ı kapat
    }

    public void showMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n1. Bakiyemi Görüntüle");
            System.out.println("2. Para Çek");
            System.out.println("3. Para Yatır");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        } while (choice != 4);
    }

    public void showBalance() {
        System.out.println("Bakiyeniz: " + balance + " TL");
    }

    public void withdraw(Scanner scanner) {
        System.out.print("Çekmek istediğiniz miktarı girin: ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Yetersiz bakiye.");
        } else {
            balance -= amount;
            System.out.println(amount + " TL başarıyla çekildi.");
        }
    }

    public void deposit(Scanner scanner) {
        System.out.print("Yatırmak istediğiniz miktarı girin: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " TL başarıyla yatırıldı.");
        } else {
            System.out.println("Geçersiz miktar.");
        }
    }
}
