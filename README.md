## Spring-Boot-Project

### Projenin amacı
- Spring-Boot projesidir. Bir entity class tanımlamak ve bu class ile birlikte Config,Service,Controller,Converter,Exception, Repository classlarını oluşturarak projeyi ayağa kaldırmak. Hibernate, PostgreSQL, Validation, Lombok gibi bağımlılıklar eklenerek yazılmıştır. Detaylar içerikte yer almaktadır. 


### Proje İçeriği
- Customer(entity) class oluşturuldu. Tüm fieldlar içinde annotationlar ile birlikte tanımlandı. 
- Entity içinde tanımlı field için enum class oluşturuldu.
- DTO package içinde Request-Response sorguları için class oluşturuldu.
- Request içinde add-update, response içinde CustomerResponse classı oluşturuldu. 
- Converter class içinde istek atma ve gelen isteği cevirmek için gerekli method tanımlamaları yapıldı.
- Methodlar içinde kullanmak üzere exception classlar oluşturuldu. 
- Config içinde log ve hata fırlatmak için obje ve try-catch tanımlamaları yapıldı. 
- Controller class içinde CRUD işlemleri için methodlar tanımlandı. 
- Repository class Jpa'dan kalıtım alacak şekilde tanımlandı. 
- Service içinde bir interface class oluşturuldu ve içinde uygulanacak methodlad tanımlandı.
- serviceimpl class içinde CRUD method işlemleri tanımlandı. 
- application.yml dosyası tanımlandı.PostgreSQL, Hibernate, log ve port tanımları yapıldı. (Tercihim yml dosyası kullanmak oldu)
- Pom.xml dosyası üzerinde kullanılan tüm bağımlılıklar eklendi.
