# 🤖 Faz 3 — Behavioral Örüntüler & CI Pipeline (AI Log)

## 📝 1. Yapılan Değişiklikler ve Uygulama
* **Eski Yapı (Faz 2):** Sepetteki ürünlerin fiyat değişimleri veya sipariş geçilme durumları, sisteme bağlı diğer dinamik yapıları (Stok güncelleme, Müşteri Bildirim Sistemi vb.) tetikleyemiyordu. Tetikleme yapılmak istense her şeyin manuel ve sıkı sıkıya bağımlı (tightly coupled) çağrılması gerekiyordu.
* **Yeni Yapı (Faz 3):** Nesneler arasındaki bire-çok (one-to-many) bağımlılıkları gevşek bağlı hale getirmek için **Observer Pattern** uygulandı. `ObservableProduct` (veya `ShoppingCart`) subject haline getirilerek fiyat değişikliklerinde `PriceObserver` interface'inden türeyen `CustomerNotifier` gibi dinleyicilerin otomatik tetiklenmesi sağlandı.
* **Açık/Kapalı Prensibi (OCP) Gösterimi:** Yeni bir bildirim kanalı (örn: SMS yerine Slack bildirimi) eklemek için mevcut ürün veya sepet koduna dokunmuyoruz. Sadece `PriceObserver` interface'ini implement eden yeni bir sınıf yazıp runtime'da listeye register (kayıt) ediyoruz. Kod değişime kapalı, gelişime açık hale geldi.

---

## ⏱️ 2. AI ile Pair Programming Oturum Özeti (En Az 30 Dakika)

* **Süreç Nasıl İlerledi?** AI ile yaklaşık 40 dakikalık interaktif bir pair programming oturumu gerçekleştirdik. İlk olarak Java'daki `PropertyChangeListener` gibi hazır yapıları mı kullanmalıyım yoksa örüntüyü sıfırdan interface'ler ile kendim mi kurmalıyım, bunu tartıştık.
* **Mimari Tartışma:** AI, ürün fiyat değişimini izlemek için Observer kurarken, sepetin kendisini de izleyebilecek bir altyapıyı nasıl birleştirebileceğimiz konusunda fikirler sundu. Adım adım `attach()`, `detach()` ve `notifyObservers()` metotlarının imzalarını birlikte belirledik.

---

## ❓ 3. Kritik Soruların Yanıtları (Refleksiyon)

### Soru A: AI olmadan bu faz ne kadar sürerdi?
* **Cevap:** AI olmadan sadece Observer örüntüsünü kurmak ve test etmek muhtemelen 2-3 saatimi alırdı. Ancak bu faza dahil olan **GitHub Actions ile CI pipeline (`ci.yml`)** kurulumu, doğru Java JDK sürümünün ayarlanması ve Maven/Gradle derleme script'lerinin yazılması süreci yapay zeka desteği olmasaydı araştırma ve hata ayıklamalarla birlikte en az 5-6 saatimi alabilirdi. AI sayesinde bu süreyi toplamda 1-1.5 saate indirerek ciddi bir zaman tasarrufu sağladım.

### Soru B: AI sizi nerede yanılttı?
* **Cevap:** AI, `notifyObservers()` metodunu yazarken güncellenen fiyat bilgisini doğrudan parametre olarak göndermemi (`Push Model`) önerdi. Ancak bu durum, gelecekte sadece fiyat değil, ürün adı veya stok durumu değiştiğinde interface'in kırılmasına yol açacaktı. AI'ın bu dar bakış açısını fark ederek reddettim. Parametre olarak doğrudan güncellenen nesnenin referansını (`Pull Model`) gönderdim; böylece observer'lar nesne içinden ihtiyaç duydukları veriyi (`getPrice()`, `getStock()`) kendileri çekebilecek esnekliğe kavuştu.

---

## 🚀 4. GitHub Actions CI Entegrasyonu
Faz 3 gereksinimleri doğrultusunda, projenin her `push` ve `pull request` anında otomatik olarak derlenmesini sağlamak için `.github/workflows/ci.yml` dosyası yapılandırıldı. AI ile birlikte yazılan bu yaml dosyası sayesinde projenin ana branch'e (`main`) her zaman derlenebilir ve hatasız kodlarla birleşmesi (Continuous Integration) garanti altına alındı.