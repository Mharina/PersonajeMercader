package com.example.personaje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import java.util.Random

class Mercader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercader)
        val url = findViewById<TextView>(R.id.art)
        val comerciar: Button = findViewById(R.id.button)
        val continuar: Button = findViewById(R.id.button2)
        val arti: TextView = findViewById(R.id.art)
        val compra: Button = findViewById(R.id.compra)
        val venta: Button = findViewById(R.id.venta)
        val cancela: Button = findViewById(R.id.cancelar)
        val foto: ImageView = findViewById(R.id.imageView)
        val dbHelper2 = DatabaseHelper2(this)
        val comprar: Button = findViewById(R.id.button3)
        val insertar: EditText = findViewById(R.id.editTextText2)
        val texto: TextView = findViewById(R.id.textView12)
//        val listArtC: List<Articulo> = dbHelper2.getArticulo()
//        val arrayArC = listArtC.joinToString(separator = "\n") { it.toString() }
        val arrayArticulos = dbHelper2.getArticulo()
        val arrayArc = arrayArticulos.joinToString("\n")
        val pj = intent.getParcelableExtra<Personaje>("personaje")
        val moch = intent.getParcelableExtra<Mochila>("mochila")
        val artic = dbHelper2.getArticulo()
        //val contenidoMoch = intent.getParcelableArrayListExtra<Articulo>("contenido")

        /*contenidoMoch?.forEach {
            if (moch != null) {
                moch.addArticulo(it)
            }
        }*/
        continuar.setOnClickListener {
            var intent = Intent(this@Mercader, Aventura::class.java)
            startActivity(intent)
        }
        comerciar.setOnClickListener {
            comerciar.visibility = View.GONE
            continuar.visibility = View.GONE
            compra.visibility = View.VISIBLE
            venta.visibility = View.VISIBLE
            cancela.visibility = View.VISIBLE
            cancela.setOnClickListener {
                foto.setImageResource(R.drawable.mercader)
                comerciar.visibility = View.VISIBLE
                continuar.visibility = View.VISIBLE
                foto.visibility = View.VISIBLE
                arti.visibility = View.GONE
                compra.visibility = View.GONE
                venta.visibility = View.GONE
                cancela.visibility = View.GONE
                comprar.visibility = View.GONE
                insertar.visibility = View.GONE
                texto.visibility = View.GONE
            }
            compra.setOnClickListener {
                cancela.setOnClickListener {
                    foto.setImageResource(R.drawable.mercader)
                    comerciar.visibility = View.VISIBLE
                    continuar.visibility = View.VISIBLE
                    foto.visibility = View.VISIBLE
                    arti.visibility = View.GONE
                    compra.visibility = View.GONE
                    venta.visibility = View.GONE
                    cancela.visibility = View.GONE
                    comprar.visibility = View.GONE
                    insertar.visibility = View.GONE
                    texto.visibility = View.GONE
                }
                arti.visibility = View.VISIBLE
                var ale = Random()
                var num = ale.nextInt(10)
                var imagen = artic[num].getImg()
                var ruta = resources.getIdentifier(imagen,"drawable",packageName)
                url.text = imagen

                arti.text = artic[num].toString()
                foto.setImageResource(ruta)
            }
            venta.setOnClickListener {
                cancela.setOnClickListener {
                    foto.setImageResource(R.drawable.mercader)
                    comerciar.visibility = View.VISIBLE
                    continuar.visibility = View.VISIBLE
                    arti.visibility = View.GONE
                    compra.visibility = View.GONE
                    venta.visibility = View.GONE
                    cancela.visibility = View.GONE
                    comprar.visibility = View.GONE
                    insertar.visibility = View.GONE
                    texto.visibility = View.GONE
                }
                arti.visibility = View.VISIBLE
                foto.setImageResource(R.drawable.mochila)
                foto.visibility = View.VISIBLE
                arti.text= moch.toString()
            }
        }
    }
}