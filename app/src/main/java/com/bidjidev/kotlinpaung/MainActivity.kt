package com.bidjidev.kotlinpaung

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
var hasil = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnpesan.setOnClickListener { view ->
            val nama = edNama.text.toString()
            if (nama.isEmpty()){
                Toast.makeText(this,"Nama anda belum diisi",Toast.LENGTH_LONG).show()
            }else if (hasil == 0){
                Toast.makeText(applicationContext,"Tidak bisa memesan 0 seblak",Toast.LENGTH_LONG).show()

            }else{
                tampilhasil(hasil,5000,nama)
            }
        }
        btntambah.setOnClickListener { view ->
            tambah()
        }
        btnkurang.setOnClickListener { view ->
            kurang()
        }
    }
    private fun tambah(){
        if (hasil == 100){
            Toast.makeText(applicationContext,"Tidak bisa memesan lebih dari 100 seblak",Toast.LENGTH_LONG).show()
        }else {
            hasil = hasil + 1
            txtbanyak.text = "" + hasil
        }
    }
    private fun kurang(){
        if (hasil == 0){
            Toast.makeText(applicationContext,"Tidak bisa memesan kurang dari 0 seblak",Toast.LENGTH_LONG).show()
        }else {
            hasil = hasil - 1
            txtbanyak.text = "" + hasil
        }
    }
//    untuk menampilkan harga
    public fun tampilhasil(banyak:Int,harga:Int,nama:String):String{
        val namapemesan = "Pemesan : $nama"
        val banyakpesanan = "\nbanyak:"+banyak
        val total = "\ntotal harga : " + harga * banyak +"rp"
    val muncul = namapemesan + banyakpesanan + total
    txthasil.text = muncul
    return "tidak ada order"
    }
}
