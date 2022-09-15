# SPRİNG CRUD APİ

### Veritabanı Şablonu
| Kullanıcı        | Urun                               | UrunYorum         |
|------------------|------------------------------------|-------------------|
| Id               | Id                                 | Id                |
| Adı(50 char)     | Adı                                | Yorum(500 char)   |
| Soyadı(50 char)  | Fiyat                              | yorumTarihi(date) | 
| Email(50 char)   | Son Kullanma Tarihi(null olabilir) | urunId            |
| telefon(15 char) |                                    | kullaniciId       |

* Bu aşamada ben postgresql kullandım

### Api İçinde Yapılabilecek Maddeler

- Bir ürüne ait yorumları listeleyen bir metot yazınız.
- Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
- Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
- Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
- Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.
- Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)

***
- Postman testleri için import edilebilecek v2 dosyası ekledim.