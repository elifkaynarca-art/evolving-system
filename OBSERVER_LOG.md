# OBSERVER_LOG.md — Faz 3 AI Log

## Ne değiştirdim?
Observer Pattern ekledim. Ürün fiyatı değişince
kayıtlı dinleyiciler otomatik bildirim alıyor.

## Neden Observer Pattern?
Fiyat değişikliğini ShoppingCart içinde kontrol etmek
yerine, ilgili sınıflar kendileri dinliyor.
Yeni bildirim tipi eklemek için mevcut kodu değiştirmeme gerek yok.

## AI'a sorduğum soru:
"Observer Pattern ne zaman kullanılır?"

## AI ne dedi:
Observer Pattern, bir nesnede meydana gelen değişikliğin bağlı olan diğer nesnelere otomatik olarak bildirilmesi gerektiğinde kullanılır. Özellikle bildirim sistemleri, canlı veri güncellemeleri ve kullanıcı arayüzü olaylarında sık tercih edilir.

## Ben ne anladım:
Fiyat değişince tüm dinleyiciler otomatik haberdar oluyor.
Sepeti veya ürün sınıfını bozmadan yeni bildirim ekleyebiliyorum.