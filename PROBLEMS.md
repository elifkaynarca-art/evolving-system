# PROBLEMS.md — Başlangıç Kodu Analizi

## Tespit Edilen Tasarım Sorunları

### Sorun 1: Her yeni indirim tipi için mevcut kodu değiştirmek gerekiyor
`calculateTotal()` metoduna her yeni indirim eklemek için içine girip else if eklemek gerekiyor.
Bu kötü çünkü çalışan kodu bozmak zorunda kalıyoruz.

### Sorun 2: Sınıf çok büyüyor, her şey iç içe giriyor
Tüm sorumluluklar `ShoppingCart` sınıfına yüklenmiş. Yeni özellik ekledikçe sınıf şişiyor.

### Sorun 3: Okuması ve anlaması zorlaşıyor
Kodu ilk kez okuyan biri nerede ne olduğunu bulmakta zorlanır.

### Sorun 4: İki kişi aynı anda çalışamıyor
Tek bir büyük sınıf olduğu için iki programcı aynı dosyayı aynı anda değiştirmeye çalışırsa Git'te çakışma (merge conflict) yaşanır.

### Sorun 5: İndirim mantığını ayrı test edemiyoruz
İndirim hesaplamayı test etmek için tüm sepet sistemini çalıştırmak gerekiyor. Ayrı bir sınıfta olsaydı bağımsız test edilebilirdi.

---

## AI Karşılaştırması

### Ben ne gördüm:
- Her yeni indirim için kodu değiştirmek gerekiyor
- Sınıf şişiyor, her şey iç içe giriyor
- Okuması zor
- İki kişi aynı anda çalışamıyor (merge conflict riski)
- İndirim mantığını ayrı test edemiyoruz

### AI (ChatGPT) ne gördü:
- İndirim mantığı ShoppingCart içine gömülmüş, Strategy Pattern ile çözülebilir
- String ile indirim tipi kontrolü tehlikeli, enum kullanılmalı
- ShoppingCart fazla sorumluluk taşıyor (Single Responsibility Principle ihlali)
- Encapsulation eksik, alanlar private olmalı ve getter/setter kullanılmalı
- calculateTotal() hem toplam hesaplıyor hem indirim uyguluyor, ayrıştırılmalı

### Fark var mı?
Evet. Ben merge conflict riskini ve test edilemezlik sorununu fark ettim, AI bunları söylemedi.
AI ise String kullanımının tehlikeli olduğunu ve encapsulation eksikliğini buldu, bunları ben atlamıştım.
İkisi birleşince daha eksiksiz bir analiz ortaya çıktı.
