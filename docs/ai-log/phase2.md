# 🤖 Faz 2 — Structural Örüntüler (AI Log)

## 📝 1. Yapılan Değişiklikler ve Uygulama
* **Eski Yapı (Faz 1):** Sepetin temel fiyat hesaplaması sadece ürünler ve indirimler üzerinden yapılıyordu. Kargo ücreti, hediye paketi veya özel sigorta gibi dinamik ek maliyetler sisteme dahil edilmek istendiğinde sepet sınıfının şişme riski vardı.
* **Yeni Yapı (Faz 2):** `ShoppingCart` sınıfının yapısını bozmadan, nesnelere dinamik olarak yeni sorumluluklar yüklemek adına **Decorator Pattern** uygulandı. `CartDecorator` adında bir soyut sarmalayıcı (wrapper) yazılarak bundan `ShippingDecorator` ve `GiftWrapDecorator` sınıfları türetildi.

---

## 💬 2. AI İletişimi ve Örüntü Seçim Tartışması

### ❓ AI'a Sorulan Mimari Soru
> "E-ticaret sepetine kargo ücreti ve hediye paketi gibi runtime'da seçilebilecek ek özellikler eklemek istiyorum. Bunun için Adapter, Facade ve Decorator desenlerinden hangisi daha uygundur? Farkları nelerdir?"

### 🤖 AI'ın Yanıtı ve Alternatiflerin Reddedilme Gerekçesi
* **Adapter Neden Reddedildi?** Adapter, iki uyumsuz arayüzün birlikte çalışmasını sağlar. Bizim durumumuzda uyumsuz bir dış kütüphane veya arayüz olmadığı için elendi.
* **Facade Neden Reddedildi?** Facade, karmaşık bir alt sistemi tek bir basitleştirilmiş arayüz arkasına saklar. Biz alt sistemi gizlemek değil, nesneye yeni yetenekler kazandırmak istiyoruz.
* **Decorator Neden Seçildi?** Mevcut nesnenin arayüzünü değiştirmeden, çalışma anında (runtime) nesneye esnek ve üst üste eklenebilir (stackable) özellikler giydirmeyi sağladığı için en uygun çözüm olarak belirlendi.

---

## ⚠️ 3. AI'ın Yanılttığı Nokta ve Kritik Hata Tespiti (Refleksiyon)

> **ÖDEVİN EN KRİTİK BÖLÜMÜ:** AI ile pair-programming yaparken yapay zeka beni mimari açıdan kritik bir noktada yanılttı.

* **AI'ın Hatalı Önerisi:** AI, `ShippingDecorator` sınıfını yazarken sepetin metotlarını sarmalamak yerine, doğrudan `ShoppingCart` sınıfından kalıtım (inheritance) alarak bir alt sınıf oluşturmamı önerdi. 
* **Benim Tespit Ettiğim Hata:** Eğer AI'ın dediği gibi kalıtım kullansaydım, hem kargo hem de hediye paketi seçildiğinde `ShippingAndGiftWrapShoppingCart` gibi devasa ve esnek olmayan alt sınıflar üretmek zorunda kalacaktım (Class explosion). 
* **Çözümüm:** AI'ın bu hatalı ve nesne odaklı olmayan yönlendirmesini reddettim. Kalıtım yerine **kompozisyon (composition)** kullanarak tüm decorator'ların ortak bir interface/abstract sınıf üzerinden birbirini sarmalamasını sağladım. Böylece kullanıcı hem kargo hem hediye paketini aynı anda seçtiğinde nesneler spagettiye dönüşmeden üst üste başarıyla giydirilebildi.

---

## 🧠 4. Kazanımlar
Decorator Pattern sayesinde sepet sisteminde "Kalıtım yerine Kompozisyon" (Composition over Inheritance) prensibini uyguladım. Yeni bir ek hizmet (örn: Hızlı Teslimat seçeneği) geldiğinde mevcut sepet veya kargo kodlarına hiç dokunmadan, sadece yeni bir decorator yazarak sistemi genişletebileceğimi fark ettim.