# DECORATOR_LOG.md — Faz 2 AI Log

## Ne değiştirdim?
Sepete kargo ve hediye paketi özelliği ekledim.
Bunları ShoppingCart'ı bozmadan CartDecorator ile giydirdim.
ShippingDecorator kargo ücreti, GiftWrapDecorator hediye paketi ücreti ekliyor.

## Neden Decorator Pattern?
ShoppingCart'ı değiştirmeden üstüne özellik ekleyebildim.
İstediğim kadar özelliği üst üste koyabiliyorum.

## AI'a sorduğum soru:
"Decorator Pattern ne zaman kullanılır, ne işe yarar?"

## AI ne dedi:
Decorator Pattern, bir nesneye mevcut yapısını değiştirmeden yeni özellikler veya davranışlar eklemek istediğimiz durumlarda kullanılır. Kalıtım kullanmadan nesneleri dinamik olarak geliştirmeyi sağlar ve özellikle aynı nesneye farklı özellik kombinasyonları eklemek gerektiğinde işe yarar.

## Ben ne anladım:
Sepeti bozmadan üstüne kargo veya hediye paketi gibi
özellikler ekleyebildim. Yeni özellik lazımsa sadece
yeni bir Decorator sınıfı yazmak yeterli.