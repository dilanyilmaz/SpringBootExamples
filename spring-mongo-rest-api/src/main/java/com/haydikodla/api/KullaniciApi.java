package com.haydikodla.api;

import com.haydikodla.entity.Kullanici;
import com.haydikodla.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {
    /*Best Practis : Constructure injection*/
    /*
    private final KullaniciRepository kullaniciRepository;

    public KullaniciApi(KullaniciRepository kullaniciRepository){
        this.kullaniciRepository = kullaniciRepository ;
    }
     */

    /*
    @GetMapping: Veriyi ekrana basma vb.
    @PostMapping: Formdan veri alma işlemi gibi vb.
        Veriyi almak istediğin yeri belirtmelisin!
        @RequestBody: Body den veriyi çektiğimizi belirtiyoruz
        @RequestHeader: Headerdan veri almak çok mantıklı değil !
    @PutMapping: Güncelleme işlemleri
    @DeleteMapping: Silme işlemleri
    */
    @Autowired
    private KullaniciRepository kullanciRepository;
    @PostConstruct
    public void init(){
        Kullanici kullanici = new Kullanici();
        kullanici.setAdi("Haydi");
        kullanici.setSoyadi("sende dene");
        kullanciRepository.save(kullanici);
    }
    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody @RequestHeader Kullanici kullanici){
        return ResponseEntity.ok(kullanciRepository.save(kullanici));
    }
    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele(){
        return ResponseEntity.ok(kullanciRepository.findAll());
    }
}
