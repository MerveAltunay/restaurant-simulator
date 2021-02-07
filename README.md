# Restaurant simulator using multithread in java

Restoranda 2 tane şef, 3 tane garson ve 5 tane de masa bulunuyor. Restoran sürekli açık ve
müşteriler restorana gelip boş masalara oturup garsonlara sipariş veriyor. Garsonlar da siparişleri şeflere iletip daha 
sonra hazır olan siparişleri masalara dağıtıyor. Her müşterinin masada belli bir süre oturma hakkı olduğunu düşünelim.
Vakti dolan müşteri masadan kalkar ve yeni müşteriler restorana girer. Her masada bir müşteri oturabildiğini ve müşterilerin 
teker teker restorana geldiğini varsayalım. Her müşteri istediği kadar sipariş verebilir ama masada oturma süresi limitli.

Burada önemli olan gerçek hayatta olduğu gibi masalarda oturan müşterilerin, sipariş alan garsonların ve siparişleri hazırlayan
şeflerin gerçekten olduğu gibi birbirlerinden bağımsız çalışabilmesi ve her işlem sırasında ve sonrasında simulasyonun doğru
çalıştığını anlayabilmemiz için uygun logların ekrana basılması gerekir.
