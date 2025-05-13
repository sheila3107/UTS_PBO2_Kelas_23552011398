# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: {Sheila Nur Hamidah}</li>
  <li>NIM: {23552011398}</li>
  <li>Studi Kasus: {Kasir Asuransi}</li>
</ul>

## Judul Studi Kasus
<p>Kasir Asuransi.</p>

## Penjelasan Studi Kasus
<p>Membuat sistem kasir asuransi, untuk pengeloaan premi dan klaim asuransi. Dengan database Nasabah (id, nama, umur), polis (id, nasabah_id, jenis, premi), klaim (id, polis_id, tanggal, status)..</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Inheritance (Pewarisan)
Inheritance digunakan saat Anda memiliki kelas Polis yang merupakan kelas induk (superclass) untuk berbagai jenis polis asuransi. Kelas-kelas seperti PolisAsuransiKesehatan, PolisAsuransiPendidikan, dan PolisAsuransiJiwa adalah subclass yang mewarisi sifat-sifat dari kelas Polis.
•	Penerapan Konsep dalam Studi kasus Asuransi:

class PolisAsuransiKesehatan extends Polis { 
public PolisAsuransiKesehatan() {
 super("Asuransi Kesehatan", 150.00); 
}
 }
Di sini, PolisAsuransiKesehatan mewarisi semua atribut dan metode dari Polis, seperti jenis dan premi..</p>

### 2. Encapsulation
<p>Encapsulation (Enkapsulasi)
Encapsulation digunakan untuk membatasi akses langsung ke atribut kelas. Dalam kelas Polis, atribut jenis dan premi dideklarasikan sebagai protected, sehingga hanya dapat diakses oleh subclass dan kelas dalam paket yang sama. Namun, untuk akses dari luar, Anda menyediakan metode getter.
•	Penerapan Konsep dalam Studi kasus Asuransi:
protected String jenis;
protected double premi;

public String getJenis() {
    return jenis;
}

public double getPremi() {
    return premi;
}

Dengan cara ini, konsumsi atribut dilakukan melalui metode publik, yang menjaga integritas data..</p>

### 3. Polymorphism
<p>Polymorphism (Polimorfisme)
Polymorphism terlihat saat Anda menggunakan tipe data Polis untuk menyimpan objek dari subclass-nya. Anda dapat memanggil metode yang sama (displayDetails()) pada objek dari berbagai subclass.
•	Penerapan Konsep dalam Studi kasus Asuransi:
Polis polis = new PolisAsuransiKesehatan();
 polis.displayDetails(); // Memanggil metode yang diimplementasikan di subclass
Di sini, meskipun polis dideklarasikan sebagai tipe Polis, ia menunjuk ke objek PolisAsuransiKesehatan, dan metode yang tepat akan dipanggil sesuai dengan implementasi di subclass.
.</p>

### 4. Abstract
<p>Abstraction (Abstraksi)
Abstraction terlihat pada kelas Polis yang dideklarasikan sebagai kelas abstrak. Metode displayDetails() didefinisikan tetapi tidak diimplementasikan di kelas Polis. Setiap subclass harus menyediakan implementasi spesifik untuk metode tersebut.
•	Penerapan Konsep dalam Studi kasus Asuransi:
public abstract void displayDetails();
Dengan cara ini, pengguna kelas Polis tidak harus mengetahui detail implementasi dari setiap jenis polis asuransi. Mereka hanya perlu tahu bahwa setiap jenis polis akan memiliki cara untuk menampilkan detailnya..</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/8JRiJcsiSD0">Youtube</a></li>
</ul>
