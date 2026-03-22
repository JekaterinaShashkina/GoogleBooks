# 📚 Google Books rakendus

Android rakendus raamatute otsimiseks, kasutades Google Books API-t.  
Rakendus on loodud MVVM arhitektuuri, Retrofiti ja Roomi abil.

## 🚀 Funktsionaalsus

- 🔍 Raamatute otsimine märksõna järgi
- 📚 Raamatute nimekirja kuvamine
- 📖 Detailvaade (raamatu info)
- 💾 Andmete salvestamine Room andmebaasi
- 📴 Offline töö (ilma internetita)
- 🕘 Viimased otsingud (5 viimast päringut)
- 🎯 Kiire otsingu kordamine recent queries kaudu

## 🏗 Arhitektuur

Rakendus on üles ehitatud **MVVM (Model-View-ViewModel)** põhimõttel:

- **UI (Compose)** — andmete kuvamine
- **ViewModel** — seisundi haldus
- **Repository** — andmeallikas (API + Room)
- **Data layer** — Retrofit + Room

---

## 🧰 Kasutatud tehnoloogiad

- Kotlin
- Jetpack Compose
- Retrofit (API päringud)
- Gson (JSON töötlemine)
- Room (lokaalne andmebaas)
- Hilt (Dependency Injection)
- Coroutines + StateFlow

## 🌐 API

Kasutatakse Google Books API-t:

```https://www.googleapis.com/books/v1/volumes?q={query}```


## 💾 Andmetega töö

### Online:
- andmed laetakse API-st (Retrofit)
- salvestatakse Room andmebaasi

### Offline:
- andmed loetakse lokaalsest andmebaasist

## 🔄 Otsinguajalugu

- salvestatakse viimased 5 otsingut
- kuvatakse kasutajaliideses
- võimalik klikiga otsingut korrata

## 📱 Kasutajaliides (UI)

- otsing TextField kaudu
- raamatute nimekiri (LazyColumn)
- raamatu kaardid
- detailvaade
- recent searches (chips kujul)

## 📦 Projekti struktuur
```
data/
├── local/ (Room)
├── remote/ (API)
└── mapper/

di/

domain/
├── model/
└── repository/

ui/
├── navigation/
├── components/
└── screens/

viewmodel/
```
## 🧪 Kuidas käivitada

1. Ava projekt Android Studios
2. Käivita emulaatoris või seadmes
3. Sisesta otsingusõna

## 👩‍💻 Autor

Jekaterina Shashkina