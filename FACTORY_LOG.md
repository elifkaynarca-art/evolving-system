# FACTORY_LOG.md — Faz 1 AI Log

## Ne değiştirdim?
ShoppingCart içindeki if-else indirim mantığını kaldırdım.
Her indirim tipi için ayrı sınıf yazdım.
DiscountFactory bu sınıfları üretiyor.

## Neden Factory Pattern?
Yeni indirim eklemek için artık ShoppingCart'ı değiştirmeme gerek yok.
Sadece yeni bir sınıf ekleyip Factory'e tanıtmak yeterli.

## AI'a sorduğum soru:
"Factory Pattern ne zaman kullanılır, Strategy Pattern'den farkı nedir?"

## AI ne dedi:
Factory Pattern, hangi nesnenin oluşturulacağını merkezi şekilde kontrol etmek istediğimiz durumlarda kullanılır. Strategy Pattern ise aynı işi farklı yöntemlerle yapabilmek ve çalışma anında davranışı değiştirebilmek için kullanılır. Aralarındaki temel fark, Factory Pattern’ın nesne oluşturma sürecine odaklanması, Strategy Pattern’ın ise davranış ve algoritma seçimine odaklanmasıdır.

## Ben ne anladım:
Factory Pattern eklemeden önce yeni indirim eklemek için 
ShoppingCart içindeki calculateTotal() metodunu değiştirmek gerekiyordu.
Şimdi sadece yeni bir sınıf ekleyip DiscountFactory'e tanıtmak yeterli.
Mevcut kodu bozmadan yeni özellik ekleyebiliyoruz.