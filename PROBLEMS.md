# PROBLEMS.md — Başlangıç Kodu Analizi (Faz 0)

## 📌 Tespit Edilen Tasarım Sorunları

### Sorun 1: Açık/Kapalı Prensibi (Open/Closed Principle - OCP) İhlali
* **Açıklama:** `ShoppingCart` sınıfı içindeki `calculateTotal()` metodu, her yeni indirim tipi veya kuralı eklendiğinde mevcut `if-else` / `switch-case` zincirlerine yeni kod blokları eklenmesini zorunlu kılıyor.
* **Neden Sorun?** Çalışan ve kararlı koda sürekli manuel müdahalede bulunmak, sistemin diğer çalışan dinamiklerini bozma ve beklenmedik mantıksal hatalar (bug) üretme riski taşır. Sistem gelişmeye açık, değişime kapalı olmalıdır.

### Sorun 2: Tek Sorumluluk Prensibi (Single Responsibility Principle - SRP) İhlali
* **Açıklama:** `ShoppingCart` sınıfı hem sepetteki ürün listesini tutmak, hem toplam fiyatı hesaplamak hem de indirim mantıklarını yürütmek gibi birden fazla kritik sorumluluğu tek başına üstlenmiştir (God Class anti-pattern).
* **Neden Sorun?** Bir sınıfın değişmesi için birden fazla nedenin bulunması, kod tabanı büyüdükçe sınıfın aşırı şişmesine, okunamaz hale gelmesine ve bakım maliyetlerinin devasa artmasına yol açar.

### Sorun 3: Yüksek Bağlılık (Tight Coupling) ve Düşük Uyum (Cohesion)
* **Açıklama:** Farklı indirim hesaplama algoritmaları bağımsız nesneler olarak ele alınmamış, doğrudan sepetin iç yapısına sıkı sıkıya bağımlı şekilde kodun içerisine gömülmüştür.
* **Neden Sorun?** Kodun spagetti yapıya dönüşmesine neden olur. Yeni bir geliştirici koda dahil olduğunda iş mantığının nerede başlayıp nerede bittiğini anlamakta zorlanır ve kodun sürdürülebilirliği düşer.

### Sorun 4: Ekip Çalışmasına Uygunsuzluk (Merge Conflict Riski)
* **Açıklama:** Sisteme dair tüm yetenekler ve iş mantığı tek bir büyük `.java` dosyası (sınıf) içinde yer almaktadır.
* **Neden Sorun?** Aynı anda projede çalışan iki farklı programcı farklı indirim özellikleri veya sepet yetenekleri eklemek istediğinde aynı dosyayı değiştirmek zorunda kalacaktır. Bu durum, Git üzerinde sürekli ve çözülmesi zor çakışmalara (merge conflict) yol açar.

### Sorun 5: İzole Birim Testlerin (Unit Test) Yazılamaması
* **Açıklama:** İndirim hesaplama algoritmaları sepet yapısından soyutlanmadığı için bu mantıkları izole bir şekilde test etmek imkansızdır.
* **Neden Sorun?** Sadece küçük bir indirim kuralının doğruluğunu test etmek için bile tüm sepet sistemini ve ürün bağımlılıklarını ayağa kaldırmak gerekir. Bu da bağımsız birim test yazımını engeller.

---

## 🤖 AI Karşılaştırması

### Ben ne gördüm?
* Her yeni indirim türünde mevcut kodu değiştirme zorunluluğu (OCP İhlali).
* Sınıfın aşırı şişmesi ve sorumlulukların birbirine girmesi (SRP İhlali).
* Kodun okunabilirliğinin ve takibinin zor olması.
* Ekip çalışmasında üreteceği Git çakışması (merge conflict) riskleri.
* İndirim mantığının izole şekilde birim testine tabi tutulamaması.

### AI (ChatGPT) ne gördü?
* İndirim mantığı `ShoppingCart` içine gömülmüş, esnek tasarım için **Strategy Pattern** kullanılmalı.
* String ifadelerle indirim tipi kontrolü yapmak (hardcoded kontrol) hataya çok açıktır, nesne yönelimli mimari veya enum tercih edilmeli.
* `ShoppingCart` sınıfının sınırlarını aşan fazla sorumluluk taşıması (SRP İhlali).
* Encapsulation (Kapsülleme) eksikliği; sınıf alanlarının açık kalması, private yapılıp getter/setter kullanılması gerekliliği.
* `calculateTotal()` metodunun hem sepet toplamını bulup hem indirim hesaplaması; bu iki sorumluluğun ayrıştırılması gerektiği.

### Fark var mı?
Evet, iki analiz birbirini mükemmel şekilde tamamladı. Ben pratik yazılım geliştirme süreçlerindeki operasyonel sıkıntıları (ekip çalışmasındaki Git çakışma risklerini ve test yazımının imkansızlığını) fark ettim. AI ise kodun nesne yönelimli programlama (OOP) standartlarına ve clean-code teorisine olan eksikliklerini (encapsulation hataları, hardcoded String kontrolleri) yakaladı. İki analizin birleşmesi, refactoring sürecinin yol haritasını net bir şekilde ortaya koydu.