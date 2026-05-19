# 🤖 Faz 1 — Creational Örüntüler (AI Log)

## 📝 1. Yapılan Değişiklikler ve Uygulama
* **Eski Yapı (Faz 0):** `ShoppingCart` sınıfı içerisinde indirim tipleri hardcoded String kontrolleriyle ve `if-else` zincirleriyle yönetiliyordu. Nesne yaratımı ve iş mantığı birbirine karışmıştı.
* **Yeni Yapı (Faz 1):** Nesne yaratma sorumluluğunu esnek bir yapıya taşımak için **Factory Method** örüntüsü uygulandı. `DiscountStrategy` arayüzünden türeyen indirim sınıfları (`PercentageDiscount`, `FixedDiscount`, `NoDiscount`) oluşturuldu. Bu nesnelerin üretimi ise tamamen `DiscountFactory` sınıfına devredildi.

---

## 💬 2. AI İletişimi ve Soru-Cevap (Prompt)

### ❓ AI'a Sorulan Prompt
> "Factory Pattern ne zaman kullanılır, Strategy Pattern'den farkı nedir? E-ticaret sepetindeki indirim sisteminde nesne üretimi ve algoritma değişimi süreçlerini bu iki örüntüye göre nasıl ayırmalıyım?"

### 🤖 AI'ın Verdiği Yanıtın Özeti
* **Factory Pattern:** Hangi nesnenin, hangi kurallara göre oluşturulacağını merkezi bir yapıda kontrol etmek (Creational) istediğimiz durumlarda kullanılır. Nesne üretim süreçlerini istemciden gizler.
* **Strategy Pattern:** Aynı işi (örn: indirim hesaplama) farklı algoritmalarla yapabilmek ve runtime'da (çalışma anında) bu davranışı dinamik olarak değiştirebilmek (Behavioral) için kullanılır.
* **Özet Fark:** Factory Pattern nesnenin **nasıl yaratılacağına**, Strategy Pattern ise nesnenin **nasıl davranacağına** odaklanır.

---

## 🧠 3. Kişisel Değerlendirme ve Refleksiyon

### AI Önerisi ile Benim Uygulamam Arasındaki İlişki
AI'ın teorik açıklaması doğrultusunda tam olarak eş zamanlı bir hibrit yapı kurmaya karar verdim. AI'ın önerdiği gibi nesnelerin davranışlarını soyutlamak adına indirim mantıklarını kendi sınıflarına dağıttım (Strategy altyapısı). Ancak bu faza sadık kalarak, `ShoppingCart`'ın bu indirim sınıflarının somut hallerine (concrete classes) doğrudan bağımlı olmasını engellemek için nesne üretimini tamamen `DiscountFactory` üzerinden gerçekleştirdim.

### Bana Ne Kazandırdı?
Factory Pattern sayesinde `ShoppingCart` artık hangi indirim nesnesinin nasıl üretildiğini bilmek zorunda kalmıyor, yani gevşek bağlılık (loose coupling) sağlandı. Yeni bir indirim türü eklemek istediğimizde sepet koduna dokunmak zorunda kalmıyoruz; sadece yeni bir indirim sınıfı yazıp bunu `DiscountFactory`'ye tanıtıyoruz. Böylece nesne yaratım süreçlerinde Açık/Kapalı Prensibini (OCP) başarıyla korumuş olduk.