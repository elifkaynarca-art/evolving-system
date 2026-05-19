 # 🏗️ Evrimleşen Sistem - E-Ticaret Sepeti (Konu D)

### 📌 Konu Seçimi ve Gerekçesi
Bu projede **D Konusu (E-Ticaret Sepeti)** seçilmiştir. Başlangıçta indirim hesaplamalarının sepet sınıfına gömülü olması ve her yeni kural eklendiğinde mevcut kodun kırılması, sistemin sürdürülebilirliğini ve genişletilebilirliğini tamamen engelliyordu. Bu ödev kapsamında, tasarım örüntülerini soyut birer kavram olarak değil, bu gerçek mimari sorunun çözümü olarak uyguladım. Nesne yönelimli programlama prensipleri (SOLID) doğrultusunda sepetin iç yapısını değiştirmeden yeni indirim kuralları ve dinamik özellikler eklenebilen esnek bir mimari inşa etmeyi hedefledim.

---

## 🚀 Proje Hakkında
Bu uygulama, bir e-ticaret sepetinin ilk ilkel halinden (bol if-else/switch-case blokları içeren spagetti yapıdan) başlayarak Creational, Structural ve Behavioral tasarım örüntüleriyle adım adım modernize edilmiş halidir.

---

## 🛠️ Kullanılan Tasarım Örüntüleri

### 1. Creational (Yaratımsal) Örüntüler — Faz 1
* **Factory Method:** İndirim stratejilerinin nesne yaratım sorumluluğunu `ShoppingCart` dışına çıkararak merkezi bir yapıya taşımak ve gevşek bağlılık (loose coupling) sağlamak için kullanıldı.

### 2. Structural (Yapısal) Örüntüler — Faz 2
* **Decorator Pattern:** Mevcut sepet ve ürün nesnelerinin arayüzünü değiştirmeden, çalışma anında (runtime) dinamik ve üst üste eklenebilir özellikler (kargo ücreti, hediye paketi seçeneği vb.) giydirmek için kalıtım yerine kompozisyon kullanılarak uygulandı.

### 3. Behavioral (Davranışsal) Örüntüler — Faz 3
* **Strategy Pattern:** Farklı indirim hesaplama algoritmalarını (Yüzde indirim, sabit indirim vb.) kendi sınıflarına izole ederek sepet hesaplamasına dinamik olarak dahil etmek amacıyla kullanıldı.
* **Observer Pattern:** Ürün fiyatlarında veya sepet durumlarında meydana gelen değişiklikleri, sisteme bağlı diğer alt bileşenlere (Müşteri Bildirim Sistemi vb.) otomatik ve bağımsız olarak bildirmek için uygulandı.

---

## 📐 Mimari Diyagram (UML)
Projenin gelişim sürecini gösteren UML sınıf diyagramlarına `docs/diagrams/` klasöründen ulaşabilirsiniz.
* Final Mimarisi: `![Sistem Mimarisi](docs/diagrams/final_architecture.png)`

---

## 💻 Nasıl Çalıştırılır?

### Gereksinimler
* Java JDK 11+ (Derleme ve test süreçleri için)

### Çalıştırma Adımları
1. Projeyi yerel bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/elifkaynarca-art/evolving-system.git](https://github.com/elifkaynarca-art/evolving-system.git)