package com.haydikodla.repository;

import com.haydikodla.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;
/*
 Hazır metotlarımızı barındırıyoruz ve eğer yeterli olmazsa kendi metotlarımızı oluşturabiliriz
 Repository nesnesi yaratabilmek için hangi collection/tablo' ya bağlamalıyız?
 Bunun unique identifier'ı olmak zorunda ve bunun türünü belirtmeliyiz
*/
public interface KullaniciRepository extends MongoRepository<Kullanici,String> {
}
